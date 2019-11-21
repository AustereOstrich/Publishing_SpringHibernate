package com.matthewharrop.part1assignment4.domain;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "AUTHORS")

public class Author extends AbstractEntity {

    @Id
    @Column
    @GeneratedValue
    private int ID;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="DESCRIPTION")
    private String description;


    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //mappedBy = "author",
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinTable(name="AUTHOR_BOOK",
            joinColumns = @JoinColumn(name="AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name="BOOK_ID")
    )
    public List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
        book.setAuthor(null);

//        if (book != null) {
//            book.setAuthor(null);
//        }
//        books.remove(book);
    }

    public Author(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    public Author() {
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public void setBook(Book book) {
//        this.book = book;
//    }

    public String toString() {
        return "Author -- ID: " + getID() + ", First Name: " + firstName +
                ", Last Name: " + lastName + ", Description: " + description;
    }

    public List getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return ID == author.ID &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(description, author.description) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, description, books);
    }

//    @Override public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        if (!super.equals(o))
//            return false;
//        Author author = (Author) o;
//        if (firstName != null ? !firstName.equals(author.firstName) : author.firstName != null)
//            return false;
//        if (lastName != null ? !lastName.equals(author.lastName) : author.lastName != null)
//            return false;
//        return description != null ? description.equals(author.description) : author.description == null;
//    }
//
//    @Override public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        return result;
//    }

}
