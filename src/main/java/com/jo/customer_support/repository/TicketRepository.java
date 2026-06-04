package com.jo.customer_support.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.jo.customer_support.model.Ticket;

@Repository
public interface TicketRepository extends ReactiveMongoRepository<Ticket, String> {

}
