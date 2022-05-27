package cn.medigical.publish.pojo.highcharts;

public class Highchart {
	String time;
	long date;
	String color;
	String title;
	String subtitle;
	String[] categories;

	
	public Highchart(String title, String subtitle, String[] categories) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.categories = categories;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public Highchart() {
		super();
	}

	public Highchart(String time, long date, String color) {
		super();
		this.time = time;
		this.date = date;
		this.color = color;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
