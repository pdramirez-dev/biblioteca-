package com.pdprogramer.biblioteca.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.pdprogramer.biblioteca.R;
import com.pdprogramer.biblioteca.adapter.BookAdapter;
import com.pdprogramer.biblioteca.data.BookDataSource;
import com.pdprogramer.biblioteca.main.MainActivity;

public class SearchActivity extends AppCompatActivity {
    private ListView listView;
    private BookDataSource bookDataSource;
    private BookAdapter bookAdapter;
    private String autor;
    private SearchView search;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        back=(ImageButton)findViewById(R.id.button_back_s);
        listView=(ListView)findViewById(R.id.list_search);
        search = (SearchView) findViewById(R.id.capm_search);
        search.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                    return false;

            }
        } );
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToMain();
            }
        });




    }


    private void goToMain(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
