package com.bravo.seapayusermanagement.repository;

import com.bravo.seapayusermanagement.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
