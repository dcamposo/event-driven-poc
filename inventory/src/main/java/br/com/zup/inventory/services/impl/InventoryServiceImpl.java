package br.com.zup.inventory.services.impl;

import br.com.zup.inventory.entity.Inventory;
import br.com.zup.inventory.event.OrderCreatedEvent;
import br.com.zup.inventory.repository.InventoryRespository;
import br.com.zup.inventory.repository.ReserveRepository;
import br.com.zup.inventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryRespository inventoryRespository;
    private ReserveRepository reserveRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRespository inventoryRespository, ReserveRepository reserveRepository) {
        this.inventoryRespository = inventoryRespository;
        this.reserveRepository = reserveRepository;
    }

    public void process(OrderCreatedEvent orderCreatedEvent){

        Map<String, Integer> items;
        List<Inventory> inventories = new ArrayList<>();
        List<String> festivalList = orderCreatedEvent.getItems().keySet().stream().collect(Collectors.toList());
        for (String festivalId:festivalList){
            Inventory inventory = this.inventoryRespository.getOne(festivalId);
            Integer qty = inventory.getQtyAvailable();
            qty = qty - orderCreatedEvent.getItems().get(festivalId);
            inventory.setQtyAvailable(qty);
            inventories.add(inventory);
        }
        this.inventoryRespository.saveAll(inventories);
    }

    public void start(){
        Inventory inventory  = new Inventory("","glastonbury",100);
        this.inventoryRespository.save(inventory);
    }
}
