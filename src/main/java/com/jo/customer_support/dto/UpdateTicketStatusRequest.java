package com.jo.customer_support.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTicketStatusRequest {

    @NotNull(message = "Status is required")
    private String status;
}
