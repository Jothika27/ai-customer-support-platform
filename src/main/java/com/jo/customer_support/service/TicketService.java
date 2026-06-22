package com.jo.customer_support.service;
import java.time.LocalDateTime;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.jo.customer_support.dto.AssignTicketRequest;
import com.jo.customer_support.dto.CreateTicketRequest;
import com.jo.customer_support.dto.UpdateTicketStatusRequest;
import com.jo.customer_support.model.Ticket;
import com.jo.customer_support.repository.TicketRepository;
import com.jo.customer_support.utility.TicketStatus;

import lombok.RequiredArgsConstructor;
import java.util.Objects;

import reactor.core.publisher.Flux;
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
        return ticketRepository.save(Objects.requireNonNull(ticket));
    }

    public Mono<Ticket> getTicketById(@NonNull String id) {
        return ticketRepository.findById(id);
    }

    public Flux<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    
    public Mono<Ticket> updateTicketStatus(@NonNull String id, @NonNull UpdateTicketStatusRequest request) {
        return ticketRepository.findById(id)
                .flatMap(ticket -> {
                    ticket.setStatus(TicketStatus.valueOf(Objects.requireNonNull(request.getStatus())));
                    ticket.setUpdatedAt(LocalDateTime.now());
                    return ticketRepository.save(ticket);
                });
    }

    public Mono<Ticket> assignTicket(@NonNull String id, AssignTicketRequest request){
    return ticketRepository
            .findById(id)
            .switchIfEmpty( Mono.error(new RuntimeException("Ticket not found" )))
            .flatMap(ticket -> {
                ticket.setAssignedAgent(request.getAssignedAgent());
                ticket.setUpdatedAt(LocalDateTime.now());
                return ticketRepository.save(ticket);
      });

    }

    public Flux<Ticket> searchTickets(String keyword) {
    TicketStatus status =TicketStatus.valueOf(keyword.toUpperCase());
        return ticketRepository.findByStatus(status);
    }
}
