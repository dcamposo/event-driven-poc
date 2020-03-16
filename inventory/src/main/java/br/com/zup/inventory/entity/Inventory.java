package br.com.zup.inventory.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "invetory")
public class Inventory {

    @Id
    private String id;
    private String festivalName;
    private Integer qtyAvailable;



    public Inventory(){}

    public Inventory(String inventoryId, String festivalName, Integer qtyAvailable) {
        this.id = inventoryId;
        this.festivalName = festivalName;
        this.qtyAvailable = qtyAvailable;
    }

    public String getInventoryId() {
        return id;
    }

    public void setInventoryId(String id) {
        this.id = id;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }

    public Integer getQtyAvailable() {
        return qtyAvailable;
    }

    public void setQtyAvailable(Integer qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }
}
