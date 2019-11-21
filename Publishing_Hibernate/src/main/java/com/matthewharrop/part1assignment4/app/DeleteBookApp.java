package com.matthewharrop.part1assignment4.app;

import com.matthewharrop.part1assignment4.config.AppConfig;
import com.matthewharrop.part1assignment4.dao.BooksDao;
import com.matthewharrop.part1assignment4.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class DeleteBookApp {

    private static Logger logger = LoggerFactory.getLogger(
            DeleteBookApp.class);

    public static void main(String... args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BooksDao booksDao = ctx.getBean(BooksDao.class);

        logger.info("============== Deleting a Book ==============");
        logger.info("--------Here are the books before:--------");
        List<Book> bookList = booksDao.findAllWithAuthorAndCategory();
        FindingBooksWithAuthorAndCategoryApp.listBooksWithAUthorsAndCategories(bookList);
        int deleteID = 4;
        Book bookToDelete = booksDao.findAllWithAuthorAndCategoryById(deleteID);
        logger.info("Deleting book with id: " + deleteID);
        booksDao.deleteBook(bookToDelete);

//        logger.info("--------Here are the books after:-----------");
//        FindingBooksWithAuthorAndCategoryApp.listBooksWithAUthorsAndCategories(bookList);

        ctx.close();
        System.exit(0);
    }

    private static void listBooks(List<Book> books) {
        logger.info(" ---- Listing books:");
        for (Book book : books) {
            logger.info(book.toString());
        }
    }

}
