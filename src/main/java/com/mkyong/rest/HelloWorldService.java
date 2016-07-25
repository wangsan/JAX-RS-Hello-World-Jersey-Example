package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/hello")
@Api(value="/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
    @ApiOperation(
    		value="This command prints the message that you include in the {param} URL parameter.",
    		notes="It's a really simple command.")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Your path parameter was : " + msg;

		return Response.status(200).entity(output).build();

	}

	@POST
	@Path("/simplePost")
	@Consumes({MediaType.APPLICATION_JSON})
//	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value="Post a JSON file and get a response",
			response=SimplePostSuccessResponse.class,
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
			SimplePostSuccessResponse jsonResponse = new SimplePostSuccessResponse();
			output = "Hello! I got your file. The value of thing_id is "+inputJson.getThing_id()+
					" and the value of thing_value is "+inputJson.getThing_value();
			jsonResponse.setMessage(output);
			jsonResponse.setMessageNumber(new Integer(12));
//		} catch (JSONException e) {
//			String errorMessage = "Bad JSON!";
//			return Response.status(400).entity(errorMessage).build();
//		}
		return Response.status(200).entity(jsonResponse).build();
	}

	@POST
	@Path("/paramtest")
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value="This command takes parameters and does stuff with them",
			notes="It's a slightly more complicated command.")
	@ApiResponses(
			value = {
					@ApiResponse(code = 400, message = "Invalid input"),
					@ApiResponse(code = 200, message = "It's all good")
			})
	public Response paramtest(
			@ApiParam(value="Input JSON", required=true)
			SomeOtherJSONObject inputJson
			){

		return Response.status(200).entity(inputJson.toString()).build();

	}
	
	@GET
	@Path("/pathparams/{pathParamString}")
	@ApiOperation(
			value="This command takes URL parameters and does stuff with them",
			notes="It's a *cool* `command`.")
	@ApiResponses(
			value = {
					@ApiResponse(code = 400, message = "Invalid input"),
					@ApiResponse(code = 200, message = "It's all good")
			})
	public Response pathparams(
			@ApiParam(value="This is a parameter that you put in the URL with ?queryParam{somevalue}")
			@QueryParam("queryParam")
			String queryParamString,
			@ApiParam(value="This is a parameter that you add to the base URL, as in '/hello/pathparams/{somestring}")
			@PathParam("pathParamString")
			String pathParamString,
			@ApiParam(value="This is the value of the Referer header")
			@HeaderParam("Referer")
			String referer
			){
		
		String output = "Here are the parameters you sent:\n"+
		"queryParamString: "+queryParamString+"\n"+
		"pathParamString: "+pathParamString+"\n"+
		"referer header param: "+referer;
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
