package com.jo.customer_support.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jo.customer_support.utility.TicketStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="tickets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
   @Id
   private String id;
   private String title;    
   private String description;
   private TicketStatus status;
   private LocalDateTime  createdAt;
   private LocalDateTime  updatedAt;
}
