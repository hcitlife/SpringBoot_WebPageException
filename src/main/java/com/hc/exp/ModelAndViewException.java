package com.hc.exp;


/**
 * 自定义异常类型
 *
 * @author pyy
 **/
public class ModelAndViewException extends RuntimeException {
    /**
     * 异常错误编码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String msg;

    private ModelAndViewException() {
    }

    public static ModelAndViewException transfer(CustomException e) {
        return new ModelAndViewException(e.getCode(), e.getMessage());
    }

    private ModelAndViewException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
