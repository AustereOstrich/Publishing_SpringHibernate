package com.matthewharrop.part1assignment4.app;

import com.matthewharrop.part1assignment4.config.AppConfig;
import com.matthewharrop.part1assignment4.dao.BooksDao;
import com.matthewharrop.part1assignment4.dao.BooksDaoImpl;
import com.matthewharrop.part1assignment4.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import java.util.List;

public class FindingBooksHibernateApp {

    private static Logger logger = LoggerFactory.getLogger(
            FindingBooksHibernateApp.class);

    public static void main(String... args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BooksDao booksDao = ctx.getBean(BooksDao.class);

        logger.info("============== Find all books start ==============");
        List<Book> allBooks = booksDao.findAll();
        listBooks(allBooks);
        logger.info("============== Find all books end ==============");

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
