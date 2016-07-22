package com.mkyong.rest;

import io.swagger.annotations.ApiModelProperty;

public class SomeOtherJSONObject {
	
	Integer someInteger;
	String someString;
	TestEnum someEnum;
	Integer someIntegerWithRange;
	
	@ApiModelProperty(
			value="This is an integer with no restrictions.")
	public Integer getSomeInteger() {
		return someInteger;
	}
	public void setSomeInteger(Integer someInteger) {
		this.someInteger = someInteger;
	}
	
	@ApiModelProperty(
			value="This is a string with no restrictions.")
	public String getSomeString() {
		return someString;
	}
	public void setSomeString(String someString) {
		this.someString = someString;
	}
	
	@ApiModelProperty(
			value="This is an enumeration",
			allowableValues="PENDING,ACTIVE,INACTIVE,DELETED")
	public TestEnum getSomeEnum() {
		return someEnum;
	}
	public void setSomeEnum(TestEnum someEnum) {
		this.someEnum = someEnum;
	}
	
	@ApiModelProperty(
			value="This is an integer from 1-5.",
			allowableValues="range[1,5]"
			)
	public Integer getSomeIntegerWithRange() {
		return someIntegerWithRange;
	}
	public void setSomeIntegerWithRange(Integer someIntegerWithRange) {
		this.someIntegerWithRange = someIntegerWithRange;
	}
	
	@Override
	public String toString(){
		return "someInteger: "+this.getSomeInteger() + "\n"+
				"someString: "+this.getSomeString()+ "\n"+
				"someEnum; "+this.getSomeEnum()+ "\n"+
				"someIntegerWithRange: "+this.getSomeIntegerWithRange();
	}
	
	

}
