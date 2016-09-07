package com.mesada.sqlite.com.mesada.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 2016/9/7.
 */
public class UserInfoDAL {
    private SQLiteDatabase db;

    public UserInfoDAL(Context context) {
        db = MySqliteOpenHelper.getInstance(context).getWritableDatabase();
    }
}
