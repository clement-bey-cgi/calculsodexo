package com.example.calculSodexo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinTable(name="solution_article",
    joinColumns=
        @JoinColumn(name="id_solution", referencedColumnName="ID"),
    inverseJoinColumns=
        @JoinColumn(name="id_article", referencedColumnName="ID")
    )
	private Set<Article> articles;
}
