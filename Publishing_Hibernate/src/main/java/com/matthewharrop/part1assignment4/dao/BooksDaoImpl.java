package com.matthewharrop.part1assignment4.dao;

import com.matthewharrop.part1assignment4.domain.Author;
import com.matthewharrop.part1assignment4.domain.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Repository("booksDaoImpl")
public class BooksDaoImpl implements BooksDao {

    private static final Log logger = LogFactory.getLog(BooksDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Book", Book.class).list();
    }

    @Transactional(readOnly = true)
    public List<Book> findAllWithAuthorAndCategory() {
        return sessionFactory.getCurrentSession().getNamedQuery("Book.findBookWithAuthorAndCategory").list();
    }

    @Transactional(readOnly = true)
    public Book findAllWithAuthorAndCategoryById(int id) {
        return (Book) sessionFactory.getCurrentSession().getNamedQuery("Book.findBookWithAuthorAndCategoryById").
                setParameter("id", id).uniqueResult();

    }

    @Transactional(readOnly = true)
       public List<Book> findAllByAuthorId(int id) {
//            Author author = sessionFactory.getCurrentSession().createQuery("from Author where id = id", Author.class);
        Author author = (Author) sessionFactory.getCurrentSession().createQuery("select distinct a from Author a " +
//                "left join fetch b.category c " +
//                "left join fetch b.author a" +
                "where a.id = :id").setParameter("id", id).uniqueResult();
        return author.books;
//            return sessionFactory.getCurrentSession().createQuery("from Book", Book.class).list();
        }

    public Book createBook(Book book, Author author) {
        sessionFactory.getCurrentSession().save(book);
        logger.info("Book added to DB with ID: " + book.id);
        return book;
    }

    public void deleteBook(Book book) {
        book.removeAuthor(book.author);
        sessionFactory.getCurrentSession().delete(book);
        logger.info("Book deleted with ID: ");
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //Inject the SessionFactory
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
