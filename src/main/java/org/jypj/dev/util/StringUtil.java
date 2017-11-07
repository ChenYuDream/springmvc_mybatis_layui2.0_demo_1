package org.jypj.dev.util;

import java.util.UUID;

public class StringUtil {

    /**
     * 得到小写32位UUID
     * @return
     */
    public static String getLowUUID() {
        return UUID.randomUUID().toString().replace("-", "").trim().toLowerCase();
    }
}
