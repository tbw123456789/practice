package cn.medigical.publish.pojo.zhikong;


public class ZhikongMessage {
	//private Map<String,List<ZhikongMessage>> mothdata=new TreeMap<String,List<ZhikongMessage>>();
	private String name;
	private String na;
	private int num;
	private Double per=0.0;
	private int count;
	private String date;
	
	public ZhikongMessage(String name, String na) {
		super();
		this.name = name;
		this.na = na;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Double getPer() {
		return per;
	}
	public void setPer(Double per) {
		this.per = per;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ZhikongMessage(String name, int num, Double per, int sum,String na) {
		super();
		this.name = name;
		this.num = num;
		this.per = per;
		this.count = sum;
		this.na=na;
	}
	public ZhikongMessage() {
	}
	public String getNa() {
		return na;
	}
	public void setNa(String na) {
		this.na = na;
	}
	 
	
}
