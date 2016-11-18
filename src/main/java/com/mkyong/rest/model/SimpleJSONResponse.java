package com.mkyong.rest.model;

import io.swagger.annotations.ApiModelProperty;

public class SimpleJSONResponse {

    String var1;
    Integer var2;

    @ApiModelProperty(example = "Some string value - it's not important", required = true)
    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    @ApiModelProperty(example = "Some integer value -- it's really important", required = true)
    public Integer getVar2() {
        return var2;
    }

    public void setVar2(Integer var2) {
        this.var2 = var2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SimpleJSONResponse{");
        sb.append("var1='").append(var1).append('\'');
        sb.append(", var2=").append(var2);
        sb.append('}');
        return sb.toString();
    }
}
