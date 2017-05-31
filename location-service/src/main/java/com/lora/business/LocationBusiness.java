package com.lora.business;

import java.sql.SQLException;
import java.util.Set;
import com.google.gson.Gson;
import com.lora.data.*;


public class LocationBusiness {

	public static Set<NodeLocationObject> getAllLocations() throws SQLException{
			return GetLocationData.getAllLocations();
	}
	
	public static NodeLocationObject getLocationByNode(int nodeId) throws SQLException{
		return GetLocationData.getLocationByNode(nodeId);
	}
	
	public static int setNode(String jsonNode){
		
		Gson gson = new Gson();
		NodeLocationObject newNode = gson.fromJson(jsonNode, NodeLocationObject.class);
		
		return SetLocationData.setNode(newNode);
	}
	
	public static int deleteNode(int nodeId){
		return SetLocationData.deleteNode(nodeId);
	}

	public static int deleteAllNodes(){
		return SetLocationData.deleteAllNodes();
	}
	
	public static int updateNode(String jsonNode){
		
		Gson gson = new Gson();
		NodeLocationObject newNode = gson.fromJson(jsonNode, NodeLocationObject.class);
		
		return SetLocationData.updateNode(newNode);
	}



}
