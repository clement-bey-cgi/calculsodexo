package com.example.calculSodexo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//TODO faire table SOLUTION + TABLE JOINTURE SOLUTIONS_ARTICLES
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ticket")
	private Ticket ticket;
	
	@ManyToMany
	private Set<Article> articles;
}
