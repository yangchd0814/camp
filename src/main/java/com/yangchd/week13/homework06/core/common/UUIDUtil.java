package com.yangchd.week13.homework06.core.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class UUIDUtil {

    private static String localHost = null;

    public static String getUUID() {
        if (localHost == null) {
            localHost = getLocalHost();
        }
        return localHost + System.currentTimeMillis();
    }

    private static String getLocalHost() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
