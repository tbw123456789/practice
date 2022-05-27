package cn.medigical.publish.pojo.dictionary;


public class ConfigAnesMethods {
    private String id;
    private String code;
    private String name;
    private Boolean deleted;
	private String groupCode;
	private Float gfc;
	private Float gfxs;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public Float getGfc() {
		return gfc;
	}

	public void setGfc(Float gfc) {
		this.gfc = gfc;
	}

	public Float getGfxs() {
		return gfxs;
	}

	public void setGfxs(Float gfxs) {
		this.gfxs = gfxs;
	}
}
