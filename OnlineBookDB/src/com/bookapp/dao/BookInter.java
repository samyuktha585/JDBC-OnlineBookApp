package com.bookapp.dao;

import java.util.*;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;


public interface BookInter {
	//called by admin
	void addBook(Book book);
	boolean deleteBook(int bookid)throws BookNotFoundException;
	List<Book> getBookById(int bookid)throws BookNotFoundException;
	int updatebook(int bookid,int price) throws BookNotFoundException;
	
	//called by customer
	
	List<Book> getAllBooks()throws BookNotFoundException;
	List<Book>getBookByAuthor(String author)throws AuthorNotFoundException;
	List<Book> getBookByCategory(String category)throws CategoryNotFoundException;

}
