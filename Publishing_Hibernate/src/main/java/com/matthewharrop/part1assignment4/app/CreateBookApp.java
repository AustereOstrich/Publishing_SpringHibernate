package com.matthewharrop.part1assignment4.app;

import com.matthewharrop.part1assignment4.config.AppConfig;
import com.matthewharrop.part1assignment4.dao.BooksDao;
import com.matthewharrop.part1assignment4.domain.Author;
import com.matthewharrop.part1assignment4.domain.Book;
import com.matthewharrop.part1assignment4.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class CreateBookApp {

    private static Logger logger = LoggerFactory.getLogger(
            CreateBookApp.class);

    public static void main(String... args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BooksDao booksDao = ctx.getBean(BooksDao.class);

        logger.info("============== Creating a New Book ==============");
        Book book = new Book();
        Author author = new Author("Robin", "Hobb", "Creator of Bingtown and the Rain Wild River.");

        book.addAuthor(author);
        book.setCategory(new Category("Fantasy", 2L));
        book.setId(7);
        book.setIsbn("2583691478");
        book.setPrice((float) 13.49);
        book.setTitle("Ship of Magic");

        logger.info("Adding Book: " + book.toString());


            booksDao.createBook(book, author);
        List<Book> bookList = booksDao.findAllWithAuthorAndCategory();
        FindingBooksWithAuthorAndCategoryApp.listBooksWithAUthorsAndCategories(bookList);

        ctx.close();
        System.exit(0);
    }

}
