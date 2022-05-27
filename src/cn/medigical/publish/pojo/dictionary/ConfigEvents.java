package cn.medigical.publish.pojo.dictionary;


public class ConfigEvents {
    private String id;
    /** 事件名称 */
    private String name;
    /** 事件编号 */
    private String code;
    /** 事件类型ID */
    private String eventTypeCode;
    /** 显示位置 */
    private Integer position;
    /** 是否是单次事件 */
    private Boolean single;
    /** 删除标志 */
    private Boolean deleted;


    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEventTypeCode() {
		return eventTypeCode;
	}

	public void setEventTypeCode(String eventTypeCode) {
		this.eventTypeCode = eventTypeCode;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Boolean getSingle() {
		return single;
	}

	public void setSingle(Boolean single) {
		this.single = single;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
