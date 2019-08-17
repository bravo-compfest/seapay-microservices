package com.bravo.seapayusermanagement.controller;

import com.bravo.seapayusermanagement.domain.Item;
import com.bravo.seapayusermanagement.domain.Merchant;
import com.bravo.seapayusermanagement.exception.ResourceNotFoundException;
import com.bravo.seapayusermanagement.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MerchantController {
    @Autowired
    private MerchantRepository merchantRepository;

    @PostMapping(value = "/merchants")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Merchant save(@RequestBody Merchant merchant){
        return merchantRepository.save(merchant);
    }

    @GetMapping(value = "/merchants")
    public Page<Merchant> all(Pageable pageable){
        return merchantRepository.findAll(pageable);
    }

    @GetMapping(value = "/merchants/{merchantId}")
    public Merchant findByCustomerId (@PathVariable Integer merchantId) {
        return merchantRepository.findById(merchantId).orElseThrow(() -> new ResourceNotFoundException("Merchant [merchantId="+merchantId+"] can't be found"));
    }

//    @PostMapping(value = "/merchants/{merchantId}/addItem")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public ResponseEntity<Merchant> addItem(@PathVariable Integer merchantId, @RequestBody Item item){
//        return merchantRepository.findById(merchantId).map(merchant -> {
//            RestTemplate restTemplate = new RestTemplate();
//            Item itemMade = restTemplate.postForObject("http://localhost:8089/restapi/items", item, Item.class);
//            merchant.getItemIds().add(itemMade.getId());
//            merchantRepository.save(merchant);
//            return ResponseEntity.ok(merchant);
//        }).orElseThrow(() -> new ResourceNotFoundException("Merchant [merchantId="+merchantId+"] can't be found"));
//    }

    @PutMapping(value = "/merchants/{merchantId}")
    public ResponseEntity<Merchant> updateCustomer(@PathVariable Integer merchantId, @RequestBody Merchant newMerchant) {
        return merchantRepository.findById(merchantId).map(merchant -> {
            merchant.setName(newMerchant.getName());
            merchant.setUsername(newMerchant.getUsername());
            merchant.setPassword(newMerchant.getPassword());
            merchant.setStoreName(newMerchant.getStoreName());
            merchant.setDescription(newMerchant.getDescription());
            merchantRepository.save(merchant);
            return ResponseEntity.ok(merchant);
        }).orElseThrow(() -> new ResourceNotFoundException("Merchant [merchantId="+merchantId+"] can't be found"));
    }
}
