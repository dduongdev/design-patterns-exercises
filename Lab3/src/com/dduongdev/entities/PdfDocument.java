package com.dduongdev.entities;

public class PdfDocument implements Document {
	private String name;
	private String content;

	public PdfDocument(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public void display() {
		System.out.println("Document: " + name);
		System.out.println("Content: " + content);
	}

}
