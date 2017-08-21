package org.ihsusta.spring.handle;

import org.ihsusta.spring.damain.Result;
import org.ihsusta.spring.enums.ResultEnum;
import org.ihsusta.spring.exception.PersonException;
import org.ihsusta.spring.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof PersonException) {
            PersonException personException = (PersonException) e;
            return ResultUtil.error(personException.getCode(), personException.getMessage());
        } else {
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }
}
