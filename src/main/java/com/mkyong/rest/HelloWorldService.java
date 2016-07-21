package com.mkyong.rest;

import io.swagger.annotations.*;
import io.swagger.util.Json;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/hello")
@Api(value="/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
    @ApiOperation(
    		value="This command prints the message that you include in the {param} URL parameter.",
    		notes="It's a really simple command.")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Yor path parameter was : " + msg;

		return Response.status(200).entity(output).build();

	}
	
	@POST
	@Path("/simplePost")
	@Consumes({MediaType.APPLICATION_JSON})
//	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value="Post a JSON file and get a response",
			notes="##Pass something interesting!\n"+
			"This is a simple method I wrote to test posting JSON and documenting it with Swagger.\n\n"+
			"Markdown can do cool stuff like:\n"+
			"* Bulleted lists\n"+
			"* Inline `code examples`\n\n"+
			"  * Sub-lists\n"+
			"  * Sub-lists\n\n"+
			"## Even tables!\n\n"+
			"| Tables | Are | Cool |\n"+
			"| ---- |:----:| ----:|\n"+
			"| col 3 is | right-aligned | $1600 |\n"+
			"| col 2 is | centered | $12 |\n"+
			"| zebra stripes | are neat | $1 |"
			)
	@ApiResponses(
			value = { 
					@ApiResponse(code = 400, message = "Invalid input"),
					@ApiResponse(code = 200, message = "It's all good")
			})
	public Response simplePost(
			@ApiParam(value="Input JSON", required=true)
			MyTestJSONObject inputJson
			){
		String output;
//		try {
			output = "Hello! I got your file.\nThe value of thing_id is "+inputJson.getThing_id()+
					"\nand the value of thing_value is "+inputJson.getThing_value();
//		} catch (JSONException e) {
//			String errorMessage = "Bad JSON!";
//			return Response.status(400).entity(errorMessage).build();
//		}
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
