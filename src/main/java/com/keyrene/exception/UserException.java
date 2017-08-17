package com.keyrene.exception;

import com.keyrene.enums.ResultEnum;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
public class UserException extends RuntimeException {

    private String code;

//    public UserException(String code,String message) {
//        super(message);
//        this.code = code;
//    }

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
