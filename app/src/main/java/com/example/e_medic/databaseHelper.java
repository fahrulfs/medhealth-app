package com.example.e_medic;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseHelper extends SQLiteOpenHelper {

    public databaseHelper(Context context) {
        super(context, "loginSQLite.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        MEMBUAT TABEL DAN KOLOM

//        1. Membuat table session dengan kolom id dan login
        db.execSQL("CREATE TABLE session(id integer PRIMARY KEY, login text)");
//        2. Membuat table user dengan kolom id ,username dan password
        db.execSQL("CREATE TABLE user(id integer PRIMARY KEY AUTOINCREMENT, username  text,password text)");
//        3.Pengigisian kedalam session, values id diisi 1 dan login dengan no data
        db.execSQL("INSERT INTO session(id,login)VALUES(1,'nodata')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        MEMBUAT PERINTAH JIKA SAAT PERTAMA KALI DIINSTAL MAKA PROSES PEMBAUATN TABLE PADA ONCREATE AKAN DILAKUKAN. DAN JIKA MENGHAPUS DAN MENGINSTAL LAGI MAKA TABLE PADA ON CREATE AKAN TERHAPUS
        db.execSQL("DROP TABLE IF EXISTS session");
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }


//    Jika login session yang awalnya kosong maka akan berubah menjadi ada isinya
    public boolean upgradeSession(String sessionValues, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        BUAT SUPAYA ISI DI KOLOM LOGIN SESUAI PARAMETER SESSIONVALUES
        contentValues.put("login", sessionValues);
        long update = db.update("session", contentValues, "id=" + id, null);
        return update != 0;
    }

    //    INSERT DATA KE TABEL USER MELALUI HALAMAN REGISTRASI
    public boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long insert = db.insert("user", null, contentValues);
        return insert != 0;
    }

//    PENGECEKAN SAAT LOGIN
    public boolean checkLogin(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM user WHERE username =? AND password =?", new String[]{username, password});
        return cursor.getCount() > 0;
    }
}