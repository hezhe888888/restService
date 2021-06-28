package com.lk.rest.Util;

import java.util.List;

public class ListUtil {

    public static boolean isNull(List<?> list) {

        if (null == list || list.size() == 0 || list.isEmpty()) {
            return true;
        }
        return false;
    }
}
