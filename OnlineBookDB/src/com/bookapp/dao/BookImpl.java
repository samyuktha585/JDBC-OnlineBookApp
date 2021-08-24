package com.bookapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bookapp.bean.Book;
import com.bookapp.exception.*;

public class BookImpl implements BookInter {
	

	public void addBook(Book book) {

		String sql = "insert into book values(?,?,?,?,?)";
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getCategory());
			statement.setInt(4, book.getBookid());
			statement.setInt(5, book.getPrice());
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			ModelDAO.closeConnection();
		}
	}

	@Override
	public boolean deleteBook(int bookid) throws BookNotFoundException {

		int result = 0;
		String sql = "delete from book where bookid=? ";
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			String delsql = "delete from Book where bookid=?";
			connection = ModelDAO.openConnection();
			statement = connection.prepareStatement(delsql);
			statement.setInt(1, bookid);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Book> getBookById(int bookid) throws BookNotFoundException {
		
		List<Book> getBooksbyId = new ArrayList<>();
		String sql = "select * from Book where bookid=?";
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			
			connection = ModelDAO.openConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, bookid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				Book book = new Book();
				book.setTitle(rs.getString(1));
				book.setAuthor(rs.getString(2));
				book.setCategory(rs.getString(3));
				book.setBookid(rs.getInt(4));
				book.setPrice(rs.getInt(5));
				getBooksbyId.add(book);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return  getBooksbyId;
	}
	

	@Override
	public int updatebook(int bookid, int price) throws BookNotFoundException {
		int result = 0;
		String sql = "update book set price = ? where id = ?";
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		int rs = 0;
		try {
			String updsql = "update Book set price=? where bookId=?";
			connection = ModelDAO.openConnection();
			statement = connection.prepareStatement(updsql);
			statement.setInt(1, price);
			statement.setInt(2, bookid);
			rs = statement.executeUpdate();
			if (rs == 0) {
				throw new BookNotFoundException("not found");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ModelDAO.closeConnection();
		}
		return rs;
	}

	@Override
	public List<Book> getAllBooks() {

		String sql = "select * from book";
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Book b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				bookList.add(b);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			ModelDAO.closeConnection();
		}
		return bookList;
	}



	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		List<Book> getBooksbyCategory = new ArrayList<>();
		String sql = "select * from Book where category=?";
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			
			connection = ModelDAO.openConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, category);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				Book book = new Book();
				book.setTitle(rs.getString(1));
				book.setAuthor(rs.getString(2));
				book.setCategory(rs.getString(3));
				book.setBookid(rs.getInt(4));
				book.setPrice(rs.getInt(5));
				getBooksbyCategory.add(book);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getBooksbyCategory;
	
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		List<Book> getBooksbyAuthor = new ArrayList<>();
		String sql = "select * from Book where author=?";
		Connection connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			
			connection = ModelDAO.openConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, author);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				Book book = new Book();
				book.setTitle(rs.getString(1));
				book.setAuthor(rs.getString(2));
				book.setCategory(rs.getString(3));
				book.setBookid(rs.getInt(4));
				book.setPrice(rs.getInt(5));
				getBooksbyAuthor.add(book);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getBooksbyAuthor;
	}

}
