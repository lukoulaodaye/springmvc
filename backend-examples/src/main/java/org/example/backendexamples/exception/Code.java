package org.example.backendexamples.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter          //因为是枚举，所以只调用就行
@RequiredArgsConstructor
public enum Code {
    LOGIN_ERROR(Code.ERROR, "用户名密码错误"),
    BAD_REQUEST(Code.ERROR, "请求错误"),
    UNAUTHORIZED(401, "未登录"),
    TOKEN_EXPIRED(403, "过期请重新登录"),
    FORBIDDEN(403, "无权限");

    public static final int ERROR = 400;

    private final int code;//业务码
    private final String message;//异常信息


}
