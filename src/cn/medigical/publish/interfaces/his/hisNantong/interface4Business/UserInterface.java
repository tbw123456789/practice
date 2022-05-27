 package cn.medigical.publish.interfaces.his.hisNantong.interface4Business;

 import cn.medigical.publish.interfaces.his.hisNantong.cmd.CMDgetUser;
 import cn.medigical.publish.interfaces.his.hisNantong.stub.SendCmdSvr;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.user.ITEMType;
 import org.apache.log4j.Logger;

 import java.util.List;

 public class UserInterface
 {
   private Logger logger = Logger.getLogger("UserInterface");
 
   public List<ITEMType> getUsers(String deptId) {
     SendCmdSvr sendCmdSvr = new SendCmdSvr();
     boolean iniOK = sendCmdSvr.initial();
     if (!iniOK) {
       return null;
     }
 
     return getUsers(sendCmdSvr, deptId);
   }
 
   public List<ITEMType> getUsers(SendCmdSvr sendCmdSvr, String deptId) {
     if ((null == sendCmdSvr) || (null == deptId) || (deptId.length() == 0)) return null;
     CMDgetUser cmDgetUser = new CMDgetUser();
     cmDgetUser.setDeptID(deptId);
     try {
       sendCmdSvr.sendCmd(cmDgetUser);
       return cmDgetUser.getItemTypeList();
     } catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }return null;
   }
 
   public List<ITEMType> getUser8Id(String userId)
   {
     if ((null == userId) || (userId.length() == 0)) return null;
     SendCmdSvr sendCmdSvr = new SendCmdSvr();
     boolean iniOK = sendCmdSvr.initial();
     if (!iniOK) {
       return null;
     }
 
     CMDgetUser cmDgetUser = new CMDgetUser();
     cmDgetUser.setUserID(userId);
     try {
       sendCmdSvr.sendCmd(cmDgetUser);
       return cmDgetUser.getItemTypeList();
     } catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }return null;
   }
 }

