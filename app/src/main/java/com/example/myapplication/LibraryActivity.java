package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    RecyclerView rv;
    LibAdapter la;
    BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        System.out.println("书库界面加载完成");

        rv = findViewById(R.id.library);
        la = new LibAdapter();
        rv.setAdapter(la);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getBookList().observe(this, bookList -> { // 搜索全部书籍
            if(bookList == null) {
                return ;
            }
//            System.out.println(bookList.size());
//            for(Book book: bookList) {
//                System.out.println(book.getTitle() + "," + book.getAuthor());
//            }
            la.setBookList(bookList);
        });
    }

    class LibAdapter extends RecyclerView.Adapter<LibViewHolder> {
        private List<Book> bookList = new ArrayList<>();
        @NonNull
        @Override
        public LibViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(LibraryActivity.this, R.layout.list, null);
            LibViewHolder libViewHolder = new LibViewHolder(view);
            return libViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull LibViewHolder holder, int position) {
            Book book = bookList.get(position);
            holder.book.setText("书名: " + book.getTitle() + "\n作者: " +
                    book.getAuthor() + "\n出版年份: " + book.getYear()
                    + "\n出版社: " + book.getPublisher());
        }

        @Override
        public int getItemCount() {
            return bookList.size();
        }

        public void setBookList(List<Book> bookList) {
            this.bookList = bookList;
            notifyDataSetChanged();
        }
    }

    class LibViewHolder extends RecyclerView.ViewHolder {
        TextView book;

        public LibViewHolder(@NonNull View itemView) {
            super(itemView);
            book = itemView.findViewById(R.id.book);
        }
    }

//    static class InsertAsyncTask extends AsyncTask<Book, Void, Void> {
//        private BookDAO bookDAO;
//        public InsertAsyncTask(BookDAO b) {
//            this.bookDAO = b;
//        }
//
//        @Override
//        protected Void doInBackground(Book... books) {
//            bookDAO.insertBooks(books);
//            return null;
//        }
//    }
}