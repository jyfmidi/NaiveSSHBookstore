package com.service;

import com.dao.BookDao;
import com.entity.BooksEntity;

import java.util.Vector;

/**
 * Created by 滩涂上的芦苇 on 2016/6/7.
 */
public class BookService {
    private BookDao dao;

    public void setDao (BookDao d) {
        dao = d;
    }

    public void addBook(BooksEntity book) throws Exception {
        // TODO Auto-generated method stub
        try {
            dao.addBook(book);
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateBook(BooksEntity book) throws Exception {
        // TODO Auto-generated method stub
        try {
            dao.updateBook(book);
        } catch (Exception e) {
            throw e;
        }
    }

    public Vector<BooksEntity> queryAll() throws Exception {
        // TODO Auto-generated method stub
        Vector<BooksEntity> books = null;
        try {
            books = dao.queryAll();
        } catch (Exception e) {
            throw e;
        }

        return books;
    }

    public Vector<String> queryAllCategory() throws Exception{
        Vector<String> categorys=null;
        try{
            categorys=dao.queryAllCategory();
        }catch (Exception e)
        {
            throw e;
        }
        return  categorys;
    }

    public BooksEntity queryByIsbn(String isbn) throws Exception {
        // TODO Auto-generated method stub
        BooksEntity book = null;
        try {
            book = dao.queryByIsbn(isbn);
        } catch (Exception e) {
            throw e;
        }

        return book;
    }

    public Vector<BooksEntity> queryByTitle(String title) throws Exception {
        // TODO Auto-generated method stub
        Vector<BooksEntity> books = null;
        try {
            books = dao.queryByTitle(title);
        } catch (Exception e) {
            throw e;
        }

        return books;
    }

    public Vector<BooksEntity> queryByCategory(String category) throws Exception {
        // TODO Auto-generated method stub
        Vector<BooksEntity> books = null;
        try {
            books = dao.queryByCategory(category);
        } catch (Exception e) {
            throw e;
        }

        return books;
    }

    public void deleteByIsbn(String isbn) throws Exception {
        // TODO Auto-generated method stub
        try {
            dao.deleteByIsbn(isbn);
        } catch (Exception e) {
            throw e;
        }
    }
}
