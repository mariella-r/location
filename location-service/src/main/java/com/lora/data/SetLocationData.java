package com.lora.data;

import com.lora.business.NodeLocationObject;

public class SetLocationData {

	public static int setNode(NodeLocationObject nodeLoc){
		
		String update = "insert into node_location values (" 
						+ nodeLoc.getNodeId() 
						+ ", "
						+ nodeLoc.getLongitude()
						+ ", "
						+ nodeLoc.getLatitude()
						+");";
		
		return PostgresConnection.executeUpdate(update);
		
	}
	
	public static int deleteNode(int nodeId){

		String update = "delete from node_location where id='"+nodeId+"';";
		return PostgresConnection.executeUpdate(update);
	}
	
	public static int deleteAllNodes(){
		String update = "delete from node_location;";
		return PostgresConnection.executeUpdate(update);
	}
	
	public static int updateNode(NodeLocationObject nodeLoc){
		String update = "update node_location set longitude='"
				+ nodeLoc.getLongitude() 
				+"', latitude='"
				+ nodeLoc.getLatitude()
				+"' where id='"
				+ nodeLoc.getNodeId()
				+"';";
		return PostgresConnection.executeUpdate(update);
	}
}
