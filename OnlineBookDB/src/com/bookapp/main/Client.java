package com.bookapp.main;

import java.util.*;

import com.bookapp.bean.Book;
import com.bookapp.dao.BookImpl;
import com.bookapp.dao.BookInter;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class Client {

	public static void main(String[] args) {
		BookInter bookService = new BookImpl();
		System.out.println("Enter your choice ");
		System.out.println(
				"1.Add Books Details \n2.Get Book By Author Id\n3.Enter Book ID to Delete \n4.Enter Id and Price to Update"
				+ "\n5.For getting available books\n6.Get Book By Author Name\n7.Get Book By Category Name");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Enter book to add");
			
			System.out.println("Title");
			String title = sc.next();
			
			System.out.println("Author");
			String author = sc.next();
			
			System.out.println("Category");
			String category = sc.next();
			
			System.out.println("Id");
			int id = sc.nextInt();
			
			System.out.println("Price");
			int price = sc.nextInt();
			
			Book b = new Book(title,author,category,id,price);
			bookService.addBook(b);
			
			break;
		case 2:
			System.out.println("Enter Book ID ");
			int id1 = sc.nextInt();
			try {
				System.out.println(bookService.getBookById(id1));
			} catch (BookNotFoundException e) {
				
				e.printStackTrace();
			}
			break;
		case 3:
			
			try {
				System.out.println("Enter the Book Id to Delete");
				int id11 = sc.nextInt();
				boolean val = bookService.deleteBook(id11);
				if (val == false)
					System.out.println("Deleted..");
			} catch (BookNotFoundException e) {
				
				e.printStackTrace();
			}
			break;
			case 4:
				System.out.println("Enter Id and Price ");
				int id21 =sc.nextInt(); 
				int price1 = sc.nextInt(); 
				boolean update = false; 
				try {
					bookService.updatebook(id21,price1);
					} 
				catch(BookNotFoundException e) 
				{
					e.printStackTrace(); 
					} 
				finally {
					if(update)
						System.out.println("updated successfully"); 
					
				} break;

		case 5:
			
			System.out.println("available books...");
			try
			{
				System.out.println(bookService.getAllBooks());
			}
			catch(BookNotFoundException e)
			{
				e.printStackTrace();
			}
			break;
		case 6:
			System.out.println("Enter Author Name");
			String authorName = sc.next();
			try
			{
				System.out.println(bookService.getBookByAuthor(authorName));
			}
			catch(AuthorNotFoundException e)
			{
				e.printStackTrace();
			}
			break;
		case 7:
			System.out.println("Enter Category Name");
			String category1 = sc.next();
			try {
				System.out.println(bookService.getBookByCategory(category1));
			} catch (CategoryNotFoundException e) {
				
				e.printStackTrace();
			}
			
		}
	}

}
