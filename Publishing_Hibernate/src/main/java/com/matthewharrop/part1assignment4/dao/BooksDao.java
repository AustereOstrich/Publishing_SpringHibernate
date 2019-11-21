package com.matthewharrop.part1assignment4.dao;

import com.matthewharrop.part1assignment4.domain.Author;
import com.matthewharrop.part1assignment4.domain.Book;

import java.util.List;

public interface BooksDao {
    List<Book> findAll();

    List<Book> findAllWithAuthorAndCategory();

    List<Book> findAllByAuthorId(int id);

    Book findAllWithAuthorAndCategoryById(int id);

    Book createBook(Book book, Author author);

    void deleteBook(Book book);

}