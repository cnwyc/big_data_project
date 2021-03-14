package com.lagou.collect;

import java.util.Timer;

/**
 * @Author: yunyi
 * @Date: 2021/3/14 21:49
 * @Desc:
 */
public class LogCollect {

    /**
     * -定时采集已滚动完毕日志文件
     * -待采集文件上传到临时目录
     * -备份日志文件
     */

    public static void main(String[] args) {
        Timer timer = new Timer();
        // 定时采集任务调度
        // 1、采集的业务逻辑 2、延迟时间 3、周期时间

        timer.schedule(new LogCollectorTask(),0,3600*1000);
    }
}
