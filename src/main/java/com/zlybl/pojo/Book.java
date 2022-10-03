package com.zlybl.pojo;

import java.util.Date;

public class Book {
    private Integer id;
    private String bname;
    private String author;
    private double price;
    private String press;
    private Date saletime;

    public Book() {
    }

    public Book(Integer id, String bname, String author, double price, String press, Date saletime) {
        this.id = id;
        this.bname = bname;
        this.author = author;
        this.price = price;
        this.press = press;
        this.saletime = saletime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Date getSaletime() {
        return saletime;
    }

    public void setSaletime(Date saletime) {
        this.saletime = saletime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", saletime=" + saletime +
                '}';
    }
}
