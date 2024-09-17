package com.dmved.spring.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class EntityListener {

    @EventListener(condition = "#root.args[0].accessType.name() == 'READ'")
    public void acceptEntityRead(EntityEvent entityEvent){
        System.out.println("Entity " + entityEvent);
    }
}
