 package cn.medigical.publish.interfaces.his.hisNantong.interface4Business;

 import cn.medigical.publish.interfaces.his.hisNantong.cmd.CMDgetOperName;
 import cn.medigical.publish.interfaces.his.hisNantong.stub.SendCmdSvr;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.surgeryname.ITEMType;
 import org.apache.log4j.Logger;

 public class OperNameInterface
 {
   private Logger logger = Logger.getLogger("OperNameInterface");
 
   public ITEMType getOperName(String pid, String zycs, String scheduleId) {
     SendCmdSvr sendCmdSvr = new SendCmdSvr();
     boolean iniOK = sendCmdSvr.initial();
     if (!iniOK) {
       return null;
     }
     return getOperName(sendCmdSvr, pid, zycs, scheduleId);
   }
 
   public ITEMType getOperName(SendCmdSvr sendCmdSvr, String pid, String zycs, String scheduleId) {
     if ((null == pid) || (pid.length() == 0) || (null == zycs) || (zycs.length() == 0) || (null == scheduleId) || 
       (scheduleId
       .length() == 0) || (null == sendCmdSvr))
     {
       return null;
     }
 
     CMDgetOperName cmDgetOperName = new CMDgetOperName();
     cmDgetOperName.setPid(pid);
     cmDgetOperName.setZycs(zycs);
     cmDgetOperName.setScheduleID(scheduleId);
     try {
       sendCmdSvr.sendCmd(cmDgetOperName);
       return cmDgetOperName.getItemType();
     } catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }return null;
   }
 }

