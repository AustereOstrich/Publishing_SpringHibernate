package com.matthewharrop.part1assignment4.app;

import com.matthewharrop.part1assignment4.config.AppConfig;
import com.matthewharrop.part1assignment4.dao.BooksDao;
import com.matthewharrop.part1assignment4.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class FindingBooksWithAuthorIds {

private static Logger logger = LoggerFactory.getLogger(
        com.matthewharrop.part1assignment4.app.FindingBooksWithAuthorAndCategoryByIdApp.class);

    public static void main(String... args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BooksDao booksDao = ctx.getBean(BooksDao.class);

        logger.info("============== Listing books with author and category by author's ID:  ==============");
        int authorID = 4;
        List<Book> books = booksDao.findAllByAuthorId(authorID);
        logger.info("Books for author ID: " + authorID);

        for (Book book : books) {
            logger.info(book.toString());
        }

        logger.info("============== Listing books with author and category by author's ID END==============");

        ctx.close();
        System.exit(0);
    }

}
