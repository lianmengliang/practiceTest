package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

/**
 * @Author ： leo
 * @Date :2020/6/17 20:20
 */
@Data
public class AccountList {

    @JsonFilter(value = "available_balance")
    private String balance;

}
