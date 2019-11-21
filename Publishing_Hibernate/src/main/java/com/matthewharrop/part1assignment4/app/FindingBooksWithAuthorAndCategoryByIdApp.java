package com.matthewharrop.part1assignment4.app;

import com.matthewharrop.part1assignment4.config.AppConfig;
import com.matthewharrop.part1assignment4.dao.BooksDao;
import com.matthewharrop.part1assignment4.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class FindingBooksWithAuthorAndCategoryByIdApp {

    private static Logger logger = LoggerFactory.getLogger(
            FindingBooksWithAuthorAndCategoryByIdApp.class);

    public static void main(String... args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BooksDao booksDao = ctx.getBean(BooksDao.class);

        logger.info("============== Listing boook with author and category by book's ID:  ==============");
        Book book = booksDao.findAllWithAuthorAndCategoryById(1);
        logger.info(book.toString());
        logger.info(book.category.toString());
        logger.info(book.author.toString());

        ctx.close();
        System.exit(0);
    }

}
