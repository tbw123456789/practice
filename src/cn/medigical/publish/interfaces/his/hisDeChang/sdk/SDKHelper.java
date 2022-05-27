//package cn.medigical.publish.interfaces.his.hisDeChang.sdk;
//
//import com.isynergy.esbsdk.mq.QueueTools;
//import com.isynergy.esbsdk.mq.SdkException;
//import com.isynergy.esbsdk.mq.mode.CloseInterface;
//import com.isynergy.esbsdk.mq.mode.MqMessage;
//import com.isynergy.esbsdk.mq.mode.MsgListener;
//
//import javax.jms.JMSException;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.TimeUnit;
//
//public class SDKHelper {
//
//    public static CloseInterface closeInterface;// 监听器对象，建议一个服务对象持久化，可进行关闭操作
//    public static QueueTools queueTools;  // QueueTools持久化不用关闭
//    private static SDKHelper instance;
//    public static ConcurrentMap<String, String> idMap = new ConcurrentHashMap<>();//消息Id与消息内容，建议持久化，若多客户端需要有统一的存储
//
//    public static SDKHelper getInstance() {
//        if (instance == null) {
//            instance = new SDKHelper();
//        }
//        return instance;
//    }
//
//    public SDKHelper() {
//        try {
//            queueTools = new QueueTools();// 连接MQ，获取队列管理器实例，该实例如果不调用方法进行断开操作可长期保持连接。
//        } catch (SdkException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void putReqAndGetResp(String fid, String reqMsg) {
//        // 请求数据
//        try {
//            // 发送请求消息
//            String id = queueTools.send(reqMsg);
//            //等待获取消息
//            long time = System.currentTimeMillis();
//            try {
//                while (System.currentTimeMillis() < time + 10000 && idMap.get(id) == null) {
//                    TimeUnit.SECONDS.sleep(1);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            String msg = idMap.get(id);//取到消息
//            System.out.println("msg="+msg);//业务操作
//            if(msg!=null){
//                SDKTool.judge(fid, msg);
//            }
//        } catch (SdkException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 关闭监听
//     */
//    public static void closeListener() {
//        if (null != closeInterface) {
//            try {
//                closeInterface.close();
//            } catch (JMSException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * 关闭queueTools，建议QueueTools持久化不用关闭
//     */
//    public static void close() {
//        //关闭监听
//        if (null != closeInterface) {
//            try {
//                closeInterface.close();
//            } catch (JMSException e) {
//                e.printStackTrace();
//            }
//        }
//        //断开MQ连接
//        if (null != queueTools) {
//            try {
//                queueTools.close();
//            } catch (SdkException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    public void SendMsg(String fid, String msg) {
//        try {
//            //queueTools = new QueueTools();// 连接MQ，获取队列管理器实例，该实例如果不调用方法进行断开操作可长期保持连接。
//            MsgListener msgListener = new MsgListener() {
//                @Override
//                public void onMessage(MqMessage message) {
//                    idMap.put(message.getId(), message.getMsg());//获取信息写入消息存储
//                }
//            };
//            closeInterface = queueTools.receive("S09", fid, msgListener);
//            putReqAndGetResp(fid, msg);
//        } catch (SdkException e) {
//            e.printStackTrace();
//            close();//建议持久化，不关闭
//        }
//    }
//}
//
