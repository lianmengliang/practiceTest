package com.example.enums;


/**
 * @author Tiger
 * @date 2018/10/9
 */
public enum MgAdError {

    NETWORK_ERROR("-1", "网络错误，待会重试!"),
    XQ_BACKSTAGE_RESOURCE("-2", "您暂无权限,无法访问!"),
    XQ_PAGE_NOTEXIST("-3","页码或显示数量不能为空"),
    //报表
    XQ_AD_REPORT_NAME("-101", "报表名称不能为空!"),
    XQ_AD_REPORT_ISEXIST("-102", "报表已存在!"),
    XQ_AD_REPORT_NOTEXIST("-103", "报表不存在!"),
    XQ_AD_REPORT_MARKETER("-104", "您非该广告的市场人员，无法操作!"),
    XQ_CH_REPORT_MARKETER("-105", "您非该渠道的市场人员，无法操作!"),
    REPORT_SQL_ERROR("-105", "sql错误!"),

    //广告参数验证
    XQ_AD_ADID("-201", "广告ID不能为空!"),
    XQ_AD_NOTEXIST("-202", "广告不存在!"),
    XQ_AD_ADNAME("-203", "显示名称不能为空!"),
    XQ_AD_TITLE("-204", "广告名称不能为空!"),
    XQ_AD_STATUS("-205", "投放状态不能为空!"),
    XQ_AD_SHOWTYPE("-206", "显示状态不能为空!"),
    XQ_AD_STIME("-207", "投放时间不能为空!"),
    XQ_AD_ETIME("-208", "结束时间不能为空!"),
    XQ_AD_TIMES("-209", "投放时间不能大于结束时间!"),
    XQ_AD_PHONETYPE("-210", "试玩设备不能为空!"),
    XQ_AD_ADTYPE("-211", "广告类型不能为空!"),
    XQ_AD_PAGKNAME("-212", "应用包名称不能为空!"),
    XQ_AD_ORDER("-213", "指令错误!"),
    AD_lIMIT_ADID("-214", "被屏蔽广告ID不能为空!"),
    AD_lIMIT_ADID_NOTEXIST("-214", "被屏蔽的广告不存在!"),
    FIN_AD_CENSUS("-215", "广告未结清无法结算!"),
    AD_lIMIT_MSG("-216", "广告屏蔽消息不能为空!"),
    WELFARE_AD_NOTEXISTORSTOP_ERR("10042","当前广告不存在或状态不是已停止","领奖异常"),

    //Banner
    XQ_AD_BANNER_NOTEXIST("-301", "该广告未设置Banner图!"),

    //下载地址
    XQ_AD_DOWN_URL("-401", "下载地址不存在!"),
    XQ_AD_DOWN_URL_ISBANK("-402", "下载地址不能为空!"),
    XQ_AD_DOWN_URL_CUSTOMER("-403", "商家名称不能为空!"),
    XQ_AD_DOWN_URL_DAYFLUX("-404", "日到量限制不能为空!"),
    XQ_AD_DOWN_URL_ALLFLUX("-405", "总到量限制不能为空!"),
    XQ_AD_DOWN_URL_FLUXTIMES("-406", "到量后，第二天开始投放时间不能为空!"),

    //活动参数验证
    XQ_ACT_ID("-501", "活动ID不能为空!"),
    XQ_ACT_ID_FORMAT("-502", "活动ID格式不正确!"),
    XQ_ACT_NOTEXIST("-503", "活动不存在!"),
    XQ_ACT_NAME("-504", "活动名称不能为空!"),
    XQ_ACT_DLEVEL("-505", "奖励级别不能为空!"),
    XQ_ACT_PCOUNT("-506", "奖励人数不能为空!"),

