package cn.medigical.publish.pojo.highcharts;

import java.util.List;

import cn.medigical.publish.pojo.Bedside;
import cn.medigical.publish.pojo.patientLink.PatientLink;

public class Highcharts {
	private String id;
	private int[] data;
	private String[] dataId;
	private String name;
	private boolean draggableY;
	private boolean enableMouseTracking;
	private boolean visible;
	private int lineWidth;
	private int yAxis;
	private String color;
	private HighchartsMarker marker = new HighchartsMarker();
	
	public Highcharts() {
		this.enableMouseTracking = true;
		this.visible = true;
		this.draggableY = true;
		this.lineWidth = 2;
	}
	
	public Highcharts(List<Bedside> bedsideL,PatientLink operation) {
		super();
		this.data = new int[bedsideL.size()];
		this.dataId = new String[bedsideL.size()];
		for(int i=0; i<bedsideL.size(); i++){
			this.data[i] = bedsideL.get(i).getIntVal();
			this.dataId[i] = bedsideL.get(i).getId();
		}
		this.name = bedsideL.get(0).getName();
		this.id = bedsideL.get(0).getCode();
		this.lineWidth = 2;
		
		if(bedsideL.get(0).getUnitCode().equals("unit_c")){
			this.yAxis = 1;
		}else{
			this.yAxis = 0;
		}
		this.enableMouseTracking = true;
		this.visible = true;
		this.draggableY = true;
	}
	
	public int[] getData() {
		return data;
	}
	public void setData(int[] data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDraggableY() {
		return draggableY;
	}
	public void setDraggableY(boolean draggableY) {
		this.draggableY = draggableY;
	}
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public HighchartsMarker getMarker() {
		return marker;
	}
	public void setMarker(HighchartsMarker marker) {
		this.marker = marker;
	}

	public String[] getDataId() {
		return dataId;
	}

	public void setDataId(String[] dataId) {
		this.dataId = dataId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isEnableMouseTracking() {
		return enableMouseTracking;
	}

	public void setEnableMouseTracking(boolean enableMouseTracking) {
		this.enableMouseTracking = enableMouseTracking;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}
}
