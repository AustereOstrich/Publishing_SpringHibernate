package com.matthewharrop.part1assignment4.app;

import com.matthewharrop.part1assignment4.config.AppConfig;
import com.matthewharrop.part1assignment4.dao.BooksDao;
import com.matthewharrop.part1assignment4.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class FindingBooksWithAuthorAndCategoryApp {

    private static Logger logger = LoggerFactory.getLogger(
            FindingBooksHibernateApp.class);

    public static void main(String... args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BooksDao booksDao = ctx.getBean(BooksDao.class);

        logger.info("============== Find all books with authors and categories start ==============");
        List<Book> allBooks = booksDao.findAllWithAuthorAndCategory();
        listBooksWithAUthorsAndCategories(allBooks);
        logger.info("============== Find all books with authors and categories end ==============");

        ctx.close();
        System.exit(0);
    }

    public static void listBooksWithAUthorsAndCategories(List<Book> books) {
        logger.info(" ---- Listing books with author and category:");
        for (Book book : books) {
            logger.info(book.toString());
            logger.info(book.category.toString());
            logger.info(book.author.toString());
            logger.info("-----------------------------------");
        }

    }

}
