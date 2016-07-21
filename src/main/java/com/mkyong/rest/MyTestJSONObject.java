package com.mkyong.rest;

public class MyTestJSONObject {
	
	String thing_id; 
	String thing_value;
	
	public String getThing_id() {
		return thing_id;
	}

	public void setThing_id(String thing_id) {
		this.thing_id = thing_id;
	}

	public String getThing_value() {
		return thing_value;
	}

	public void setThing_value(String thing_value) {
		this.thing_value = thing_value;
	}

	@Override
	public String toString() {
		return "[thing_id=" + thing_id + ", thing_value=" + thing_value + "]";
	}

}
