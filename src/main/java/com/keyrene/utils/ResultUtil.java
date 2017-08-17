package com.keyrene.utils;

import com.keyrene.domain.Result;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode("200");
        result.setMsg("请求成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(String code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
