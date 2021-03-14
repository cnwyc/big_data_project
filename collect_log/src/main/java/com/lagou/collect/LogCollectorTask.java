package com.lagou.collect;

import java.io.File;
import java.io.FilenameFilter;
import java.util.TimerTask;

/**
 * @Author: yunyi
 * @Date: 2021/3/14 21:53
 * @Desc:
 */
public class LogCollectorTask extends TimerTask {
    @Override
    public void run() {

        // 采集业务实现

        // 1、扫描指定目录，找到待上传文件
        File logsDir = new File("e:/logs/");
        // 根据名称过滤
        File[] uploadFiles = logsDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("access.log");
            }
        });

        // 2、把待上传文件转移到临时目录
        // 判断临时目录是否存在
        File tmpFile = new File("e:/log_tmp");

        if (!tmpFile.exists()){
            tmpFile.mkdirs();
        }
        for (File file : uploadFiles) {
            file.renameTo(new File(tmpFile.getPath()+"/"+file.getName()));
        }
        // 3、使用hdfs api 上传日志文件到指定目录
        new Configuration
        // 4、上传后的文件转移到备份目录


    }
}
