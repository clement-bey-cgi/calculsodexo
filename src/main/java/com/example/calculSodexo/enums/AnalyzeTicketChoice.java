package com.example.calculSodexo.enums;

import lombok.Getter;

@Getter
public enum AnalyzeTicketChoice {
	Quit("q");
	
	private String value;
	
	private AnalyzeTicketChoice (String value) {
		this.value = value;
	}
}
