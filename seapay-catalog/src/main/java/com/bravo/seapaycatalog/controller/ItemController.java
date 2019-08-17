package com.bravo.seapaycatalog.controller;

import com.bravo.seapaycatalog.domain.Item;
import com.bravo.seapaycatalog.exception.ResourceNotFoundException;
import com.bravo.seapaycatalog.exception.ZeroStockException;
import com.bravo.seapaycatalog.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping(value = "/items")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Item save(@RequestBody Item customer) {
        return itemRepository.save(customer);
    }

    @GetMapping(value = "/items")
    public Page<Item> all(Pageable pageable){
        return itemRepository.findAll(pageable);
    }

    @GetMapping(value = "/items/{itemId}")
    public Item findByCustomerId (@PathVariable Integer itemId) {
        return itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item [itemId="+itemId+"] can't be found"));
    }

    @PutMapping(value = "/items/{itemId}")
    public ResponseEntity<Item> updateCustomer(@PathVariable Integer itemId, @RequestBody Item newItem) {
        return itemRepository.findById(itemId).map(item -> {
            item.setName(newItem.getName());
            item.setPrice(newItem.getPrice());
            item.setTotalStock(newItem.getTotalStock());
            itemRepository.save(item);
            return ResponseEntity.ok(item);
        }).orElseThrow(() -> new ResourceNotFoundException("Item [itemId="+itemId+"] can't be found"));
    }

    @GetMapping(value = "reduceItemStock/{itemId}")
    public ResponseEntity<Item> updateCustomer(@PathVariable Integer itemId) {
        return itemRepository.findById(itemId).map(item -> {
            if(item.getTotalStock() > 0) item.setTotalStock(item.getTotalStock()-1);
            else throw new ZeroStockException("Item [itemId="+itemId+"] stock is 0");
            itemRepository.save(item);
            return ResponseEntity.ok(item);
        }).orElseThrow(() -> new ResourceNotFoundException("Item [itemId="+itemId+"] can't be found"));
    }
}
