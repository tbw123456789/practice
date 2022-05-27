package cn.medigical.publish.pojo.dictionary;


public class ConfigLiquidTypes{

    private String id;
    private String name;
    private String code;
    private Integer position;
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

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
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
