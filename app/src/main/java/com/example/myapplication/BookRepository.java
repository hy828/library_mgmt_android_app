package com.example.myapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class BookRepository {

    BookDAO bookDAO;

    BookRepository(Application application) {
        MyDatabase myDatabase = MyDatabase.getDatabase(application);
        bookDAO = myDatabase.getBookDao();
    }

    LiveData<List<Book>> getBookList() {
        return bookDAO.getBookList();
    } // 搜索全部

    LiveData<List<Book>> getFavBookList() {
        return bookDAO.getFavBookList();
    } // 搜索已收藏的书本
    void update(Book book) { // 异步更新
        new UpdateBookAsyncTask(bookDAO).execute(book);
    }

    void insertBooks(List<Book> books) { // 异步插入
        new InsertBookAsyncTask(bookDAO).execute(books);
    }

    Book getBookByName(String i) throws ExecutionException, InterruptedException { // 异步搜索
        return new QueryBookAsyncTask(bookDAO).execute(i).get();
    }

    private static class QueryBookAsyncTask extends AsyncTask<String, Void, Book> {
        private BookDAO bookDAO;

        private QueryBookAsyncTask(BookDAO bookDAO) {
            this.bookDAO = bookDAO;
        }

        @Override
        protected Book doInBackground(String... strings) {
            return bookDAO.getBookByName(strings[0]);
        }
    }

    private static class InsertBookAsyncTask extends AsyncTask<List<Book>, Void, Void> {
        private BookDAO bookDAO;

        private InsertBookAsyncTask(BookDAO bookDAO) {
            this.bookDAO = bookDAO;
        }

        @Override
        protected Void doInBackground(List<Book>... lists) {
            bookDAO.insertBooks(lists[0]);
            return null;
        }
    }

    private static class UpdateBookAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDAO bookDAO;

        private UpdateBookAsyncTask(BookDAO bookDAO) {
            this.bookDAO = bookDAO;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDAO.update(books[0]);
            return null;
        }
    }
}
