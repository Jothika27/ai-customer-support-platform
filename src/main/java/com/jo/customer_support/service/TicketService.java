package com.jo.customer_support.service;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.jo.customer_support.dto.CreateTicketRequest;
import com.jo.customer_support.model.Ticket;
import com.jo.customer_support.repository.TicketRepository;
import com.jo.customer_support.utility.TicketStatus;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    LocalDateTime now = LocalDateTime.now();
    public Mono<Ticket> createTicket(CreateTicketRequest request){
        Ticket ticket = Ticket.builder()
                    .title(request.getTitle())
                    .description(request.getDescription())
                    .status(TicketStatus.OPEN)
                    .createdAt(now)
                    .updatedAt(now)
                    .build();
        return ticketRepository.save(ticket);
    }
    
}
