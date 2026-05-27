package com.oliveiracesar.workshopmongo.dto;

import java.io.Serializable;

import java.util.Date;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
 
	private String text;
	private Date Date;
	private AuthorDTO author;
		
	public CommentDTO() {
		
	}

	public CommentDTO(String text, Date Date, AuthorDTO author) {
		super();
		this.text = text;
		this.Date = Date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date Date) {
		this.Date = Date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	
}
