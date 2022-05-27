package cn.medigical.publish.pojo.patientLink;


import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by 2018-06-07.
 *
 */

public class Status {
    private Integer totalPage;
    private Integer pacuPage;

    /**当前手术状态*/
	@Field(value="flag")
    private String Flag ;
    private String afterShuHouflag;
    private Date readyTime;
    private Date admitTime;
    private Date dischargeTime;
    /**麻醉单起始时间*/
    private Date anesRecordStartTime;
    @Field(value="inRoomTime")
    private Date inRoomTime;
    private Date outRoomTime;
    private Date cancelTime;
    /**麻醉开始时间*/
    private Date mazuiStartTime; // 用于统计用，应该是和麻醉开始、结束事件是绑定的，但是有可能麻醉医生没有添加相应事件
    private String mazuiStartTimeString;// ?

	private Date mazuiEndTime;
    private long mazuiSpanTime; // 精确到分钟
    private Date operStartTime;
    private Date operEndTime;
    private long operSpanTime;  // 精确到分钟
    private boolean maZuiQianHeCha;//三方核查麻醉前
    private boolean shouShuQianHeCha;//三方核查手术前
    private boolean liShiQianHeCha;//三方核查离室前
    private Date inHuiFuRoomTime;
    private Date outHuiFuRoomTime;
    private ArrayList<WhenWhoWhereWhat> PrintMazuidanTime;
    private ArrayList<WhenWhoWhereWhat> PrintChuFangTime;
    private ArrayList<WhenWhoWhereWhat> PrintShuQianTime;
    private ArrayList<WhenWhoWhereWhat> PrintShuHouTime;
    private ArrayList<WhenWhoWhereWhat> PrintOtherTime;
    /**复苏单起始时间*/
    private Date PacuStartTime;
    private Date inPacuTime;
    private Date outPacuTime;


	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPacuPage() {
		return pacuPage;
	}

	public void setPacuPage(Integer pacuPage) {
		this.pacuPage = pacuPage;
	}

	public String getFlag() {
		return Flag;
	}

	public void setFlag(String flag) {
		Flag = flag;
	}

	public String getAfterShuHouflag() {
		return afterShuHouflag;
	}

	public void setAfterShuHouflag(String afterShuHouflag) {
		this.afterShuHouflag = afterShuHouflag;
	}

	public Date getReadyTime() {
		return readyTime;
	}

	public void setReadyTime(Date readyTime) {
		this.readyTime = readyTime;
	}

	public Date getAdmitTime() {
		return admitTime;
	}

	public void setAdmitTime(Date admitTime) {
		this.admitTime = admitTime;
	}

	public Date getDischargeTime() {
		return dischargeTime;
	}

	public void setDischargeTime(Date dischargeTime) {
		this.dischargeTime = dischargeTime;
	}

	public Date getAnesRecordStartTime() {
		return anesRecordStartTime;
	}

	public void setAnesRecordStartTime(Date anesRecordStartTime) {
		this.anesRecordStartTime = anesRecordStartTime;
	}

	public Date getInRoomTime() {
		return inRoomTime;
	}

	public void setInRoomTime(Date inRoomTime) {
		this.inRoomTime = inRoomTime;
	}

	public Date getOutRoomTime() {
		return outRoomTime;
	}

