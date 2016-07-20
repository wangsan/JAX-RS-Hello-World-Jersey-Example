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
  //@Value("This command prints the message that you include in the {param} URL parameter.")
  @ApiOperation(value="This command prints the message that you include in the {param} URL parameter.")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}

}
