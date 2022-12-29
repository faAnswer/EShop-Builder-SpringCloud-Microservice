package org.tecky.graphqlservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.tecky.common.api.productservice.ProductServiceAPI;

@FeignClient("product-service")
public interface FeignProductServiceAPI extends ProductServiceAPI {
}