    //活动奖励
    XQ_ACT_AWARD_SRANK("-601", "开始排名不能为空!"),
    XQ_ACT_AWARD_ERANK("-602", "结束排名不能为空!"),
    XQ_ACT_AWARD_SPE("-603", "结束排名不能小于开始排名!"),
    XQ_ACT_AWARD_MONEY("-604", "奖励金额不能为空!"),
    XQ_ACT_AWARD_PRICE("-605", "结算金额不能为空!"),
    XQ_ACT_AWARD_RANK("-606", "请检查，起始排名不能小于或等于上个奖励的结束排名!"),
    XQ_ACT_COPY("-607", "复制的广告暂无活动!"),
    XQ_ACT_AWARD_RECORD_STATUS("-609", "请选择正确的审核方式!"),
    XQ_ACT_AWARD_TYPE("-610", "奖励模式不能为空!"),
    XQ_ACT_AWARD_DEVEL("-611", "奖励级别不能为空!"),
    XQ_ACT_AWARD_DEVEL_ERROR("-612", "奖励级别不能重复!"),
    XQ_ACT_AWARD_EVENT("-613", "奖励说明不能为空!"),
    XQ_ACT_AWARD_NEEDLEVEL("-614", "等级要求不能为空!"),
    XQ_ACT_AWARD_TIIEM("-615", "奖励次数不能为空!"),
    XQ_ACT_AWARD_AMONRY("-616", "奖励金额不能为空!"),
    XQ_ACT_AWARD_AMONRY_ERROR("-617", "奖励金额不能小于等于0!"),
    XQ_ACT_AWARD_AMONRY_ERROR2("-618", "奖励金额不能大于单价!"),
    XQ_ACT_AWARD_PRICES("-619", "单价不能小于等于0!"),
    XQ_ACT_AWARD_AWARDGROUP("-620", "奖励组别不能小于等于0!"),
    XQ_ACT_AWARD_ISEXSIT("-621", "该渠道奖励已存在,无法重复添加!"),
    XQ_ACT_AWARD_TESTCH_NOTEXSIT("-622", "暂无测试渠道，无法投放!"),
    XQ_ACT_AWARD_USER("-623", "用户目前不可用，奖励失败!"),
    XQ_ACT_AWARD_ADD("-624", "添加任务奖励失败，请稍后再试或联系客服!"),
    XQ_ACT_AWARD_SUB("-625", "扣回任务奖励失败!"),
    WELFARE_QUERY_ERR("-626","查询用户的AD_ACTIVITY_RECORD奖励信息异常","领取异常"),

    //运营活动
    XQ_STATIS_STIME("-651","活动奖励结算时间不能为空，请重新输入"),
    XQ_ACT_IMGURL("-651","活动图片不能为空"),
    XQ_ACT_LINK("-652", "活动地址不能为空!"),
    XQ_ACT_TIMES("-653", "活动开始时间不能大于结束时间!"),
    XQ_ACT_TIME("-653", "活动奖励结算时间不能大于结束时间!"),


    //渠道
    XQ_CHANNEL_APPID("-701", "渠道不能为空!"),
    XQ_CHANNEL_NOTEXIST("-702", "渠道不存在!"),
    XQ_CHANNEL_NAME("-703", "渠道名称不能为空!"),
    XQ_CHANNEL_APPSECRET("-704", "密钥不能为空!"),
    XQ_CHANNEL_MARKETER("-705", "市场人员不能为空!"),
    XQ_CHANNEL_ACCOUNT("-706", "渠道账号不存在!"),
    XQ_CHANNEL_PUSH_AD("-707", "请选择要投放的广告!"),
    XQ_CHANNEL_GOOD("-708", "暂无可用渠道,无法批量添加!"),
    XQ_CHANNEL_TEST("-709", "该广告暂无测试渠道,无法批量添加!"),
    XQ_CHANNEL_ORDER_NOTEXIST("-710", "订单不存在!"),
    XQ_CHANNEL_DDOU_NOTADD("-710", "豆豆趣玩不再添加新广告!"),
    XQ_CHANNEL_ISEXIST("-711", "渠道已存在无法重复添加，请检查!"),

