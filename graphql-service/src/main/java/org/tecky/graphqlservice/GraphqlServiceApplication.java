package org.tecky.graphqlservice;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "endpoint", autoRefreshed = true)
public class GraphqlServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlServiceApplication.class, args);
    }

}
