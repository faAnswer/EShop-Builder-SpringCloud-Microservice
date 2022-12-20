package org.tecky.common.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.tecky.common.dto.PostCouponDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class  KafkaTopicConfig implements Serializable {

    public static final String COUPON = "coupon";

    public static final Map<String, Class<?>> map = new HashMap<>();

    public KafkaTopicConfig(){

        map.put(COUPON, PostCouponDTO.class);
    }

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T string2Object(String json, Class<T> clazz) throws JsonProcessingException {

        return mapper.readValue(json, clazz);
    }
}
