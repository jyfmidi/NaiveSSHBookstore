package com.dao;

import com.entity.BooksEntity;

import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/7.
 */
public interface BookDao {
    // add a book to the database
    public void addBook(BooksEntity book) throws Exception;
    // update a book
    public void updateBook(BooksEntity book) throws Exception;
    // query all books
    public Vector<BooksEntity> queryAll() throws Exception;
    // query a single book by isbn
    public BooksEntity queryByIsbn(String isbn) throws Exception;
    // query books from database where book title includes string title
    public Vector<BooksEntity> queryByTitle(String title) throws Exception;
    // query books from database where book category includes string category
    public Vector<BooksEntity> queryByCategory(String category) throws Exception;
    // delete a book from database
    public void deleteByIsbn(String isbn) throws Exception;

    public Vector<String> queryAllCategory() throws Exception;
}
