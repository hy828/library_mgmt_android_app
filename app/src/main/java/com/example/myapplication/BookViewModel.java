package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class BookViewModel extends AndroidViewModel {

    BookRepository bookRepository;

    public BookViewModel(Application application) {
        super(application);
        bookRepository = new BookRepository(application);
    }

    LiveData<List<Book>> getBookList() {
        return bookRepository.getBookList();
    } // 搜索全部

    LiveData<List<Book>> getFavBookList() {
        return bookRepository.getFavBookList();
    } // 搜索已收藏的

    void update(Book book) {
        bookRepository.update(book);
    } // 更新

    Book getBookByName(String i) throws ExecutionException, InterruptedException { // 搜索书名
        return bookRepository.getBookByName(i);
    }
}
