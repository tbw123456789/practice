package cn.medigical.publish.pojo.patientLink;

import cn.medigical.publish.interfaces.his.hishezhouguangji.adapter.EmrPngMapMapAdapter;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.ReturnStatusMsg;
import cn.medigical.publish.pojo.chuFang.ChuFangDan;

import cn.medigical.publish.pojo.hezhouyiyuan.TableForHeZhouGuangJiEY;
import cn.medigical.publish.pojo.patient.Patient;
import cn.medigical.publish.pojo.patient.PatientDrugs;
import cn.medigical.publish.pojo.patient.PatientEvents;
import cn.medigical.publish.pojo.quality.QualityPojo;
import cn.medigical.publish.pojo.quality.rongchang.TableForRongChangEY;
import cn.medigical.publish.pojo.quality.tianshui.TableForGuangXiTianShuiEY;
import cn.medigical.publish.pojo.vitalSign.VitalSignShow;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by 2018-06-07.
 */
@Document(collection="patientLink")
public class PatientLink {

	List<PatientEvents> patientEventsList = new ArrayList<>();

	List<PatientDrugs> patientDrugsList = new ArrayList<>();

	@XmlJavaTypeAdapter(EmrPngMapMapAdapter.class)
	Map<String,byte[]> emrPngMap;

	public List<PatientEvents> getPatientEventsList() {
		return patientEventsList;
	}

	public void setPatientEventsList(List<PatientEvents> patientEventsList) {
		this.patientEventsList = patientEventsList;
	}

	public List<PatientDrugs> getPatientDrugsList() {
		return patientDrugsList;
	}

	public void setPatientDrugsList(List<PatientDrugs> patientDrugsList) {
		this.patientDrugsList = patientDrugsList;
	}

	@XmlTransient
	public Map<String, byte[]> getEmrPngMap() {
		if(emrPngMap == null)
		{
			emrPngMap = new HashMap<>();
		}
		return emrPngMap;
	}

	public void setEmrPngMap(Map<String, byte[]> emrPngMap) {
		this.emrPngMap = emrPngMap;
	}

	//his同步排班的状态
	@Field(value="syncStatu")
	private String syncStatu;

	private String id;
	@Field(value="hisID")
	private String hisID;
	@Field(value="feiBie")
	private String feiBie;
	@Field(value="infectedPatient")
	private boolean infectedPatient = false;
	@Field(value="createDate")
	private Date createDate;
	@Field(value="patient")
	private Patient patient;
	@Field(value="status")
	private Status status;
	@Field(value="application")
	private Application application;
	@Field(value="schedule")
	private Schedule schedule;
	@Field(value="anesthesiaRecord")
	private AnesthesiaRecord anesthesiaRecord;
	@Field(value="vitalSignShow")
	private VitalSignShow VitalSignShow;
	@Field(value="pacu")
	private Pacu pacu;
	@Field(value="chuFangDan")
	private ChuFangDan ChuFangDan;
	@Field(value="postoperativeAnalgesia")
	private PostoperativeAnalgesia PostoperativeAnalgesia;
	@Field(value="qualityPojo")
	private QualityPojo qualityPojo;
	@Field(value="tableForRongChangEY")
	private TableForRongChangEY tableForRongChangEY;
	@Field(value="tableForGuangXiTianShuiEY")
	private TableForGuangXiTianShuiEY tableForGuangXiTianShuiEY;
	@Field(value = "tableForHeZhouGuangJiEY")
	private TableForHeZhouGuangJiEY tableForHeZhouGuangJiEY;
	@Field(value="gongfen")
	private GongFenZhiBiaoRC gongfen;
	@Field(value="lastodifyAccunt")
	private Account lastodifyAccunt;
	@Field(value="lastodifyTime")
	private Date lastodifyTime;
	@Field(value="returnStatusMsg")
	private ReturnStatusMsg returnStatusMsg;

	public TableForHeZhouGuangJiEY getTableForHeZhouGuangJiEY() {
		if(tableForHeZhouGuangJiEY==null){
			tableForHeZhouGuangJiEY=new TableForHeZhouGuangJiEY();
		}
		return tableForHeZhouGuangJiEY;
	}

	public void setTableForHeZhouGuangJiEY(TableForHeZhouGuangJiEY tableForHeZhouGuangJiEY) {
		this.tableForHeZhouGuangJiEY = tableForHeZhouGuangJiEY;
	}



	public TableForGuangXiTianShuiEY getTableForGuangXiTianShuiEY() {
		if (tableForGuangXiTianShuiEY == null){
			tableForGuangXiTianShuiEY = new TableForGuangXiTianShuiEY();
		}
		return tableForGuangXiTianShuiEY;
	}

