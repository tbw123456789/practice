package cn.medigical.publish.pojo;

import java.util.Date;

public class Bedside {
	  private String id;
	    private String pDBid;
	    private String code;
	    private Date time;
	    private Date editTime;
	    private Integer intVal;
	    private Float fVal;
	    private String name;
	    private String strVal;
	    private Integer floatCount;
	    private String dataType;
	    private String unitCode;
	    private String status; // input, confirmed , deleted
	    private String valid ;
	    private String editUser;
	    private String parentID;
//	    private BedsideSingleTestInfo singleTestInfo;
//	    private List<EditHistory> history;
	    private String eventCode;
	    private String eventExeID;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getpDBid() {
			return pDBid;
		}
		public void setpDBid(String pDBid) {
			this.pDBid = pDBid;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
		public Date getEditTime() {
			return editTime;
		}
		public void setEditTime(Date editTime) {
			this.editTime = editTime;
		}
		public Integer getIntVal() {
			return intVal;
		}
		public void setIntVal(Integer intVal) {
			this.intVal = intVal;
		}
		public Float getfVal() {
			return fVal;
		}
		public void setfVal(Float fVal) {
			this.fVal = fVal;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getStrVal() {
			return strVal;
		}
		public void setStrVal(String strVal) {
			this.strVal = strVal;
		}
		public Integer getFloatCount() {
			return floatCount;
		}
		public void setFloatCount(Integer floatCount) {
			this.floatCount = floatCount;
		}
		public String getDataType() {
			return dataType;
		}
		public void setDataType(String dataType) {
			this.dataType = dataType;
		}
		public String getUnitCode() {
			return unitCode;
		}
		public void setUnitCode(String unitCode) {
			this.unitCode = unitCode;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getValid() {
			return valid;
		}
		public void setValid(String valid) {
			this.valid = valid;
		}
		public String getEditUser() {
			return editUser;
		}
		public void setEditUser(String editUser) {
			this.editUser = editUser;
		}
		public String getParentID() {
			return parentID;
		}
		public void setParentID(String parentID) {
			this.parentID = parentID;
		}
		public String getEventCode() {
			return eventCode;
		}
		public void setEventCode(String eventCode) {
			this.eventCode = eventCode;
		}
		public String getEventExeID() {
			return eventExeID;
		}
		public void setEventExeID(String eventExeID) {
			this.eventExeID = eventExeID;
		}

}
