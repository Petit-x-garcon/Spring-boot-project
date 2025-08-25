package com.group.ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseReponseModel {
    private String message;
    private String status;
}