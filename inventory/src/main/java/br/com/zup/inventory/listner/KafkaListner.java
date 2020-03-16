package br.com.zup.inventory.listner;

import br.com.zup.inventory.event.OrderCreatedEvent;
import br.com.zup.inventory.services.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@Configuration
@EnableKafka
public class KafkaListner {

    private ObjectMapper objectMapper;
    private InventoryService inventoryService;

    @Autowired
    public KafkaListner(ObjectMapper objectMapper, InventoryService inventoryService){
        this.objectMapper = objectMapper;
        this.inventoryService = inventoryService;
    }

    @KafkaListener(topics = "created-orders", groupId = "inventory-group-id")
    public void listenCreatedOrders(String message) throws IOException {
        OrderCreatedEvent event = this.objectMapper.readValue(message, OrderCreatedEvent.class);
        this.inventoryService.process(event);
        System.out.println("evento: " + event);
    }

}
