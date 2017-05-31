package com.lora.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.lora.data.TestDB;

@Path("test")
public class RestTest {

	@GET
	@Path("getmsg")
	public Response getMsg(){//@PathParam("param") String msg) {

		//String output = "Jersey say : " + msg;

		String output = TestDB.dbtest();
		
		return Response.status(200).entity(output).build();

	}
	
}
