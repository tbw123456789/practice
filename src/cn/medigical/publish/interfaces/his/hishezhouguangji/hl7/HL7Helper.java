package cn.medigical.publish.interfaces.his.hishezhouguangji.hl7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v24.datatype.TS;
import ca.uhn.hl7v2.parser.PipeParser;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.ZD11;
import org.apache.log4j.Logger;

/**
 * @author SamJoke
 */
public class HL7Helper {

    private static Method method = null;

    private static Logger logger = Logger.getLogger("HL7Helper");

    static {
        try {
            method = AbstractSegment.class.getDeclaredMethod("add", Class.class, boolean.class, int.class, int.class,
                    Object[].class, String.class);
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义添加AbstractSegment类的字段类型，然后可以用getFeild方法进行赋值,例子参考:
     * testSegmentAddFeildRequest()
     *
     * @param obj
     *            AbstractSegment对象
     * @param c
     *            数据类型
     * @param required
     *            是否必填
     * @param maxReps
     *            数组长度
     * @param length
     *            字节长度
     * @param constructorArgs
     *            构造器
     * @param name
     *            字段名
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static void segmentAddFeild(AbstractSegment obj, Class<? extends Type> c, boolean required, int maxReps,
                                       int length, Object[] constructorArgs, String name)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        method.invoke(obj, c, required, maxReps, length, constructorArgs, name);
    }

    public static void segmentAddFeild(AbstractSegment obj, Class<? extends Type> c, int maxReps, int length,
                                       Message msg) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        segmentAddFeild(obj, c, false, maxReps, length, new Object[] { msg }, "user define");
    }

    public static void segmentAddFeild(AbstractSegment obj, Class<? extends Type> c, int length, Message msg)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        segmentAddFeild(obj, c, false, 1, length, new Object[] { msg }, "user define");
    }

