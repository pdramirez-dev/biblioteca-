package com.pdprogramer.biblioteca.data;


import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(Context context) {
        super(context, BookDataSource.DATABASE_NAME, null, BookDataSource.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BOOK_TABLE = "create table " +
                BookDataSource.TABLE_BOOKS + "(" + BookDataSource.ColumnBook.ROW_ISO + " integer primary key," +
                BookDataSource.ColumnBook.ROW_TITLE + " text," +
                BookDataSource.ColumnBook.ROW_AUTOR + " text," +
                BookDataSource.ColumnBook.ROW_GENERO + " text," +
                BookDataSource.ColumnBook.ROW_YEARP + " text" + ")";
        db.execSQL(CREATE_BOOK_TABLE);
        db.execSQL(BookDataSource.CREATE_TEST_BOOK);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + BookDataSource.TABLE_BOOKS);
        onCreate(db);

    }
    //Crud DB Books


}
