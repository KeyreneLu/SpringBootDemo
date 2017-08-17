package com.keyrene.enums;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
public enum ResultEnum {
    NONE_ERROR("-1","未知错误"),
    SUCCESS("0","成功"),
    PRIMARY_SCHOOL("101","你还在上小学吧"),
    MIDDLE_SCHOOL("102","你还在上初中吧")
    ;

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
