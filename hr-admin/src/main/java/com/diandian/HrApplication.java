package com.diandain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author diandian
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class HrApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(HrApplication.class, args);
        System.out.println(" 后台启动成功");

    }
}
