package com.group.ecommerce.Entity;

import com.group.ecommerce.Common.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_table")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private String orderId;

    private String status = OrderStatus.PENDING.name();

//    private BigDecimal tax;
//    @Column(name = "sub_total")
//    private BigDecimal subTotal;
//    @Column(name = "grand_total")
//    private BigDecimal grandTotal;
//    @Column(name = "discount_amount")
//    private BigDecimal discountAmount;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private OrderAddressEntity orderAddress;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItemEntity> orderItems;

    // create and update
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
