package org.ihsusta.spring.utils;

import org.ihsusta.spring.damain.Result;

public class ResultUtil {

    public static Result<Object> success(Object object) {
        Result<Object> result = new Result<>();
        result.setCode(0);
        result.setMsg("SUCCESS");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result<Object> error(Integer code, String msg) {
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
