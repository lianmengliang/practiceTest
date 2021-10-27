package com.example.utils.check_accpunt;


import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * PACKAGE_NAME:com.xq.mgxq.util
 * AUTHOR: hexOr
 * DATE :2019/3/12 0:49
 * DESCRIPTION:校验工具类
 */
public class AccountValidatorUtil {

    public static void main(String[] args) {
        System.out.println(isMobile("1843579449"));
        System.out.println(isMobile("16635794494"));
    }


    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(RegexConstant.REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(RegexConstant.REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(RegexConstant.REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(RegexConstant.REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(RegexConstant.REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(RegexConstant.REGEX_ID_CARD, idCard);
    }


    /**
     * 校验IP地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(RegexConstant.REGEX_IP_ADDR, ipAddr);
    }
}
