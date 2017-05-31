package com.lora.rest;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.lora.business.LocationBusiness;

//TODO: migrate data conversion to business layer

@Path("location")
public class LocationServices {

	@GET
	@Path("all")
	public Response getAllLocations() throws SQLException{
		Gson gson = new Gson();
		String json = gson.toJson(LocationBusiness.getAllLocations());
		
		return Response.status(200).entity(json).build();
	}
	
	@GET
	@Path("id/{id}")
	public Response getLocationByNode(@PathParam("id") String id) throws SQLException{
		Gson gson = new Gson();
		int nodeId = Integer.parseInt(id);
		String json = gson.toJson(LocationBusiness.getLocationByNode(nodeId));
		return Response.status(200).entity(json).build();
	}
	
	@POST
	@Path("setnode")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setNode(String json) { 
		LocationBusiness.setNode(json);
		return Response.status(200).entity("This node was saved: " + json).build();
	}
	
	@DELETE
	@Path("delete/{id}")
	public Response deleteNode(@PathParam("id") String id){
		
		if (id.equals("all")) LocationBusiness.deleteAllNodes();
		else LocationBusiness.deleteNode(Integer.parseInt(id));
		
		return Response.status(200).entity("Node deleted").build();
		
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateNode(String json){
		
		LocationBusiness.updateNode(json);
		return Response.status(200).entity("Node updated").build();
	}
	
	
}
