package com.jo.customer_support.controller;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jo.customer_support.dto.AssignTicketRequest;
import com.jo.customer_support.dto.CreateTicketRequest;
import com.jo.customer_support.dto.UpdateTicketStatusRequest;
import com.jo.customer_support.model.Ticket;
import com.jo.customer_support.service.TicketService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/create")
    public Mono<Ticket> createTicket(@Valid @RequestBody CreateTicketRequest request){
        return ticketService.createTicket(request);
    }

    @GetMapping("/{id}")
    public Mono<Ticket> getTicketById(@PathVariable @NonNull String id){
        return ticketService.getTicketById(id);
    }

    @GetMapping("/allTickets")
    public Flux<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }   

    @PutMapping("/{id}/status")
    public Mono<Ticket> updateTicketStatus(@PathVariable @NonNull String id, @Valid @RequestBody @NonNull UpdateTicketStatusRequest request){
        return ticketService.updateTicketStatus(id, request);
    }

    @PutMapping("/{id}/assign")
    public Mono<Ticket> assignTicket(@PathVariable @NonNull String id, @Valid @RequestBody AssignTicketRequest request) {
    return ticketService.assignTicket( id, request );
    }

    @GetMapping("/search")
    public Flux<Ticket> searchTickets( @RequestParam String keyword) {
    return ticketService.searchTickets( keyword);
    }
}
