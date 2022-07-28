package com.yangchd.week13.homework06.core.consumer;

import java.util.List;

public interface Consumer {

    /**
     * 获取数据
     * 返回之多最大值 rate 的数据量
     * @param rate 最大数据量
     * @return data list
     */
    List poll(int rate);

}
