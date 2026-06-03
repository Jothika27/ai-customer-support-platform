package com.jo.customer_support.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTicketRequest {
  @NotBlank(message = "Title is required")
  private String title;
  @NotBlank(message = "Description is required")
   private String description;
}
