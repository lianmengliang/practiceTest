package com.example.domain;

import com.example.enums.CpaTaskReviewStatusEnum;
import com.example.enums.CpaTaskReviewTypeEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "T_CPA_TASK_REVIEW_LOG")
public class CpaTaskReviewLog {
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select xiquad_box.sq_cpa_task_review_log.nextval from dual")
    private Long id;

    /**
     * 记录ID
     */
    @Column(name = "LOGID")
    private Long logid;

    /**
     * 蘑菇用户ID
     */
    @Column(name = "USERID")
    private Long userid;

    /**
     * 渠道ID
     */
    @Column(name = "APPID")
    private Long appid;

    /**
     * 渠道用户标识
     */
    @Column(name = "APPSIGN")
    private String appsign;

    /**
     * 广告ID
     */
    @Column(name = "ADID")
    private Integer adid;

    /**
     * 广告名称
     */
    @Column(name = "ADNAME")
    private String adname;

    /**
     * 广告图片
     */
    @Column(name = "ADIMG")
    private String adimg;

    /**
     * 任务ID
     */
    @Column(name = "TASKID")
    private Integer taskid;

    /**
     * 第几天
     */
    @Column(name = "DAYNO")
    private Integer dayno;

    /**
     * 任务描述
     */
    @Column(name = "DESCRIBE")
    private String describe;

    /**
     * 任务奖励
     */
    @Column(name = "AWARD")
    private BigDecimal award;

    /**
     * 详细任务ID
     */
    @Column(name = "ITEMID")
    private Integer itemid;

    /**
     * 详细任务类型：2填空，3选择，4截图
     */
    @Column(name = "ITEMTYPE")
    private CpaTaskReviewTypeEnum itemtype;

    /**
     * 用户提交答案
     */
    @Column(name = "ANSWER")
    private String answer;

    /**
     * 审核状态：0未审核，1通过，2拒绝
     */
    @Column(name = "STATUS")
    private CpaTaskReviewStatusEnum status;

    /**
     * 拒接原因
     */
    @Column(name = "REJECT_CAUSE")
    private String rejectCause;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;
}