package com.example.calculSodexo.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.calculSodexo.model.Article;
import com.example.calculSodexo.model.Ticket;
import com.example.calculSodexo.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Ticket save(Ticket t) {
		return ticketRepository.save(t);
	}
}
