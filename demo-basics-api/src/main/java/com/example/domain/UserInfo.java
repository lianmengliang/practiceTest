package com.example.domain;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`user_info`")
public class UserInfo {
    /**
     * 序号
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 账号
     */
    @Column(name = "`account`")
    private String account;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 昵称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 过期时间
     */
    @Column(name = "`end_time`")
    private Date endTime;

    /**
     * 备注
     */
    @Column(name = "`note`")
    private String note;
}