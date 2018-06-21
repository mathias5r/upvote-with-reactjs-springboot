package com.upvote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Post {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@Column(length = 80, nullable = false)
	private String author;
	private String date;
	@Column(length = 250, nullable = false)
	@Lob
	private String text;
	private long upvotes;

	public Post() {}
	
	public long getID() { return this.id; }
	public void setID(long id) { this.id = id; }
	
	public String getAuthor() { return this.author; }
	public void setAuthor(String author) { this.author = author; }
	
	public String getDate() { return this.date; }
	public void setDate(String date) { this.date = date; }
	
	public String getText() { return this.text; }
	public void setText(String text) { this.text = text; }
	
	public long getUpvotes() { return this.upvotes; }
	public void setUpvotes(long value) { this.upvotes = value;  }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id != other.id)
			return false;
		return true;
	};
	
	
	
}
