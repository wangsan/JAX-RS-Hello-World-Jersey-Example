package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    		notes="It's a really simple command."+
    				"Here's some Markdown documentation: \n\n"+
    				"Markdown can do cool stuff like:\n"+
    				"* Bulleted lists\n"+
    				"* Inline `code examples`\n"+
    				"  * Sub-lists\n"+
    				"  * Sub-lists\n\n"+
    				"## Even tables!\n\n"+
    				"| Tables | Are | Cool |\n"+
    				"| ---- |:----:| ----:|\n"+
    				"| col 3 is | right-aligned | $1600 |\n"+
    				"| col 2 is | centered | $12 |\n"+
    				"| zebra stripes | are neat | $1 |")
	public Response getMsg(
			@PathParam("param") 
			@ApiParam(value="This is a string that you put in the URL.", required=true)
			String msg) {

		String output = "Your path parameter was : " + msg;

		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/simpleJSONReturn")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value="This command returns a JSON object",
			response=SimpleJSONResponse.class)
	public Response simpleJSONReturn(){
		SimpleJSONResponse responseJSON = new SimpleJSONResponse();
		responseJSON.setVar1("Hello!");
		responseJSON.setVar2(35);
		return Response.status(200).entity(responseJSON).build();
	}
	

	@POST
	@Path("/simpleJSONPost")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value="Post a JSON file and get a response",
			response=SimplePostSuccessResponse.class,
			notes="##Pass something interesting!"
			)
	@ApiResponses(
			value = {
					@ApiResponse(code = 400, message = "Invalid input"),
					@ApiResponse(code = 200, message = "It's all good")
			})
	public Response simpleJSONPost(
			@ApiParam(value="Input JSON", required=true)
			MyTestJSONObject inputJson
			){
		String output;
//		try {
			SimplePostSuccessResponse jsonResponse = new SimplePostSuccessResponse();
			output = "Hello! I got your JSON input. The value of thing_id is "+inputJson.getThing_id()+
					" and the value of thing_value is "+inputJson.getThing_value();
			jsonResponse.setMessage(output);
			jsonResponse.setMessageNumber(new Integer(12));
//		} catch (JSONException e) {
//			String errorMessage = "Bad JSON!";
//			return Response.status(400).entity(errorMessage).build();
//		}
		return Response.status(200).entity(jsonResponse).build();
	}
	
	@GET
	@Path("/responseCodeTest")
	@ApiOperation(
			value="Test response codes",
			notes="This method is for testing response codes."
			)
	@ApiResponses(
			value = {
					@ApiResponse(code = 400, message = "Invalid input"),
					@ApiResponse(code = 200, message = "That was a good parameter")
			})
	public Response responseCodeTest(
			@ApiParam(value="Send 200 for a 200 response or something else for a 400 response")
			@QueryParam("queryParam")
			String queryParam
			){
		if (queryParam.equals("200")){
			return Response.status(200).entity("OK!").build();
		}else{
			return Response.status(400).entity("No. You sent "+queryParam).build();
		}
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