	public void setTableForGuangXiTianShuiEY(TableForGuangXiTianShuiEY tableForGuangXiTianShuiEY) {
		this.tableForGuangXiTianShuiEY = tableForGuangXiTianShuiEY;
	}

	public TableForRongChangEY getTableForRongChangEY() {
		if(tableForRongChangEY == null){
			tableForRongChangEY = new TableForRongChangEY();
		}
		return tableForRongChangEY;
	}

	public void setTableForRongChangEY(TableForRongChangEY tableForRongChangEY) {
		this.tableForRongChangEY = tableForRongChangEY;
	}

	public ReturnStatusMsg getReturnStatusMsg() {
		return returnStatusMsg;
	}
	public void setReturnStatusMsg(ReturnStatusMsg returnStatusMsg) {
		this.returnStatusMsg = returnStatusMsg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHisID() {
		return hisID;
	}
	public void setHisID(String hisID) {
		this.hisID = hisID;
	}
	public String getFeiBie() {
		return feiBie;
	}
	public void setFeiBie(String feiBie) {
		this.feiBie = feiBie;
	}
	public boolean isInfectedPatient() {
		return infectedPatient;
	}
	public void setInfectedPatient(boolean infectedPatient) {
		this.infectedPatient = infectedPatient;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Patient getPatient() {
		if (patient==null) {
			patient=new Patient();
		}
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Status getStatus() {
		if (status==null) {
			status=new Status();
		}
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Application getApplication() {
		if (application==null) {
			application=new Application();
		}
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public Schedule getSchedule() {
		if (schedule==null) {
			schedule=new Schedule();
		}
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public AnesthesiaRecord getAnesthesiaRecord() {
		if (anesthesiaRecord==null) {
			anesthesiaRecord=new AnesthesiaRecord();
		}
		return anesthesiaRecord;
	}
	public void setAnesthesiaRecord(AnesthesiaRecord anesthesiaRecord) {
		this.anesthesiaRecord = anesthesiaRecord;
	}
	public VitalSignShow getVitalSignShow() {
		return VitalSignShow;
	}
	public void setVitalSignShow(VitalSignShow vitalSignShow) {
		VitalSignShow = vitalSignShow;
	}

	public Pacu getPacu() {
		if (pacu == null){
			pacu = new Pacu();
		}
		return pacu;
	}

	public void setPacu(Pacu pacu) {
		this.pacu = pacu;
	}

	public ChuFangDan getChuFangDan() {
		return ChuFangDan;
	}
	public void setChuFangDan(ChuFangDan chuFangDan) {
		ChuFangDan = chuFangDan;
	}
	public PostoperativeAnalgesia getPostoperativeAnalgesia() {
		return PostoperativeAnalgesia;
	}
	public void setPostoperativeAnalgesia(PostoperativeAnalgesia postoperativeAnalgesia) {
		PostoperativeAnalgesia = postoperativeAnalgesia;
	}

	public String getSyncStatu() {
		return syncStatu;
	}

	public void setSyncStatu(String syncStatu) {
		this.syncStatu = syncStatu;
	}

	public QualityPojo getQualityPojo() {
		return qualityPojo;
	}
	public void setQualityPojo(QualityPojo qualityPojo) {
		this.qualityPojo = qualityPojo;
	}
	public GongFenZhiBiaoRC getGongfen() {
		return gongfen;
	}
	public void setGongfen(GongFenZhiBiaoRC gongfen) {
		this.gongfen = gongfen;
	}
	public Account getLastodifyAccunt() {
		return lastodifyAccunt;
	}
	public void setLastodifyAccunt(Account lastodifyAccunt) {
		this.lastodifyAccunt = lastodifyAccunt;
	}
	public Date getLastodifyTime() {
		return lastodifyTime;
	}
	public void setLastodifyTime(Date lastodifyTime) {
		this.lastodifyTime = lastodifyTime;
	}
	@Override
	public String toString() {
		return "PatientLink [id=" + id + ", hisID=" + hisID + ", feiBie=" + feiBie + ", InfectedPatient="
				+ infectedPatient + ", CreateDate=" + createDate + ", patient=" + patient + ", status=" + status
				+ ", application=" + application + ", schedule=" + schedule + ", anesthesiaRecord=" + anesthesiaRecord
				+ ", VitalSignShow=" + VitalSignShow + ", Pacu=" + pacu + ", ChuFangDan="
				+ ChuFangDan + ", PostoperativeAnalgesia=" + PostoperativeAnalgesia
				+ ", gongfen=" + gongfen + ", lastodifyAccunt=" + lastodifyAccunt + ", lastodifyTime=" + lastodifyTime
				+ "]";
	}


}
