package com.mesada.sqlite.com.mesada.sqlite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 2016/9/7.
 */
public class UserInfoDAL {
    private SQLiteDatabase db;
    private Context mContext;

    public UserInfoDAL(Context context) {
        mContext = context;
        db = MySqliteOpenHelper.getInstance(context).getWritableDatabase();
    }

    public int addUser(String name, String phone){
        ContentValues values = new ContentValues();
        values.put("user", name);
        values.put("phone", phone);
        db.insert("UserTable", null, values);
        return 0;
    }

    public String getUserPhone(String name) {
        Cursor cursor = db.query("UserTable", new String []{"phone"}, "user = ?", new String[]{name}, null, null, null);
        String phone = null;
        if (cursor.moveToFirst()) {
            do {
                phone = cursor.getString(cursor.getColumnIndex("phone"));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return phone;
    }
}
