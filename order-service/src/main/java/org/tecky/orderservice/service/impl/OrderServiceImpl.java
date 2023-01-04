package org.tecky.orderservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.MyRestTemplateBuilder;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tecky.common.dto.PostOrderDTO;
import org.tecky.orderservice.entities.DetailM2SOrderEntity;
import org.tecky.orderservice.entities.OrderS2MDetailEntity;
import org.tecky.orderservice.mapper.OrderS2MDetailEntityRepository;
import org.tecky.orderservice.service.intf.IOrderService;

import java.util.List;
import java.util.function.Consumer;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderS2MDetailEntityRepository orderS2MDetailEntityRepository;


    @Override
    @GlobalTransactional
    public ResponseEntity<?> createOrder(PostOrderDTO postOrderDTO) throws JsonProcessingException {

        log.info("Start GlobalTransaction createOrder");

        OrderS2MDetailEntity orderS2MDetailEntity;
        List<DetailM2SOrderEntity> detailM2SOrderEntityList;

        try {
            orderS2MDetailEntity = ConversionUtil.convertS2S(OrderS2MDetailEntity.class, postOrderDTO);
            detailM2SOrderEntityList = ConversionUtil.convertM2M(DetailM2SOrderEntity.class, postOrderDTO.getPostOrderProductDTOList());
        } catch (Exception e) {

            throw new CustomException(500, "Error in OrderServiceImpl createOrder : ConversionUtil");
        }

        for(DetailM2SOrderEntity detailM2SOrderEntity: detailM2SOrderEntityList){

            detailM2SOrderEntity.setOrderS2MDetailEntity(orderS2MDetailEntity);
        }

        orderS2MDetailEntity.setDetailM2SOrderEntityList(detailM2SOrderEntityList);

        orderS2MDetailEntity = orderS2MDetailEntityRepository.saveAndFlush(orderS2MDetailEntity);

        ResponseEntity<?> response = new MyRestTemplateBuilder(this.restTemplate, MediaType.APPLICATION_JSON)
                .setURL("http://127.0.0.1:9999/coupon/api/v1/coupon")
                .addPara("orderId", orderS2MDetailEntity.getOrderId())
                .addPara("subtotal", 500)
                .addPara("uid", orderS2MDetailEntity.getUid())
                .addPara("couponId", orderS2MDetailEntity.getCouponId())
                .addPara("clientUid", orderS2MDetailEntity.getClientUid())
                .send(HttpMethod.PUT);

        throw new CustomException(400, "Invalid");

//        return ResponseObject
//                .builder()
//                .setPayLoad("message", "Create Order successful")
//                .create(201);
    }
}
