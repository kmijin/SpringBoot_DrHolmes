package com.pillgood.drholmes.api.pill;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "header")
//@Root(name = "header", strict = false)
public class HeaderClass {
    @PropertyElement(name="resultCode")
    String resultCode;
    @PropertyElement(name="resultMsg")
    String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
