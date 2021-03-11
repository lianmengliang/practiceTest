package com.example.exception;

import com.example.base.MgResultCode;
import com.example.enums.MgAdError;
import lombok.Data;

/**
 * @Author ： leo
 * @Date :2020/5/18 15:49
 */
@Data
public class MgException extends RuntimeException {

    private MgAdError mgError;
    private String code;
    private String msg;
    private String error;

    public MgException(MgAdError mgError) {
        this.mgError = mgError;
    }

    public MgException(MgResultCode mgResultCode) {
        this.code = mgResultCode.getCode();
        this.msg = mgResultCode.getDesc();
    }


    public MgException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MgException(String code, String msg, String error) {
        this.code = code;
        this.msg = msg;
        this.error = error;
    }
}
