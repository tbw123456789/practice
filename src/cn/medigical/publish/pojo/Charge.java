package cn.medigical.publish.pojo;

public class Charge {
    private String id;
    /*收费项目id*/
    private String Shoufeiid;
    /*收费项目名称*/
    private String Name;
    /*收费项目规格*/
    private String Spec;
    /*收费项目用量数量*/
    private String Amount;
    /*收费项目计量单位*/
    private  String Unit;
    /*收费项目计量价格*/
    private String Price;
    /*收费项目计量备注*/
    private String Beizhu;
    /*收费项目计量状态*/
    private String Status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShoufeiid() {
		return Shoufeiid;
	}
	public void setShoufeiid(String shoufeiid) {
		Shoufeiid = shoufeiid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSpec() {
		return Spec;
	}
	public void setSpec(String spec) {
		Spec = spec;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getBeizhu() {
		return Beizhu;
	}
	public void setBeizhu(String beizhu) {
		Beizhu = beizhu;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

    
}
