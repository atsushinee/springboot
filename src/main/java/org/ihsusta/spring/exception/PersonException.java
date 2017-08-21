package org.ihsusta.spring.exception;

import org.ihsusta.spring.enums.ResultEnum;

public class PersonException extends RuntimeException {
    private Integer code;

    public PersonException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
