package cn.medigical.publish.pojo.zhikong;

public class SeriesData {
	private String color;
	private long y;
	public SeriesData() {
		super();
	}
	public SeriesData(long y,String color) {
		super();
		this.color = color;
		this.y = y;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}
}
