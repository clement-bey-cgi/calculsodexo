package com.example.calculSodexo.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.calculSodexo.model.Article;
import com.example.calculSodexo.model.Solution;
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
	
	public Set<Solution> prepareSolution(Set<Article> chosenArticles, Set<Article> unchosenArticles, Double montant) {
		// TODO FINIR ALGO
		
		// implémenter un objet solution possible qui prend le montant payable en carte +tous les articles du ticket + solution possible 

		// un ticket aura une liste de solution possible

		// fonction récursive pour trouver la solution
		
		// if solutions == null... Pas de solution + suppression du ticket

	    Iterator<Article> unchosenIterator = unchosenArticles.iterator();
	    Article article;
	    while ( unchosenIterator.hasNext()) {
	         article = unchosenIterator.next();
	         if (montant - article.getPrix() > 0) {
	            chosenArticles.add(article);
	            unchosenArticles.remove(article);
	            montant -= article.getPrix();
	            return prepareSolution(chosenArticles, unchosenArticles, montant);
	         }
	         /*else if (montant - article.getPrix() < 0) {
	             continue;
	         }
	         else {
	            return 
	        }*/
	    }
        return new HashSet<Solution>();
	}
}