//    public static void segmentAddFeild(AbstractSegment obj, HL7DataType hl7DateType, Message msg)
//            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//        segmentAddFeild(obj, hl7DateType.getCls(), false, hl7DateType.getMaxReps(), hl7DateType.getLength(),
//                new Object[] { msg }, "user define");
//    }

    @SuppressWarnings("unchecked")
    public static <T> T getField(AbstractSegment obj, int pos, int index, Class<T> cls) throws HL7Exception {
        return (T) obj.getField(pos, index);
    }

    /**
     * 将hl7str协议报文转换为指定的Message类(可自定义)，例子参考:testSegmentAddFeildResponse()
     *
     * @param msg
     *            Message类型，如ADT_A01
     * @param hl7str
     *            HL7协议报文
     * @throws HL7Exception
     */
    public static void acceptResponse(Message msg, String hl7str) throws HL7Exception {
        PipeParser p = new PipeParser();
        p.parse(msg, hl7str);
    }

    public static String getMsgValue(Message msg, String segName, int... ints) throws HL7Exception {
        return getMsgValue(msg, 0, segName, ints);
    }

    public static String getMsgValue(Message msg, Class<? extends AbstractSegment> segCls, int... ints)
            throws HL7Exception {
        return getMsgValue(msg, 0, segCls.getSimpleName(), ints);
    }

    public static List<Structure> getStructureList(AbstractMessage abstractMessage,Class<?> cls) throws HL7Exception {
        List<Structure> structureArrayList = new ArrayList<>();
        int i = 0;
        Structure structure = abstractMessage.get(cls.getSimpleName(),i);
        if(!structure.isEmpty()){
            structureArrayList.add(structure);
        }
        while (!structure.isEmpty()){
            i++;
            structure = abstractMessage.get(cls.getSimpleName(),i);
            structureArrayList.add(structure);
        }
        return structureArrayList;
    }

    /**
     *
     * 获取Message里面的数据，例子参考testGetMsgValue()
     *
     * @param msg
     *            Message类型
     * @param struIndex
     *            AbstractSegment数组位，比如PID有重复多个的话需要自己设置位置，默认传0进去
     * @param segName
     *            AbstractSegment名，如PID、MSH等
     * @param ints
     *            具体位置，如new int[]{3,2,3}
     * @return
     * @throws HL7Exception
     */
    public static String getMsgValue(Message msg, int struIndex, String segName, int... ints) throws HL7Exception {
        AbstractSegment stru = (AbstractSegment) msg.get(segName, struIndex);

        int segPos = 0;

        int composIndex = 0;

        if (ints.length <= 0) {
            segPos = 0;
            composIndex = 0;
        } else if (ints.length == 1) {
            segPos = ints[0];
            composIndex = 0;
        } else {
            segPos = ints[0];
            composIndex = ints[1];
        }

        Type itetype = stru.getField(segPos, composIndex);

        for (int i = 2; i < ints.length; i++) {
            if (itetype instanceof AbstractPrimitive) {
                break;
            } else if (itetype instanceof AbstractComposite) {
                AbstractComposite coms = (AbstractComposite) itetype;
                itetype = coms.getComponent(ints[i]);
            }
        }

        return itetype.encode();
    }

    public static void setMsgValue(Message msg, String segName, String value, int... ints) throws HL7Exception {
        setMsgValue(msg, 0, segName, value, ints);
    }

    public static void setMsgValue(Message msg, Class<? extends AbstractSegment> segCls, String value, int... ints)
            throws HL7Exception {
        setMsgValue(msg, 0, segCls.getSimpleName(), value, ints);
    }

    public static void setMsgValue(Message msg, Object segCls, String value, int... ints)
            throws HL7Exception {
        setMsgValue(msg, 0, segCls.getClass().getSimpleName(), value, ints);
    }

    /**
     *
     * 设置Message里面的数据，例子参考testSetMsgValue()
     *
     * @param msg
     *            Message类型
     * @param struIndex
     *            AbstractSegment数组位，比如PID有重复多个的话需要自己设置位置，默认传0进去
     * @param segName
     *            AbstractSegment名，如PID、MSH等
     * @param value
     *            设置值
     * @param ints
     *            具体位置，如new
     *            int[]{3,2,3}，需要注意这里的位置，要根据上面的segName类的init方法里面Type的排序和类型来确定，是否支持这样的定位(层级)，若不支持则会抛异常,
     *
     *            如果int长度为0，设置0位,0组件
     *            ，如果长度为1，设置ints[0]位,第0个组件
     *            ，如果长度为2，设置ints[0]位第ints[1]个组件值
     *            ，如果长度为2以上，设置int[0]位第ints[i]个组件的第一个组件
     * @return
     * @throws HL7Exception
     */
    public static void setMsgValue(Message msg, int struIndex, String segName, String value, int... ints)
            throws HL7Exception {
        AbstractSegment stru = (AbstractSegment) msg.get(segName, struIndex);

        int segPos = 0;

        int composIndex = 0;

        if (ints.length <= 0) {
            segPos = 0;
            composIndex = 0;
        } else if (ints.length == 1) {
            segPos = ints[0];
            composIndex = 0;
        } else {
            segPos = ints[0];
            composIndex = ints[1];
        }

        Type itetype = stru.getField(segPos, composIndex);

        //用户自定义Type
        if(itetype instanceof Varies){
            itetype = ((Varies) itetype).getData();
        }

        if(ints.length >= 2){
            if(itetype instanceof AbstractPrimitive){
                ((AbstractPrimitive) itetype).setValue(value);
            }else{
                Type currentType = itetype;
                for(int i = 1;i< ints.length;i++){
                    currentType = getAbstractComposite(currentType,value,i,ints);
                }
            }
        }
    }

    private static Type getAbstractComposite(Type itetype,String value,int index,int... composIndex) throws HL7Exception {
        Type retChildType = null;
        if(itetype != null) {
            if (index != composIndex.length - 1) {
                if (itetype instanceof AbstractComposite) {
                    retChildType = ((AbstractComposite) itetype).getComponent(composIndex[index]);
                } else {
                    ((AbstractPrimitive) itetype).setValue(value);
                }
            } else {
                if (itetype instanceof AbstractPrimitive) {
                    ((AbstractPrimitive) itetype).setValue(value);
                } else {
                    Type lastNode = ((AbstractComposite) itetype).getComponent(composIndex[index]);
                    if (lastNode instanceof AbstractPrimitive) {
                        ((AbstractPrimitive) lastNode).setValue(value);
                    } else {
                        logger.error("最后一个节点不为组件，请检查层级关系！！！");
                        throw new HL7Exception("node level error !!!");
                    }
                }
            }
        }else{
            logger.error("这里没有该节点");
            throw new HL7Exception("node error !!!");
        }
        return retChildType;
    }

}