    //渠道订单审核
    XQ_CHANNEL_ORDER_CHECK("-711", "没有这条记录或这条记录不需要审核!"),
    XQ_CHANNEL_ORDER_VAILD("-712", "人工审核异常，状态不对!"),
    //接口
    XQ_AD_INTERF_NOTEXIST("-801", "接口不存在!"),
    XQ_AD_INTERF_URL("-802", "接口地址不能为空!"),
    XQ_AD_INTERF_JSONS("-803", "判断状态值参数不能为空!"),
    XQ_AD_INTERF_JSONV("-804", "状态值不能为空!"),
    XQ_AD_INTERF_MERID("-805", "用户ID参数不能为空!"),
    XQ_AD_INTERF_MERNAME("-806", "用户账号参数不能为空!"),
    XQ_AD_INTERF_METHOD("-807", "请求方式不能为空!"),
    XQ_AD_INTERF_STATUS("-808", "接口状态不能为空!"),
    XQ_AD_INTERF_FID("-809", "渠道标识不能为空!"),
    XQ_AD_INTERF_EVENT("-810", "组别名称不能为空!"),
    XQ_AD_INTERF_AWARDGROUP("-811", "奖励组别不能为空!"),
    XQ_AD_INTERF_PARAM("-812", "参数名不能为空!"),
    XQ_AD_INTERF_LASTADID("-813", "老用户广告不能为空!"),
    XQ_AD_NO_BIND_INFO("-814", "此广告用户没有绑定记录"),


    //老用户
    XQ_AD_OLDUSER_FLUXTIME("-901", "每日带量时间不能为空!"),
    XQ_AD_OLDUSER_INTERF_NOTEXIST("-902", "老用户激活接口不存在!"),
    XQ_AD_OLDUSER_INFO_NOTEXIST("-903", "老用户信息不存在!"),
    XQ_AD_OLDUSER_TOTAL("-904", "激活总数不能为空!"),
    XQ_AD_OLDUSER_ADIDLIST("-905", "老广告编号不能为空!"),
    XQ_AD_OLDUSER_FLUXDAY("-906", "每日激活数不能为空!"),
    XQ_AD_OLDUSER_CHECK_ISEXIST("-907", "该广告已是自动激活,请检查!"),


    //到账
    XQ_AD_GET_MONEY("-1001", "金额不能为0!"),
    XQ_AD_GET_MONEY2("-1001", "退款或转换排期金额必须大于0!"),
    XQ_AD_GETMONEY_REMARK("-1002", "到账描述不能为空!"),
    XQ_AD_GETMONEY_MONEYTYPE("-1003", "到账类型不能为空!"),
    XQ_AD_GETMONEY_INFO_NOTEXIST("-1004", "未找到该到账记录!"),
    XQ_AD_GETMONEY_TRANSFERID("-1004", "转换排期不能为空!"),
    XQ_AD_GETMONEY_TRANSFERID_ISNUMBER("-1004", "转换排期必须是数值类型!"),
    XQ_AD_GETMONEY_ITIME("-1005", "时间不能为空!"),
    XQ_AD_GETMONEY_CONVERT("-1006", "当前余额不足，无法进行退款和排期转换!"),
    AD_GETMONEY_TRANSFERID_NO("-1008", "转换排期不存在,请检查!"),
    AD_ISCLOSE("-1009", "广告已结算无法操作!"),
    XQ_AD_GETMONEY_ADMIN("-1010", "到账或退款审核只有超级管理员可操作!"),
    RECORD_ISCHECK("-1011", "该记录已被审核!"),
    RECORD_NOTEXIST("-1012", "该记录不存在!"),
    XQ_AD_ISCLOSE("-1013", "转入的排期已结清，无法转入!"),
    GETMONEY_BANK("-1014", "收款主体不能为空!"),
    RECORD_ISTRY("-1015", "该记录已打款!"),
    RECORD_EXISTNOTONE("-1016", "该记录多条!"),
    //出账
    XQ_CH_OUTMONEY_COMPANY("-1101", "公司名称不能为空!"),
    XQ_CH_OUTMONEY_TYPE("-1103", "打款类型不能为空!"),
    XQ_CH_OUTMONEY_NOTEXIST("-1104", "未找到该出账记录!"),
    XQ_CH_OUTMONEY_EXAMINE("-1105", "未审核无法进行打款!"),
    XQ_AD_OUT_MONEY("-1106", "打款金额不能为空或为0!"),
    OUTMONEY_BANK("-1107", "出款主体不能为空!"),

