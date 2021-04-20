package com.study.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author zhangYu
 * @Date 2021/4/7 9:33
 */
public class FormatUtil {

    //判断是否为邮箱
    public static boolean isMailFormat(String mail){
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern mailRegex = Pattern.compile(check);
        Matcher matcher = mailRegex.matcher(mail);
        return matcher.matches();
    }

    //判断是否为手机
    public static boolean isPhoneFormat(String phone){
        boolean flag2 = false;
        Pattern phoneRegex = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])" +
                "|(18[0-9])|(19[8,9]))\\d{8}$"); // 验证手机号
        Matcher m = phoneRegex.matcher(phone);
        return m.matches()||flag2;
    }



}
