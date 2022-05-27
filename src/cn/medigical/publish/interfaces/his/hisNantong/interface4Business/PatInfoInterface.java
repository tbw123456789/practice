 package cn.medigical.publish.interfaces.his.hisNantong.interface4Business;

 import cn.medigical.publish.interfaces.his.hisNantong.cmd.CMDgetPatInfo;
 import cn.medigical.publish.interfaces.his.hisNantong.stub.SendCmdSvr;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.patinfo.ITEMType;
 import org.apache.log4j.Logger;

 public class PatInfoInterface
 {
   private Logger logger = Logger.getLogger("PatInfoInterface");
 
   public ITEMType getPatInfo(String pid, String visitId) {
     SendCmdSvr sendCmdSvr = new SendCmdSvr();
     boolean iniOK = sendCmdSvr.initial();
     if (!iniOK) {
       return null;
     }
     return getPatInfo(sendCmdSvr, pid, visitId);
   }
 
   public ITEMType getPatInfo(SendCmdSvr sendCmdSvr, String pid, String visitId) {
     if ((null == pid) || (pid.length() == 0) || (null == visitId) || (visitId.length() == 0) || (null == sendCmdSvr)) {
       return null;
     }
 
     CMDgetPatInfo cmDgetPatInfo = new CMDgetPatInfo();
     cmDgetPatInfo.setCxlx("1");
     cmDgetPatInfo.setPatID(pid);
     cmDgetPatInfo.setVisitID(visitId);
     try {
       sendCmdSvr.sendCmd(cmDgetPatInfo);
       return cmDgetPatInfo.getItemType();
     } catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }return null;
   }
 
   public ITEMType getPatInfoWS(SendCmdSvr sendCmdSvr, String cxlx, String zyh, String pid, String visitId)
   {
     if (null == sendCmdSvr) {
       return null;
     }
     CMDgetPatInfo cmDgetPatInfo = new CMDgetPatInfo();
     cmDgetPatInfo.setPatID(pid);
     cmDgetPatInfo.setCxlx(cxlx);
     cmDgetPatInfo.setZyh(zyh);
     cmDgetPatInfo.setVisitID(visitId);
     try {
       sendCmdSvr.sendCmd(cmDgetPatInfo);
       return cmDgetPatInfo.getItemType();
     } catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }return null;
   }
 }

