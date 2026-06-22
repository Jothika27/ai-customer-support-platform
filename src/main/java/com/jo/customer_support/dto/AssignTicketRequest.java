package com.jo.customer_support.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssignTicketRequest {

        @NotBlank(message = "Agent name is required")
        private String assignedAgent;
}
