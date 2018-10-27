package com.qihui.common.enums;

/**
 * @author chenqihui
 * @date 2018/10/27
 */
public enum ErrorCodeEnum {

    GL99999999(99999999, "参数异常"),
    UAC10010001(10010001, "请重新登录"),

    ;

    private int code;
    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ErrorCodeEnum getEnum(int code) {
        for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
            if (ele.getCode() == code) {
                return ele;
            }
        }
        return null;
    }
}
