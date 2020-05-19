package com.example.base;


/**
 * Created with IntelliJ IDEA. PACKAGE_NAME:com.xw.ad.common.base AUTHOR: hexOr DATE :2019/3/30 14:41
 * DESCRIPTION:adwall项目使用的响应码
 */
public enum MgResultCode implements ResultCode {

    //-100 跳转到安卓10以下手机与ios手机设备号信息提示页
    DEVICEID_EXPRIED_ERR("-100", "对应渠道", "未获取设备信息，请先授权APP"),
    DEVICEID_VAILD_ERR("-100", "对应渠道", "未获取设备信息，请先授权APP"),

    CHANNEL_COOPERATE_ERR("9000", "渠道（有积分/无积分）状态校验错误", "渠道已停止合作"),
    KEYCODE_EXPRIED_ERR("10000", "keycode参数缺失", "未获取手机信息，请先授权APP"),
    KEYCODE_PARAMETER_EXPIRED_ERR("10001", "request中对应uri校验的keycode参数为空", "未获取手机信息，请先授权APP"),
    KEYCODE_VAILD_ERR("10002", "校验keycode不匹配或者请求uri没有匹配上", "未获取手机信息，请先授权APP"),
    PTYPE_EXPRIED_ERR("10003", "ptype参数为空", "未获取手机信息，请先授权APP"),
    PTYPE_VAILD_ERR("10004", "ptype参数不是1或者2", "手机信息获取异常，请重试"),

    APPID_EXPRIED_ERR("10006", "appid参数为空", "未获取应用信息，请先授权APP"),
    APPID_VAILD_ERR("10007", "appid参数不正确", "未获取应用信息，请先授权APP"),

    VALIDATE_FID_ERR("10037", "apk渠道编号不能为空"),
    VALIDATE_DEVICEID_ERR("10038", "设备id不能为空"),
    VALIDATE_SIMID_ERR("10039", "SIMID不能为空"),
    VALIDATE_GAMEUSERID_ERR("10040", "用户注册账号ID不能为空"),
    VALIDATE_GAMENAME_ERR("10041", "用户注册账号不能为空"),
    VALIDATE_ADID_ERR("10042", "广告id不能为空"),
    VALIDATE_KEYCODE_ERR("10043", "keyCode不能为空"),
    VALIDATE_IP_ERR("10044", "ip不能为空"),
    VALIDATE_KEYCODEFORMAT_ERR("10045", "keyCode校验失败,请检查"),
    VALIDATE_DEVICEIDT_ERR("10046", "设备号格式有误"),
    VALIDATE_ADIDDECODE_ERR("10047", "广告id解密异常"),
    VALIDATE_ADIDFORMAT_ERR("10048", "广告id格式有误请检查"),
    VALIDATE_USEREXIST_ERR("10049", "该期用户已注册"),
    VALIDATE_ADIDCANNOTWORK_ERR("10050", "广告未投放"),
    VALIDATE_DEVICEIDBIND_ERR("10051", "暂时未找到该设备的绑定记录，过段时间再试"),


    KEYCODE_REQUIRED_ERR("20010", "keycode参数不存在", "参数错误,请检查"),
    ORDERNUM_REQUIRED_ERR("20020", "orderNumber参数错误", "参数错误,请检查"),
    AD_REWARD_SET_ERR("20030", "广告未设置奖励", "广告未设置奖励"),
    AD_DOWNLOAD_URL_ERR("20040", "广告下载链接为空", "广告下载链接为空"),
    AD_APPID_LIMIT("20050", "渠道有限制该广告", "渠道限制该广告"),
    ;
    /**
     * 错误码
     */
    private String code;

    /**
     * 描述
     */
    private String desc;

    /**
     * 显示错误内容
     */
    private String view;


    MgResultCode(String code, String desc, String view) {
        this.code = code;
        this.desc = desc;
        this.view = view;
    }

    MgResultCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
        this.view = desc;
    }

    public static MgResultCode getResultEnum(String code) {
        for (MgResultCode result : values()) {
            if (result.getCode().equalsIgnoreCase(code)) {
                return result;
            }
        }
        return null;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
