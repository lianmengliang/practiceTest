package com.example.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author ： leo
 * @Date :2019/11/5 18:41
 */
@Data
public class User implements Serializable {


    private Integer id;

    private String userName;
    private String passWord;
    private String realName;



}
