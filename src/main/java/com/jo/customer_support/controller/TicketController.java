package com.jo.customer_support.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jo.customer_support.dto.CreateTicketRequest;
import com.jo.customer_support.model.Ticket;
import com.jo.customer_support.service.TicketService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
}
