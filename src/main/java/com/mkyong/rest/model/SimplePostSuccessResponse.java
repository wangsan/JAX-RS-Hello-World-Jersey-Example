package com.mkyong.rest.model;

import io.swagger.annotations.ApiModelProperty;

public class SimplePostSuccessResponse {
	
	Integer messageNumber; 
	String message;
	
	@ApiModelProperty(example="The message number, such as 1234")
	public Integer getMessageNumber() {
		return messageNumber;
	}
	public void setMessageNumber(Integer messageNumber) {
		this.messageNumber = messageNumber;
	}
	@ApiModelProperty(example="The response message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
