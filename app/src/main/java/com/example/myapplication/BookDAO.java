package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDAO {

    @Insert
    void insertBooks(List<Book> books); // 插入

    @Update
    void update(Book book); // 更新

    @Query("SELECT * FROM library")
    LiveData<List<Book>> getBookList(); // 搜索全部

    @Query("SELECT * FROM library WHERE title = :i")
    Book getBookByName(String i); // 搜索书名

    @Query("SELECT * FROM library WHERE saved == 1")
    LiveData<List<Book>> getFavBookList(); // 搜索已收藏的书
}
