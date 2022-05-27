package cn.medigical.publish.pojo.highcharts;

public class HighchartsMarker {
	private boolean enabled;
	private String symbol;
	
	public HighchartsMarker() {
		this.enabled = true;
	}
	
	public HighchartsMarker(String symbol) {
		super();
		this.enabled = true;
		this.symbol = symbol;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
}
