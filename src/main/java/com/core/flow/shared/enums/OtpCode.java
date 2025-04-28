package com.core.flow.shared.enums;

public enum OtpCode {
    OTP_CREATION_SUCCESS("OTP_CREATION_SUCCESS"),
    OTP_CREATION_FAILURE("OTP_CREATION_FAILURE"),
    OTP_VERIFIED("OTP_VERIFIED"),
    ENTITY_ID_MISSING("ENTITY_ID_MISSING"),
    INVALID_ENTITY_TOKEN_FORMAT("INVALID_ENTITY_TOKEN_FORMAT"),
    NO_OTP_FOUND("NO_OTP_FOUND"),
    PROFILE_NOT_FOUND("PROFILE_NOT_FOUND"),
    INVALID_OTP_EXCEPTION("INVALID_OTP_EXCEPTION");

    private final String code;
    OtpCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
