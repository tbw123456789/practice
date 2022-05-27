 package cn.medigical.publish.interfaces.his.hisNantong.interface4Business;

 import cn.medigical.publish.interfaces.his.hisNantong.cmd.CMDgetDept;
 import cn.medigical.publish.interfaces.his.hisNantong.stub.SendCmdSvr;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.dept.ITEMType;
 import org.apache.log4j.Logger;

 import java.util.List;

 public class DeptInterface
 {
   private Logger logger = Logger.getLogger("DeptInterface");
 
   public List<ITEMType> getDepts() {
     SendCmdSvr sendCmdSvr = new SendCmdSvr();
     boolean iniOK = sendCmdSvr.initial();
     if (!iniOK) {
       return null;
     }
 
     return getDepts(sendCmdSvr);
   }
 
   public List<ITEMType> getDepts(SendCmdSvr sendCmdSvr) {
     if (null == sendCmdSvr) return null;
     CMDgetDept cmDgetDept = new CMDgetDept();
     try {
       sendCmdSvr.sendCmd(cmDgetDept);
       return cmDgetDept.getItemTypeList();
     } catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }return null;
   }
 }

