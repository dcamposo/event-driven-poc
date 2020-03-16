package br.com.zup.inventory.services.impl;

import br.com.zup.inventory.entity.Inventory;
import br.com.zup.inventory.entity.Reserve;
import br.com.zup.inventory.event.BookedEvent;
import br.com.zup.inventory.event.OrderCreatedEvent;
import br.com.zup.inventory.repository.InventoryRespository;
import br.com.zup.inventory.repository.ReserveRepository;
import br.com.zup.inventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    private InventoryRespository inventoryRespository;
    private ReserveRepository reserveRepository;

    @Autowired
    private KafkaTemplate<String, BookedEvent> template;

    @Autowired
    public InventoryServiceImpl(InventoryRespository inventoryRespository, ReserveRepository reserveRepository, KafkaTemplate<String, BookedEvent> template) {
        this.inventoryRespository = inventoryRespository;
        this.reserveRepository = reserveRepository;
        this.template = template;
    }

    public void process(OrderCreatedEvent orderCreatedEvent){

        Map<String, Integer> items;
        Reserve reserve = new Reserve();
        Inventory inventory = new Inventory();

        List<Inventory> inventories = new ArrayList<>();
        List<String> festivalList = orderCreatedEvent.getItems().keySet().stream().collect(Collectors.toList());

        for (String festivalId:festivalList){

            inventory = this.inventoryRespository.getOne(festivalId);
            Integer qty = inventory.getQtyAvailable();
            qty = qty - orderCreatedEvent.getItems().get(festivalId);
            inventory.setQtyAvailable(qty);
            this.inventoryRespository.save(inventory);
        }

        reserve.setCustomerId(orderCreatedEvent.getCustomerId());
        reserve.setOrderId(orderCreatedEvent.getOrderId());
        reserve.setInventoryId(inventory.getInventoryId());
        reserve.setAmount(orderCreatedEvent.getAmount());
        reserve.setId("2e8629f1e-f83e-4f81-b2d7-23655ac04b8a");
        this.reserveRepository.save(reserve);

        BookedEvent event = new BookedEvent(
                reserve.getId(),
                orderCreatedEvent.getCustomerId(),
                orderCreatedEvent.getOrderId(),
                orderCreatedEvent.getAmount()
        );

        this.template.send("booked-orders", event);



    }
}
