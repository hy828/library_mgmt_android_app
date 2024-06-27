package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected int savedBooks[];
    String dbName;
    List<Book> bookList;
    MyDatabase myDatabase;
    BookDAO bookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("主界面加载完成");

        Button btn1 = findViewById(R.id.addFavorButton); // 添加收藏按钮
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addFavIntent = new Intent(MainActivity.this, AddFavorActivity.class);
                System.out.printf("进入添加收藏页面");
                startActivity(addFavIntent);
            }
        });

        Button btn2 = findViewById(R.id.libraryButton); // 查看书库按钮
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent libIntent = new Intent(MainActivity.this, LibraryActivity.class);
                System.out.printf("进入查看书库页面");
                startActivity(libIntent);
            }
        });

        Button btn3 = findViewById(R.id.favouritesButton); // 查看收藏按钮
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favIntent = new Intent(MainActivity.this, FavouritesActivity.class);
                System.out.printf("进入查看收藏页面");
                startActivity(favIntent);
            }
        });

//        myDatabase = MyDatabase.getDatabase(getApplicationContext());
//        bookDAO = myDatabase.getBookDao();
//        List<Book> list = new ArrayList<>();
//        list.add(new Book(1, "红楼梦", "曹雪芹", "人民文学出版社", 1996, 0));
//        list.add(new Book(2, "活着", "余华", "作家出版社", 2012, 0));
//        list.add(new Book(3, "1984", "[英] 乔治·奥威尔 / 刘绍铭", "北京十月文艺出版社", 2010, 0));
//        list.add(new Book(4, "百年孤独", "[哥伦比亚] 加西亚·马尔克斯 / 范晔", "南海出版公司", 2011, 0));
//        list.add(new Book(5, "飘", "[美国] 玛格丽特·米切尔 / 李美华", "译林出版社", 2000, 0));
//        list.add(new Book(6, "房思琪的初恋乐园", "林奕含", "北京联合出版公司", 2018, 0));
//        list.add(new Book(7, "动物农场", "[英] 乔治·奥威尔 / 荣如德", "上海译文出版社", 2007, 0));
//        list.add(new Book(8, "白夜行", "[日] 东野圭吾 / 刘姿君", "南海出版公司", 2013, 0));
//        list.add(new Book(9, "小王子", "[法] 圣埃克苏佩里 / 马振聘", "人民文学出版社", 2003, 0));
//        list.add(new Book(10, "安徒生童话故事集", "[丹麦] 安徒生 / 叶君健", "人民文学出版社", 1997, 0));
//        list.add(new Book(11, "天龙八部", "金庸", "生活·读书·新知三联书店", 1994, 0));
//        list.add(new Book(12, "呐喊", "鲁迅", "人民文学出版社", 1973, 0));
//        list.add(new Book(13, "杀死一只知更鸟", "[美] 哈珀·李 / 高红梅", "译林出版社", 2012, 0));
//        list.add(new Book(14, "局外人", "[法] 阿尔贝·加缪 / 柳鸣九", "上海译文出版社", 2010, 0));
//        list.add(new Book(15, "人类简史 : 从动物到上帝", "[以色列] 尤瓦尔·赫拉利 / 林俊宏", "中信出版社", 2014, 0));
//        list.add(new Book(16, "东方快车谋杀案", "[英] 阿加莎·克里斯蒂 / 陈尧光", "人民文学出版社", 2006, 0));
//        Book book = new Book(1, "a", "b", "c", 2002, 0);
//        Book book2 = new Book(2, "aa", "ab", "ac", 2012, 1);

//        new Thread(() -> {
//            bookDAO.insertBooks(list);
//            System.out.println("Room 插入成功");、
//        }).start();
    }
}