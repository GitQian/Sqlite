package com.mesada.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mesada.sqlite.com.mesada.sqlite.db.UserInfoDAL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv;
    private Button insertBtn;
    private Button deleteBtn;
    private Button updateBtn;
    private Button queryBtn;

    private EditText userEdit;
    private EditText phoneEdit;

    UserInfoDAL userInfoDAL = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_main);

        insertBtn = (Button) findViewById(R.id.btn_insert);
        deleteBtn = (Button) findViewById(R.id.btn_delete);
        updateBtn = (Button) findViewById(R.id.btn_update);
        queryBtn = (Button) findViewById(R.id.btn_query);
        userEdit = (EditText) findViewById(R.id.edit_user);
        phoneEdit = (EditText) findViewById(R.id.edit_phone);

        insertBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        queryBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String name;
        String phone;
        switch (v.getId()) {
            case R.id.btn_insert:
                name = userEdit.getText().toString();
                phone = phoneEdit.getText().toString();

                userInfoDAL = new UserInfoDAL(this);
                userInfoDAL.addUser(name, phone);
                break;

            case R.id.btn_delete:

                break;

            case R.id.btn_update:

                break;

            case R.id.btn_query:
                name = userEdit.getText().toString();
                userInfoDAL = new UserInfoDAL(this);
                String result = userInfoDAL.getUserPhone(name);
                tv.setText(result);
                break;

            default:
                break;
        }
    }
}
