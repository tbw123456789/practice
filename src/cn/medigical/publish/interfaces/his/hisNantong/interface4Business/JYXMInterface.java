 package cn.medigical.publish.interfaces.his.hisNantong.interface4Business;

 import cn.medigical.publish.interfaces.his.hisNantong.cmd.CMDgetJYXM;
 import cn.medigical.publish.interfaces.his.hisNantong.stub.SendCmdSvr;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType;
 import org.apache.log4j.Logger;

 import java.util.ArrayList;
 import java.util.List;

 public class JYXMInterface
 {
   private Logger logger = Logger.getLogger("JYXMInterface");
 
   public List<ITEMType> getJianYanXM(String testID) {
     SendCmdSvr sendCmdSvr = new SendCmdSvr();
     boolean iniOK = sendCmdSvr.initial();
     if (!iniOK) {
       return new ArrayList();
     }
     return getJianYanXM(sendCmdSvr, testID);
   }
 
   public List<ITEMType> getJianYanXM(SendCmdSvr sendCmdSvr, String testID) {
     if ((null == testID) || (testID.length() == 0) || (null == sendCmdSvr)) {
       return new ArrayList();
     }
     CMDgetJYXM cmDgetJYXM = new CMDgetJYXM();
     cmDgetJYXM.setTestID(testID);
     try {
       sendCmdSvr.sendCmd(cmDgetJYXM);
       return cmDgetJYXM.getItemTypeList();
     } catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }return null;
   }
 }

