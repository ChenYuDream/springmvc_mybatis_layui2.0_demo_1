package org.jypj.dev.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    /**
     * 配置文件通过key获取value
     *
     * @param key
     * @return
     */
    public static String getProperties(String key) {
        InputStream inputStream = new PropertyUtil().getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties p = new Properties();
        String value = "";
        try {
            p.load(inputStream);
            value = p.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * @return
     */
    public static String getFileServerPath() {
        return getProperties("file_server_path");
    }

    /**
     * 获取admin的密码
     * @return
     */
    public static String getAdminPwd() {
        return getProperties("admin_pwd");
    }

}
