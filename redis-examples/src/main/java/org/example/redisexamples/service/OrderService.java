package org.example.redisexamples.service;

import org.example.redisexamples.component.ULID;
import org.example.redisexamples.dto.Item;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.redisexamples.dto.Order;
import org.redisson.api.*;
import org.redisson.api.stream.StreamAddArgs;
import org.redisson.client.codec.IntegerCodec;
import org.redisson.client.codec.StringCodec;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.awt.AWTEventMulticaster.add;

@Service
@Slf4j
@AllArgsConstructor
public class OrderService {
    private final RedissonClient client;
    private final ULID ulid;

    public void addItem(List<Item> items){
        RBatch batch = client.createBatch();
        for(Item item : items){
            RMapAsync<String, Integer> map = batch.getMap(Item.PRE_KEY + item.getId(), IntegerCodec.INSTANCE);
            map.putAsync("total",item.getTotal());

        }
        batch.execute();

    }
    public int buy(String itemId,String userId){
        long q = client.getFunction()
                     .call(FunctionMode.WRITE,
                        "buy_21",
                        FunctionResult.LONG,
                        List.of(Item.PRE_KEY+itemId));
        if(q == -1){
            log.debug("抢光了");
            return -1;
        }
        var id =ulid.nextULID();
        Order o =Order.builder()
                .id(ulid.nextULID())
                .userId(userId)
                .itemId(itemId)
                .build();
        client.getBucket(Order.PRE_KEY + id)
                .set(o);
        sendMessage(o);
        return (int) q;
    }

    public void sendMessage(Order order){
        client.getStream(Order.STREAM_KEY, StringCodec.INSTANCE)
        // 仅需在消息体添加订单ID
        .add(StreamAddArgs.entry("orderid", order.getId()));
    }

}
