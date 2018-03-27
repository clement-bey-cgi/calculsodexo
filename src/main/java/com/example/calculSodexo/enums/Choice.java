package com.example.calculSodexo.enums;

import lombok.Getter;

@Getter
public enum Choice {
	NewTicket("1"),
	ArticleList("2"),
	Quit("Q");
	
	private String value;
	
	private Choice (String value) {
		this.value = value;
	}
}
