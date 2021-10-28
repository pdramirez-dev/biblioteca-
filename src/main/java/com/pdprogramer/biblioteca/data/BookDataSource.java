package com.pdprogramer.biblioteca.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pdprogramer.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDataSource {
    //BD config
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BookStore";
    public static final String TABLE_BOOKS = "books";

    //TABLE Columns
    public static class ColumnBook {
        public static final String ROW_ISO = "iso";
        public static final String ROW_TITLE = "title";
        public static final String ROW_AUTOR = "autor";
        public static final String ROW_GENERO = "genero";
        public static final String ROW_YEARP = "year_p";
    }

    private SQLiteDatabase database;
    private DatabaseHandler databaseHandler;

    public BookDataSource(Context context) {
        databaseHandler = new DatabaseHandler(context);
        database = databaseHandler.getWritableDatabase();


    }

    public static final String CREATE_TEST_BOOK=
            "insert into "+TABLE_BOOKS
                    +" values("+"0,"+"\"El viejo y El Mar\","+"\"Ernest Hamiway\","+"\"Novela\","+"\"1990\"),"+
                    "("+"1,"+"\"La Edad de Oro\","+"\"Jose Marti\","+"\"Infantil\","+"\"1885\");";



    public void addBook(Book book) {

        ContentValues values = new ContentValues();
        values.put(ColumnBook.ROW_ISO, book.getIso());
        values.put(ColumnBook.ROW_TITLE, book.getTitle());
        values.put(ColumnBook.ROW_AUTOR, book.getAutor());
        values.put(ColumnBook.ROW_GENERO, book.getGenero());
        values.put(ColumnBook.ROW_YEARP, book.getYear_p());
        database.insert(TABLE_BOOKS, null, values);
        database.close();
    }

    public Book getBook(int iso) {

        Cursor cursor = database.query(
                TABLE_BOOKS, new String[]{
                        ColumnBook.ROW_ISO,
                        ColumnBook.ROW_TITLE,
                        ColumnBook.ROW_AUTOR,
                        ColumnBook.ROW_GENERO,
                        ColumnBook.ROW_YEARP
                }, ColumnBook.ROW_ISO + "=?", new String[]{String.valueOf(iso)}, null, null, null, null);


        if (cursor != null) {
            cursor.moveToFirst();
            Book book = new Book(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            return book;


        } else {
            return null;
        }
    }

    public Book getBook(String title) {

        Cursor cursor = database.query(
                TABLE_BOOKS, new String[]{
                        ColumnBook.ROW_ISO,
                        ColumnBook.ROW_TITLE,
                        ColumnBook.ROW_AUTOR,
                        ColumnBook.ROW_GENERO,
                        ColumnBook.ROW_YEARP
                }, ColumnBook.ROW_AUTOR + "=?", new String[]{title}, null, null, null, null);


        if (cursor != null) {
            cursor.moveToFirst();
            Book book = new Book(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            return book;


        } else {
            return null;
        }
    }

    public List<Book> getBooksAutor(String autor) {
        List<Book> bookList = new ArrayList<Book>();
        String selectQuery = "select * from " + TABLE_BOOKS + " where " + ColumnBook.ROW_AUTOR + " = ?";

        Cursor cursor = database.rawQuery(selectQuery, new String[]{autor});
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setIso(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAutor(cursor.getString(2));
                book.setGenero(cursor.getString(3));
                book.setYear_p(cursor.getString(4));
                bookList.add(book);

            } while (cursor.moveToNext());
        }


        return bookList;
    }

    public List<Book> getAllBook() {
        List<Book> bookList = new ArrayList<Book>();
        String selectQuery = "select * from " + TABLE_BOOKS;

        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setIso(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAutor(cursor.getString(2));
                book.setGenero(cursor.getString(3));
                book.setYear_p(cursor.getString(4));
                bookList.add(book);

            } while (cursor.moveToNext());
        }


        return bookList;
    }

    public int updateBook(Book book) {

        ContentValues values = new ContentValues();
        values.put(ColumnBook.ROW_TITLE, book.getTitle());
        values.put(ColumnBook.ROW_AUTOR, book.getAutor());
        values.put(ColumnBook.ROW_GENERO, book.getGenero());
        values.put(ColumnBook.ROW_YEARP, book.getYear_p());

        return database.update(TABLE_BOOKS, values, ColumnBook.ROW_ISO + " = ?", new String[]{String.valueOf(book.getIso())});
    }

    public void deleteBook(Book book) {

        database.delete(TABLE_BOOKS, ColumnBook.ROW_ISO + "=?", new String[]
                {String.valueOf(book.getIso())});
        database.close();
    }
}
