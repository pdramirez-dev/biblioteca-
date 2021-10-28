package com.pdprogramer.biblioteca.main;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pdprogramer.biblioteca.R;
import com.pdprogramer.biblioteca.RecyclerViewOnItemPressListener;
import com.pdprogramer.biblioteca.adapter.BookAdapter;
import com.pdprogramer.biblioteca.data.BookDataSource;
import com.pdprogramer.biblioteca.main.DetalleBookActivity;
import com.pdprogramer.biblioteca.model.Book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaRecyclerView;
    private BookDataSource bookDataSource;
    private BookAdapter bookAdapter;
    private LinearLayoutManager managerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bookDataSource = new BookDataSource(this);
        bookAdapter = new BookAdapter(bookDataSource.getAllBook(), new BookAdapter.OnItemSelectedListener() {
            @Override
            public void onSelected(Book book) {

            }

            @Override
            public void onMenuAction(Book book, MenuItem item) {


            }
        },true);
        listaRecyclerView = (RecyclerView) findViewById(R.id.list_rec);
        listaRecyclerView.setHasFixedSize(true);
        managerLayout = new LinearLayoutManager(this);
        listaRecyclerView.setLayoutManager(managerLayout);
        listaRecyclerView.setAdapter(bookAdapter);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lansarAcDetalle();
            }
        });


    }

    public void lansarAcDetalle() {
        Intent intent = new Intent(this, DetalleBookActivity.class);

        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searcMenuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searcMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                unsearch();
                return false;
            }
        });

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.search:

                return true;
            case R.id.delete:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void search(String query) {
//        bookAdapter = new BookAdapter(bookDataSource.getBooksAutor(query));
//        listaRecyclerView.setAdapter(bookAdapter);
    }

    private void unsearch() {
//        bookAdapter = new BookAdapter(bookDataSource.getAllBook());
//        listaRecyclerView.setAdapter(bookAdapter);
    }
}
