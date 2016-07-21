package com.mkyong.rest;

import io.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
@Api(value="/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
    @ApiOperation(
    		value="This command prints the message that you include in the {param} URL parameter.",
    		notes="It's a really simple command.")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/hidden")
	@ApiOperation(
			value="This is a hidden method that you should not see in the API doc",
			hidden=true)
	public Response hiddenCommand(){
		String output = "You found the hidden method!";
		return Response.status(200).entity(output).build();
	}

}
