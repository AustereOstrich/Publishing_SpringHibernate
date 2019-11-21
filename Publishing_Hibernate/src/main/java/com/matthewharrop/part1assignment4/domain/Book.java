package com.matthewharrop.part1assignment4.domain;

import org.dom4j.tree.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BOOKS")

@NamedQueries({
        @NamedQuery(name=Book.FIND_BOOKS_WITH_AUTHOR_AND_CATEGORY,
                query="select distinct b from Book b " +
                        "left join fetch b.category c " +
                        "left join fetch b.author a"
        ),
        @NamedQuery(
                name=Book.FIND_BOOKS_WITH_AUTHOR_AND_CATEGORY_BY_ID,
                query="select distinct b from Book b " +
                        "left join fetch b.category c " +
                        "left join fetch b.author a " +
                        "where b.id = :id"
        )
})

public class Book extends AbstractEntity {

    @Id
    @GeneratedValue
    @Column
    public int id;
    @Column
    public String isbn;
    @Column
    public String title;
    @Column
    public Float price;
    @OneToOne
    @JoinColumn(name="CATEGORY_ID")
    public Category category;

    public static final String FIND_BOOKS_WITH_AUTHOR_AND_CATEGORY =
            "Book.findBookWithAuthorAndCategory";
    public static final String FIND_BOOKS_WITH_AUTHOR_AND_CATEGORY_BY_ID =
            "Book.findBookWithAuthorAndCategoryById";

    private static Logger logger = LoggerFactory.getLogger(
            Book.class);

    public void setId(int id) {
        this.id = id;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void setCategory(Category category) { this.category = category; }

    public void reading() {
        logger.info("Reading " + title + " book");
    }

    public void throwException() throws RuntimeException {
        throw new RuntimeException("Book Bean Exception");
    }

//    cascade=CascadeType.ALL
//    @OneToOne(mappedBy = "book", cascade=CascadeType.ALL, orphanRemoval = true)
//    @JoinTable(name="AUTHOR_BOOK",
//            joinColumns = @JoinColumn(name="BOOK_ID"),
//            inverseJoinColumns = @JoinColumn(name="AUTHOR_ID")
//    )
//    public Author author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="AUTHOR_BOOK",
            joinColumns = @JoinColumn(name="BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name="AUTHOR_ID")
    )
    public Author author;

    public void addAuthor(Author author) {
        this.author = author;
        author.addBook(this);
    }

    public void removeAuthor(Author author) {
        if (author != null) {
            author.removeBook(this);
        }
        this.author = null;
    }


    public String toString() {
        String bookString = "Book - ID: " + id + " Category ID: " + category.getId() + ", ISBN: " + isbn + ", Title: " + title +
                ", Price: " + price;
        return bookString;
    }

    public Book() {
    }

    public Book(int id, String isbn, String title, Float price) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    public Book(Category category, String title, String isbn, Float price) {
        this.category = category;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(price, book.price) &&
                Objects.equals(category, book.category) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, price, category, author);
    }

//    @Override public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        if (!super.equals(o))
//            return false;
//        Book book = (Book) o;
//        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null)
//            return false;
//        if (title != null ? !title.equals(book.title) : book.title != null)
//            return false;
//        return price != null ? price.equals(book.price) : book.price == null;
//    }
//
//    @Override public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
//        result = 31 * result + (title != null ? title.hashCode() : 0);
//        result = 31 * result + (price != null ? price.hashCode() : 0);
//        return result;
//    }

}
