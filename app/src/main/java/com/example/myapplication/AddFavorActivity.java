package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class AddFavorActivity extends AppCompatActivity implements View.OnClickListener{
    private Button save; // 收藏按钮
    private EditText input;  // 输入框
    private TextView result; // 显示搜索结果

    BookViewModel bookViewModel;
    Book bookfound;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfavor);
        System.out.println("加藏界面加载完成");

        Button search = findViewById(R.id.search); // 搜索按钮
        search.setOnClickListener(this); // 搜索按钮响应
        save = findViewById(R.id.save);
        save.setOnClickListener(this); // 收藏按钮响应
        save.setEnabled(false);
        input = findViewById(R.id.textinput);
        result = findViewById(R.id.result);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.search) { // 搜索按钮
            try {
                bookfound = bookViewModel.getBookByName(input.getText().toString()); // 调用数据库搜索书本
                if(bookfound != null) { // 搜索结果不为空
                    save.setEnabled(true); // 启用收藏按钮
                    result.setText("书名: " + bookfound.getTitle() + "\n作者: " +
                            bookfound.getAuthor() + "\n出版年份: " + bookfound.getYear()
                            + "\n出版社: " + bookfound.getPublisher()); // 显示搜索结果
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else { // 收藏按钮
            bookfound.setSaved(1); // 设为已收藏
            bookViewModel.update(bookfound); // 更新数据库
            save.setEnabled(false); // 收藏按钮设为不可点击
        }
    }
}
