package com.syf.leetcode.stringType;

import java.util.regex.Pattern;

/**
 * @auth syf
 * @date 2021/1/4 16:29
 */
// 验证是不是ipv4
public class IpV4 {
    // 用正则表达式
    public static void main(String[] args) {
        String str = "127.0.0.1" ;
        String piv6="2001:db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(vilaIpV4(str));
        System.out.println(vilaIpV6(piv6));
    }

    private static boolean vilaIpV6(String piv6) {
        String checkIpV6 = "([0-9a-fA-F]{1,4})";
        String match = "^("+checkIpV6+"\\:){7}"+checkIpV6+"$";
        return Pattern.compile(match).matcher(piv6).matches();
    }

    private static boolean vilaIpV4(String string) {
        String checkIpv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])" ;
        String match = "^("+checkIpv4+"\\.){3}"+checkIpv4+"$";
        Pattern compile = Pattern.compile(match);
        boolean matches = compile.matcher(string).matches();
        return matches;
    }
}
