package com.keyrene.handle;

import com.keyrene.domain.Result;
import com.keyrene.exception.UserException;
import com.keyrene.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof UserException){
            UserException userException = (UserException)e;
            return ResultUtil.fail(userException.getCode()+"",userException.getMessage()+"");
        }else {
            return ResultUtil.fail("-1","未知错误.");
        }

    }
}
