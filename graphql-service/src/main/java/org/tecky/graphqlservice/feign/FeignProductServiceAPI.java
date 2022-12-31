package org.tecky.graphqlservice.feign;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.tecky.common.api.productservice.ProductServiceAPI;
import org.tecky.graphqlservice.config.MyLoadBalancerConfig;

@FeignClient(name = "product-service", path = "/api")
@LoadBalancerClient(value = "product-service",configuration = MyLoadBalancerConfig.class)
public interface FeignProductServiceAPI extends ProductServiceAPI {
}
