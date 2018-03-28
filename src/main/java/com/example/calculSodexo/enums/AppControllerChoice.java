package com.example.calculSodexo.enums;

import lombok.Getter;

@Getter
public enum AppControllerChoice {
	NewTicket("1"),
	ArticleList("2"),
	Quit("q");
	
	private String value;
	
	private AppControllerChoice (String value) {
		this.value = value;
	}
}
