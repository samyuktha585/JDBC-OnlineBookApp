package com.bookapp.bean;

public class Book {
	String title,author,category;
	public int bookid;
	int price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String athor) {
		this.author = athor;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Book(String title, String author, String category, int bookid, int price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.bookid = bookid;
		this.price = price;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", athor=" + author + ", category=" + category + ", bookid=" + bookid
				+ ", price=" + price + "]";
	}
	
}
