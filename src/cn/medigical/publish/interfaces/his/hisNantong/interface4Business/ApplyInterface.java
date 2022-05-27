 package cn.medigical.publish.interfaces.his.hisNantong.interface4Business;

 import cn.medigical.publish.interfaces.his.hisNantong.cmd.CMDgetApply;
 import cn.medigical.publish.interfaces.his.hisNantong.stub.SendCmdSvr;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.apply.ITEMType;
 import org.apache.log4j.Logger;

 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;

 public class ApplyInterface
 {
   private Logger logger = Logger.getLogger("ApplyInterface");
   public static final String DATE_FORMAT_STR_YMDHMS = "yyyy-MM-dd HH:mm:ss";
   public static final SimpleDateFormat DATE_FORMAT_YMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
   public List<ITEMType> getApplySchedule(Date startTime, Date endTime) {
     SendCmdSvr sendCmdSvr = new SendCmdSvr();
     boolean iniOK = sendCmdSvr.initial();
     if (!iniOK) {
       return new ArrayList();
     }
     return getApplySchedule(sendCmdSvr, startTime, endTime);
   }
 
   public List<ITEMType> getApplySchedule(SendCmdSvr sendCmdSvr, Date startTime, Date endTime) {
     String startTimeStr = null;
     String endTimeStr = null;
     try {
       startTimeStr = DATE_FORMAT_YMDHMS.format(startTime);
       endTimeStr = DATE_FORMAT_YMDHMS.format(endTime);
     } catch (Exception ex) {
     }
     if ((null == startTimeStr) || (null == endTimeStr) || (null == sendCmdSvr)) return new ArrayList();
 
     CMDgetApply cmDgetApply = new CMDgetApply();
     cmDgetApply.setTime(startTimeStr, endTimeStr);
     try {
       sendCmdSvr.sendCmd(cmDgetApply);
       return cmDgetApply.getItemTypeList();
     } catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }
     return new ArrayList();
   }
 }

