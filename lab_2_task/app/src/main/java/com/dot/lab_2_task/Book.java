package com.dot.lab_2_task;

public class Book
{
    int img;
    String title;
    String author;
    String ISBN;
    String issued;
    String issuedTo;
    String No_of_books_available;


//    public Book(int img, String title, String author, String ISBN) {
//        this.img = img;
//        this.title = title;
//        this.author = author;
//        this.ISBN = ISBN;
//    }

    public Book(int img, String title, String author, String ISBN, String issued, String issuedTo, String no_of_books_available) {
        this.img = img;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.issued = issued;
        this.issuedTo = issuedTo;
        No_of_books_available = no_of_books_available;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "img=" + img +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", issued='" + issued + '\'' +
                ", issuedTo='" + issuedTo + '\'' +
                ", No_of_books_available='" + No_of_books_available + '\'' +
                '}';
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public String getNo_of_books_available() {
        return No_of_books_available;
    }

    public void setNo_of_books_available(String no_of_books_available) {
        No_of_books_available = no_of_books_available;
    }
}

