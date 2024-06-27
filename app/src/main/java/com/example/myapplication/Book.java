package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "library")
public class Book {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    private int id;

    @ColumnInfo(name = "title", typeAffinity = ColumnInfo.TEXT)
    private String title; // 书名

    @ColumnInfo(name = "author", typeAffinity = ColumnInfo.TEXT)
    private String author; // 作者

    @ColumnInfo(name = "publisher", typeAffinity = ColumnInfo.TEXT)
    private String publisher; // 出版社

    @ColumnInfo(name = "year", typeAffinity = ColumnInfo.INTEGER)
    private int year; // 出版年份

    @ColumnInfo(name = "saved", typeAffinity = ColumnInfo.INTEGER)
    private int saved; // 收藏

    public Book(int id, String title, String author, String publisher, int year, int saved)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.saved = saved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getSaved() {
        return saved;
    }

    public void setSaved(int saved) {
        this.saved = saved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}