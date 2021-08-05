package com.example.enums;

/**
 * CPA任务审核状态
 * @author ReveeWu
 */
public enum CpaTaskReviewStatusEnum implements CodeEnum {

    UNAUDITED(0, "未审核"),
    AUDIT_PASS(1, "审核通过"),
    AUDIT_FAILED(2, "拒绝"),
    ;

    private Integer code;
    private String desc;

    CpaTaskReviewStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CpaTaskReviewStatusEnum convert(Integer status) {
        switch (status) {
            case 1:
                return AUDIT_PASS;
            case 2:
                return AUDIT_FAILED;
            case 0:
            default:
                return UNAUDITED;
        }
    }

}
