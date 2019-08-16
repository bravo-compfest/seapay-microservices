package com.bravo.seapayusermanagement.repository;

import com.bravo.seapayusermanagement.domain.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
}
