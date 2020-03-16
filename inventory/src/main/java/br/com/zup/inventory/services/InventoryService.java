package br.com.zup.inventory.services;

import br.com.zup.inventory.entity.Inventory;
import br.com.zup.inventory.event.OrderCreatedEvent;

public interface InventoryService {

    public void process (OrderCreatedEvent event);
    public void start();

}