	public void setOutRoomTime(Date outRoomTime) {
		this.outRoomTime = outRoomTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Date getMazuiStartTime() {
		return mazuiStartTime;
	}

	public void setMazuiStartTime(Date mazuiStartTime) {
		this.mazuiStartTime = mazuiStartTime;
	}

	public String getMazuiStartTimeString() {
		return mazuiStartTimeString;
	}

	public void setMazuiStartTimeString(String mazuiStartTimeString) {
		this.mazuiStartTimeString = mazuiStartTimeString;
	}

	public Date getMazuiEndTime() {
		return mazuiEndTime;
	}

	public void setMazuiEndTime(Date mazuiEndTime) {
		this.mazuiEndTime = mazuiEndTime;
	}

	public long getMazuiSpanTime() {
		return mazuiSpanTime;
	}

	public void setMazuiSpanTime(long mazuiSpanTime) {
		this.mazuiSpanTime = mazuiSpanTime;
	}

	public Date getOperStartTime() {
		return operStartTime;
	}

	public void setOperStartTime(Date operStartTime) {
		this.operStartTime = operStartTime;
	}

	public Date getOperEndTime() {
		return operEndTime;
	}

	public void setOperEndTime(Date operEndTime) {
		this.operEndTime = operEndTime;
	}

	public long getOperSpanTime() {
		return operSpanTime;
	}

	public void setOperSpanTime(long operSpanTime) {
		this.operSpanTime = operSpanTime;
	}

	public boolean isMaZuiQianHeCha() {
		return maZuiQianHeCha;
	}

	public void setMaZuiQianHeCha(boolean maZuiQianHeCha) {
		this.maZuiQianHeCha = maZuiQianHeCha;
	}

	public boolean isShouShuQianHeCha() {
		return shouShuQianHeCha;
	}

	public void setShouShuQianHeCha(boolean shouShuQianHeCha) {
		this.shouShuQianHeCha = shouShuQianHeCha;
	}

	public boolean isLiShiQianHeCha() {
		return liShiQianHeCha;
	}

	public void setLiShiQianHeCha(boolean liShiQianHeCha) {
		this.liShiQianHeCha = liShiQianHeCha;
	}

	public Date getInHuiFuRoomTime() {
		return inHuiFuRoomTime;
	}

	public void setInHuiFuRoomTime(Date inHuiFuRoomTime) {
		this.inHuiFuRoomTime = inHuiFuRoomTime;
	}

	public Date getOutHuiFuRoomTime() {
		return outHuiFuRoomTime;
	}

	public void setOutHuiFuRoomTime(Date outHuiFuRoomTime) {
		this.outHuiFuRoomTime = outHuiFuRoomTime;
	}

	public ArrayList<WhenWhoWhereWhat> getPrintMazuidanTime() {
		return PrintMazuidanTime;
	}
	public void setPrintMazuidanTime(ArrayList<WhenWhoWhereWhat> printMazuidanTime) {
		PrintMazuidanTime = printMazuidanTime;
	}
	public ArrayList<WhenWhoWhereWhat> getPrintChuFangTime() {
		return PrintChuFangTime;
	}
	public void setPrintChuFangTime(ArrayList<WhenWhoWhereWhat> printChuFangTime) {
		PrintChuFangTime = printChuFangTime;
	}
	public ArrayList<WhenWhoWhereWhat> getPrintShuQianTime() {
		return PrintShuQianTime;
	}
	public void setPrintShuQianTime(ArrayList<WhenWhoWhereWhat> printShuQianTime) {
		PrintShuQianTime = printShuQianTime;
	}
	public ArrayList<WhenWhoWhereWhat> getPrintShuHouTime() {
		return PrintShuHouTime;
	}
	public void setPrintShuHouTime(ArrayList<WhenWhoWhereWhat> printShuHouTime) {
		PrintShuHouTime = printShuHouTime;
	}
	public ArrayList<WhenWhoWhereWhat> getPrintOtherTime() {
		return PrintOtherTime;
	}
	public void setPrintOtherTime(ArrayList<WhenWhoWhereWhat> printOtherTime) {
		PrintOtherTime = printOtherTime;
	}
	public Date getPacuStartTime() {
		return PacuStartTime;
	}
	public void setPacuStartTime(Date pacuStartTime) {
		PacuStartTime = pacuStartTime;
	}

	public Date getInPacuTime() {
		return inPacuTime;
	}

	public void setInPacuTime(Date inPacuTime) {
		this.inPacuTime = inPacuTime;
	}

	public Date getOutPacuTime() {
		return outPacuTime;
	}

	public void setOutPacuTime(Date outPacuTime) {
		this.outPacuTime = outPacuTime;
	}
}
