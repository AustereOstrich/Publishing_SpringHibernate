package com.matthewharrop.part1assignment4.domain;

import org.springframework.jdbc.core.RowMapper;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Entity
@Table(name = "CATEGORY")

public class Category {

    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column
    public String name;

    public Category(){};

    public Category(String name, Long id) {
        this.name = name;
        this.id = id;
    }
//    private Set<Book> bookSet;
//    private List<Book> bookList;
//    private Map<String, Book> bookMap;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



//    public Set<Book> getBookSet() {
//        return bookSet;
//    }
//
//    public void setBookSet(Set<Book> bookSet) {
//        this.bookSet = bookSet;
//    }
//
//    public List<Book> getbookList() {
//        return bookList;
//    }
//
//    public void setbookList(List<Book> bookList) {
//        this.bookList = bookList;
//    }
//
//    public Map<String, Book> getBookMap() {
//        return bookMap;
//    }
//
//    public void setBookMap(Map<String, Book> bookMap) {
//        this.bookMap = bookMap;
//    }

    ArrayList<String> outputWrapper(String collectionName) {
        int stringWidth = 0;
        String outputStart = collectionName + " Output Start ";
        String outputEnd = collectionName + " Output End ";
        for (Character character : outputStart.toCharArray()) {
            stringWidth ++;
        };
        StringBuilder builder = new StringBuilder(outputStart);
        while (stringWidth < 60) {
            builder.insert(0, "=");
            builder.append("=");
            stringWidth += 2;
        }
        builder.append("\n");
        stringWidth = 0;
        for (Character character : outputEnd.toCharArray()) {
            stringWidth ++;
        };
        StringBuilder builder2 = new StringBuilder(outputEnd);
        while (stringWidth < 60) {
            builder2.insert(0, "=");
            builder2.append("=");
            stringWidth += 2;
        }
        builder2.insert(0, "\n");
        builder2.append("\n");
        ArrayList<String> array = new ArrayList<String>();
        array.add(builder.toString());
        array.add(builder2.toString());
        for (String string : array) {
            string.concat("\n");
        }
        return array;
    }

    public String toString() {
     return "Category -- ID: " + id + ", Name: " + name;
    }

//    @Override public String toString() {
//        String string = "";
//        string = string.concat(outputWrapper("Books Set").get(0));
//        int bookNum = 0;
//        Iterator<Book> bookIterator = bookSet.iterator();
//        while (bookIterator.hasNext()) {
//            string = string.concat(bookIterator.next().toString());
//            if (bookIterator.hasNext()) {
//                string = string.concat(", ");
//            }
//        }
//        string = string.concat(outputWrapper("Books Set").get(1));
//
//
//
//        return string;
//    }
}
