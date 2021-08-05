package com.example.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author ： leo
 * @Date :2019/11/5 18:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {


    private Integer id;

    private String userName;
    private String passWord;
    private String realName;



}
