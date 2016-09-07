package com.mesada.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mesada.sqlite.com.mesada.sqlite.db.UserInfoDAL;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_main);

        UserInfoDAL userInfoDAL = new UserInfoDAL(this);

        userInfoDAL.addUser("qiansheng", "13398584002");

        String phone = userInfoDAL.getUser("qiansheng");

        tv.setText(phone);


    }
}
