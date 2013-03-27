package com.luna.console.code;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class 国际化测试 {

    public static void main(String[] args) {

        // Locale 对象表示了以特定的地理、政治和文化地区；
        // 获取本地默认的地区
        Locale defaultLocale = Locale.getDefault();

        // ResourceBundle 对象表示资源包包含特定的语言环境
        // 通过“anyname”拼接locale中的语言国家找到properties文件
        // (如果自定义locale乱写或不存在，首先会根据你本地设置的locale读取对应properties文件，找不到就找缺省文件)

        ResourceBundle resourceBundle = ResourceBundle.getBundle("bundle/Internationalization",
                defaultLocale);

        // 格式化字符串
        // MessageFormat messageFormat = new
        // MessageFormat(resourceBundle.getString("name"));
        // String name = messageFormat.format(new Object[] { "张三" });// 对应{0}
        String name = MessageFormat.format(resourceBundle.getString("name"), new Object[] { "张三" });
        System.out.println(name);
    }
}
