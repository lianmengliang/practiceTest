package com.example.enums;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * 数值类型枚举接口
 * @author ReveeWu
 * @create 2019-10-12 10:45
 */
public interface CodeEnum {
    String DEFAULT_CODE_NAME = "code";

    String DEFAULT_DESC_NAME = "desc";

    default Integer getCode() {
        Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_CODE_NAME);
        if (field == null) {
            return null;
        }

        try {
            field.setAccessible(true);
            return Integer.parseInt(field.get(this).toString());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    default String getDesc() {
        Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_DESC_NAME);
        if (field == null) {
            return null;
        }

        try {
            field.setAccessible(true);
            return field.get(this).toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static <T extends Enum<T>> T valueOfCode(Class<T> enumClass, Integer code) {
        if (code == null) {
            throw new IllegalArgumentException("DisplayedEnum value should not be null");
        }
        if (enumClass.isAssignableFrom(CodeEnum.class)) {
            throw new IllegalArgumentException("illegal DisplayedEnum type");
        }
        T[] enums = enumClass.getEnumConstants();
        for (T t : enums) {
            CodeEnum displayedEnum = (CodeEnum) t;
            if (displayedEnum.getCode().equals(code)) {
                return (T) displayedEnum;
            }
        }

        throw new IllegalArgumentException("cannot parse integer: " + code + " to " + enumClass.getName());
    }
}
