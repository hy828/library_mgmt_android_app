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

import java.util.ArrayList;
import java.util.List;

public class FavouritesActivity extends AppCompatActivity {

    RecyclerView rv;
    FavAdapter fa;
    BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        System.out.println("收藏界面加载完成");

        rv = findViewById(R.id.favourites);
        fa = new FavAdapter();
        rv.setAdapter(fa);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getFavBookList().observe(this, bookList -> { // 搜索已收藏的书籍
            if(bookList == null) {
                return ;
            }
//            System.out.println(bookList.size());
//            for(Book book: bookList) {
//                System.out.println(book.getTitle() + "," + book.getAuthor());
//            }
            fa.setBookList(bookList);
        });
    }

    class FavAdapter extends RecyclerView.Adapter<FavViewHolder> {
        private List<Book> bookList = new ArrayList<>();
        @NonNull
        @Override
        public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(FavouritesActivity.this, R.layout.list, null);
            FavViewHolder favViewHolder = new FavViewHolder(view);
            return favViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
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

    class FavViewHolder extends RecyclerView.ViewHolder {
        TextView book;

        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            book = itemView.findViewById(R.id.book);
        }
    }
}