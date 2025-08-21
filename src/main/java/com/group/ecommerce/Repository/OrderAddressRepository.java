package com.group.ecommerce.Repository;

import com.group.ecommerce.Entity.OrderAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAddressRepository extends JpaRepository<OrderAddressEntity, Long> {
}
