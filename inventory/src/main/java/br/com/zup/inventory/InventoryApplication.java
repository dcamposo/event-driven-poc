package br.com.zup.inventory;

import br.com.zup.inventory.entity.Inventory;
import br.com.zup.inventory.repository.InventoryRespository;
import br.com.zup.inventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }



}
