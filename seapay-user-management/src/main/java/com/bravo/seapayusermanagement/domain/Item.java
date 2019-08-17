package com.bravo.seapayusermanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Serializable {
    public Integer id;

    public String name;

    @Override
    public String toString() {
        return "Item{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", totalStock=" + totalStock +
            '}';
    }

    public BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Integer totalStock;

}

