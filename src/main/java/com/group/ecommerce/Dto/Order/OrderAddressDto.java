package com.group.ecommerce.Dto.Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderAddressDto {
    @NotBlank(message = "Name can't be empty")
    private String name;
    @NotBlank(message = "Phone can't be empty")
    private String phone;
    @NotBlank(message = "Street can't be empty")
    private String street;
    @NotBlank(message = "City can't be empty")
    private String city;
    private String province;
    @JsonProperty("postal_code")
    @NotBlank(message = "Postal Code can't be empty")
    private String postalCode;
    @NotBlank(message = "Country can't be empty")
    private String country;
}
