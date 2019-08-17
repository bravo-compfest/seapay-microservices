package com.bravo.seapaycatalog.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "items")
@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "total_stock")
    private Integer totalStock;

    public Item() {

    }

    public Item(String name, BigDecimal price, Integer totalStock) {
        this.name = name;
        this.price = price;
        this.totalStock = totalStock;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }
}
