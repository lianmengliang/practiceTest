package com.example.enums;

/**
 * Created with IntelliJ IDEA.
 * AUTHOR: ws
 * DATE : 2019/12/4 16:21
 * DESCRIPTION: CPA任务审核类型
 */
public enum CpaTaskReviewTypeEnum implements CodeEnum {

    FILL_IN_THE_BLANKS(2, "填空"),
    CHOICE(3, "选择"),
    SCREENSHOT(4, "截图"),
    ;

    private Integer code;
    private String desc;

    CpaTaskReviewTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CpaTaskReviewTypeEnum convert(Integer status) {
        switch (status) {
            case 2:
                return FILL_IN_THE_BLANKS;
            case 3:
                return CHOICE;
            case 4:
                return SCREENSHOT;
            default:
                return SCREENSHOT;
        }
    }

}
