package com.lora.business;

public class NodeLocationObject {

	private int nodeId;
	private double longitude;
	private double latitude;
	
	public NodeLocationObject(int id, double lon, double lat){
		nodeId = id;
		longitude = lon;
		latitude = lat;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	
	//TODO
	//public void display(){}
	
}
