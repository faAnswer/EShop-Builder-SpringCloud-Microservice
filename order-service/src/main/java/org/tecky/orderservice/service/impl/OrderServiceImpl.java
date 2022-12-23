package org.tecky.orderservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.dto.ConversionUtil;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tecky.common.dto.PostOrderDTO;
import org.tecky.orderservice.entities.DetailM2SOrderEntity;
import org.tecky.orderservice.entities.OrderS2MDetailEntity;
import org.tecky.orderservice.mapper.OrderS2MDetailEntityRepository;
import org.tecky.orderservice.service.intf.IOrderService;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

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

        orderS2MDetailEntityRepository.saveAndFlush(orderS2MDetailEntity);

        return ResponseObject
                .builder()
                .setPayLoad("message", "Create Order successful")
                .create(201);
    }
}
