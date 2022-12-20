package org.tecky.common.config;

import org.tecky.common.dto.PostCouponDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class KafkaTopicConfig implements Serializable {

    public static final String COUPON = "coupon";

    Map<String, Class<?>> map = new HashMap<String, Class<?>>();

    public KafkaTopicConfig(){

        map.put(COUPON, PostCouponDTO.class);
    }
}
