package com.example.calculSodexo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.calculSodexo.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
