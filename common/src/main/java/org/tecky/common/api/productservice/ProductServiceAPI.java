package org.tecky.common.api.productservice;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface ProductServiceAPI extends CategoryAPI, ProductGroupAPI, TypeAPI{
}
