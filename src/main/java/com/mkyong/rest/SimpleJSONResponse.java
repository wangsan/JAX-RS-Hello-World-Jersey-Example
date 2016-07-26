package com.mkyong.rest;

import io.swagger.annotations.ApiModelProperty;

public class SimpleJSONResponse {
	
	String var1; 
	Integer var2;
	
	@ApiModelProperty(example="Some string value - it's not important")
	public String getVar1() {
		return var1;
	}
	public void setVar1(String var1) {
		this.var1 = var1;
	}
	
	@ApiModelProperty(example="Some integer value -- it's really important")
	public Integer getVar2() {
		return var2;
	}
	public void setVar2(Integer var2) {
		this.var2 = var2;
	}
	
	

}