    //广告渠道调整
    XQ_AD_OR_CH_CHANGE("-1201", "请正确选择: 1.广告调整列表 2.渠道调整列表!"),
    XQ_AD_OR_CH_CHANGE_ADJUSTTYPE("-1203", "调整类型不能为空!"),
    XQ_AD_OR_CH_CHANGE_MONEY("-1202", "调整金额不能为空或等于0!"),
    XQ_AD_OR_CH_CHANGE_TEXT("-1203", "调整备注不能为空!"),
    XQ_AD_OR_CH_CHANGE_RECORD("-1204", "调整记录不存在!"),

    //模拟H5
    XQ_MODEL_H5_USERID("-1301", "用户ID不能为空!"),

    //结算录入
    XQ_FINADSETL_PRICE("-1401", "渠道结算金额不能小于广告渠道最大的的结算金额，请检查!"),
    XQ_FINADSETL_PRICE_ISNULL("-1401", "单价不能为空!"),
    XQ_ADLIMIT_ISEXIST("1402", "该广告已屏蔽,请检查!"),


    //公司资质
    XQ_COMPANY_NOT_EXISTS("-1501", "公司主体不存在"),
    XQ_COMPANY_NAME_EMPTY("-1502", "公司名称不能为空"),
    XQ_BUSINESSLICENSE_EMPTY("-1502", "公司营业执照不能为空"),
    XQ_COMPANY_NAME_EXISTS("-1502", "公司名称已存在"),
    XQ_PRODUCT_NAME_EXISTS("-1503", "产品名称已存在"),
    XQ_PRODUCT_NAME_EMPTY("-1502", "产品名称不能为空"),
    XQ_COPYRIGHT_EMPTY("-1502", "产品软件著作权不能为空"),
    XQ_PRODUCT_NOT_EXISTS("-1504", "产品名称已存在"),
    FILES_TO_LAGE("-1505", "上传文件过大"),
    XQ_CONVERT_USER_ERROR("-200", "用户类型转换失败"),
    //用户问题处理
    XQ_PARAM_ERROR("-200", "请补全渠道id或vipID"),
    //用户问题处理
    XQ_PARAM_ERROR2("-200", "未查询到绑定记录"),
    XW_FLUX_HAS_EXISTS("-200", "旧游戏id已存在领奖记录"),
    XW_MERID_HAS_EXISTS("-200", "新游戏id已存在绑定记录"),

    KEYDESERROR("-1506", "生成密钥失败"),
    ADNOTFIND("-1507", "沒有找到该广告"),
    REPETITION_OPERATION("-1508", "正在操作中,请稍后在试"),

    //封锁设备号
    XQ_LIMIT_DEVICE_ID("-1510","设备号不能为空"),
    XQ_LIMIT_DEVICE_TYPE("-1511","手机类型不能为空")
    ;

    //返回的错误标识
    private String code;
    //返回的错误消息
    private String msg;
    //返回的错误数据
    private String error;

    MgAdError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    MgAdError(String code, String msg, String error) {
        this.code = code;
        this.msg = msg;
        this.error = error;
    }
    /*MgAdError(AdwallResultCode adwallResultCode) {
        this.code = adwallResultCode.getCode();
        this.msg = adwallResultCode.getDesc();
        this.error = adwallResultCode.getDesc();
    }*/

    public String getMsg() {
        return msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
