 package cn.medigical.publish.interfaces.his.hisNantong.interface4Business;

 import cn.medigical.publish.interfaces.his.hisNantong.cmd.CMDgetJYJGXM;
 import cn.medigical.publish.interfaces.his.hisNantong.stub.SendCmdSvr;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType;
 import org.apache.log4j.Logger;

 import java.util.ArrayList;
 import java.util.List;

 public class JYJGXMInterface
 {
   private Logger logger = Logger.getLogger("JYJGXMInterface");
 
   public List<ITEMType> getJianYanJGXM(String pid, String visitId) {
     SendCmdSvr sendCmdSvr = new SendCmdSvr();
     boolean iniOK = sendCmdSvr.initial();
     if (!iniOK) {
       return new ArrayList();
     }
     return getJianYanJGXM(sendCmdSvr, pid, visitId);
   }
 
   public List<ITEMType> getJianYanJGXM(SendCmdSvr sendCmdSvr, String pid, String visitId) {
     if ((null == pid) || (pid.length() == 0) || (null == visitId) || (visitId.length() == 0) || (null == sendCmdSvr)) {
       return new ArrayList();
     }
     CMDgetJYJGXM cmDgetJYJGXM = new CMDgetJYJGXM();
     cmDgetJYJGXM.setPid(pid);
     cmDgetJYJGXM.setZycs(visitId);
     cmDgetJYJGXM.setCxlx("1");
     try {
       sendCmdSvr.sendCmd(cmDgetJYJGXM);
       return cmDgetJYJGXM.getItemTypeList();
     } catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }return null;
   }
 
   public List<ITEMType> getJianYanJGXM(SendCmdSvr sendCmdSvr, String cxlx, String zyh, String pid, String visitId)
   {
     if (null == sendCmdSvr) {
       return new ArrayList();
     }
     CMDgetJYJGXM cmDgetJYJGXM = new CMDgetJYJGXM();
     cmDgetJYJGXM.setPid(pid);
     cmDgetJYJGXM.setZycs(visitId);
     cmDgetJYJGXM.setCxlx(cxlx);
     cmDgetJYJGXM.setZyh(zyh);
     try {
       sendCmdSvr.sendCmd(cmDgetJYJGXM);
       return cmDgetJYJGXM.getItemTypeList();
     } catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }return null;
   }
 }

