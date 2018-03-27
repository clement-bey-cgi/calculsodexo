package com.example.calculSodexo.controller;

import java.util.Scanner;

import lombok.Getter;

@Getter
public abstract class AbstractController {
	
	protected String choice;
	
	protected Scanner scan = new Scanner(System.in);
	
	public void print(String o) {
		System.out.println(o);
	}
	
	public void begin() {
		print("-----------------");
		print("-----------------");
		print("-----------------");		
		print("");
	}
	
	public void end() {
		print("");
		print("-----------------");
		print("-----------------");
		print("-----------------");	
	}
	
	public void setChoice() {
		this.choice = scan.nextLine();
	}
}
