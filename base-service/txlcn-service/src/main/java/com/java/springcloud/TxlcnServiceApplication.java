package com.java.springcloud;

import com.java.springcloud.config.EnableTransactionManagerServer;
import com.java.springcloud.support.TxLcnManagerBanner;
import com.java.springcloud.config.EnableTransactionManagerServer;
import com.java.springcloud.support.TxLcnManagerBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTransactionManagerServer
public class TxlcnServiceApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TxlcnServiceApplication.class);
        springApplication.setBanner(new TxLcnManagerBanner());
        springApplication.run(args);
    }

}
