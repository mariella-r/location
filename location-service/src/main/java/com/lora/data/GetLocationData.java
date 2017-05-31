package com.lora.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.lora.business.NodeLocationObject;

//TODO: Remove all unused imports

public class GetLocationData {

	public static NodeLocationObject getLocationByNode(int nodeId) throws SQLException{
		
		NodeLocationObject node = null;
		String query = null;
		ResultSet result = null;
		
		query = "select * from node_location where id='" + nodeId + "';";
		result = PostgresConnection.executeQuery(query);
		
		result.next();
		
		node = new NodeLocationObject(Integer.parseInt(result.getString("id")),Double.parseDouble(result.getString("longitude")),Double.parseDouble(result.getString("latitude")));
		
		result.close();
		
		return node;	
	}
	
	public static Set<NodeLocationObject> getAllLocations() throws SQLException{
		
		Set<NodeLocationObject> set = null;
		String query = null;
		ResultSet result = null;
		NodeLocationObject node = null;		
		
		query = "select * from node_location;";
		result = PostgresConnection.executeQuery(query);
		
		set = new HashSet<NodeLocationObject>();
		
		while(result.next()){
			node = new NodeLocationObject(Integer.parseInt(result.getString("id")),Double.parseDouble(result.getString("longitude")),Double.parseDouble(result.getString("latitude")));
			set.add(node);
		} 
		
		result.close();
		
		return set;
		
	}
	
}
