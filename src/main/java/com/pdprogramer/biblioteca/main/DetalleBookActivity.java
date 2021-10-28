package com.pdprogramer.biblioteca.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.pdprogramer.biblioteca.R;
import com.pdprogramer.biblioteca.data.BookDataSource;
import com.pdprogramer.biblioteca.model.Book;

public class DetalleBookActivity extends AppCompatActivity {
    private EditText iso_book;
    private EditText titulo_book;
    private EditText autor_book;
    private EditText genero_lite;
    private EditText year_p;
    private ImageButton back;
    private Button add_new;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_book);
        iso_book=(EditText)findViewById(R.id.iso_book);
        titulo_book=(EditText)findViewById(R.id.title_book);
        autor_book=(EditText)findViewById(R.id.autor_book);
        genero_lite=(EditText)findViewById(R.id.genero_book);
        year_p=(EditText)findViewById(R.id.year_p);
        back=(ImageButton)findViewById(R.id.button_back);
        add_new=(Button)findViewById(R.id.button_add);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBack();
            }
        });
        add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_book();
            }
        });
    }
    private void setBack(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void save_book(){

        if ((iso_book.getText().toString().isEmpty()||titulo_book.getText().toString().isEmpty()||autor_book.getText().toString().isEmpty()||genero_lite.getText().toString().isEmpty()||year_p.getText().toString().isEmpty())){

            Toast.makeText(this,"Rellene los Campos",Toast.LENGTH_LONG).show();
        }else {
            BookDataSource dataSource=new BookDataSource(this);

            Book book=new Book(
            Integer.parseInt(iso_book.getText().toString()),
                    titulo_book.getText().toString(),
                    autor_book.getText().toString(),
                    genero_lite.getText().toString(),
                    year_p.getText().toString()
            );
            dataSource.addBook(book);
            titulo_book.setText("");
            autor_book.setText("");
            iso_book.setText("");
            genero_lite.setText("");
            year_p.setText("");
            Toast.makeText(this,"Libro Agregado",Toast.LENGTH_LONG).show();



        }



    }
}
