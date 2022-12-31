package org.tecky.graphqlservice.feign;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.tecky.common.api.inventoryservice.InventoryAPI;
import org.tecky.graphqlservice.config.MyLoadBalancerConfig;

@FeignClient(name = "inventory-service", path = "/api")
@LoadBalancerClient(value = "inventory-service",configuration = MyLoadBalancerConfig.class)
public interface FeignInventoryServiceAPI extends InventoryAPI {
}
