package com.pdprogramer.biblioteca.adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.pdprogramer.biblioteca.R;
import com.pdprogramer.biblioteca.RecyclerViewOnItemPressListener;
import com.pdprogramer.biblioteca.model.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    public interface OnItemSelectedListener {
        void onSelected(Book book);

        void onMenuAction(Book book, MenuItem item);
    }

    private OnItemSelectedListener listener;
    public final boolean withContextMenu;
    private List<Book> books;



    public static class BookViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnCreateContextMenuListener, PopupMenu.OnMenuItemClickListener {
        public TextView titulo;
        public TextView autor;
        public TextView genero;
        public TextView year;
        private OnItemSelectedListener listener;
        public final boolean withContextMenu;

        public BookViewHolder(@NonNull View itemView,OnItemSelectedListener listener,boolean withContextMenu) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.book_title);
            autor = (TextView) itemView.findViewById(R.id.autor);
            genero = (TextView) itemView.findViewById(R.id.genero);
            year = (TextView) itemView.findViewById(R.id.year);
            this.listener=listener;
            this.withContextMenu=withContextMenu;
            itemView.setOnLongClickListener(this);
            if (withContextMenu){
                itemView.setOnCreateContextMenuListener(this);
            }

        }

        @Override
        public boolean onLongClick(View v) {
            int position=getAdapterPosition();
            if(listener!=null){

            }
            return true;
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            PopupMenu popupMenu=new PopupMenu(v.getContext(),v);
            popupMenu.getMenuInflater().inflate(R.menu.context_menu,popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return false;
        }
    }




    public BookAdapter(List<Book> list, OnItemSelectedListener listener,boolean withContextMenu) {
        this.books = list;
        this.listener = listener;
        this.withContextMenu=withContextMenu;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view,listener,withContextMenu);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.titulo.setText("Título: " + books.get(position).getTitle());
        holder.autor.setText("Autor: " + books.get(position).getAutor());
        holder.genero.setText("Género: " + books.get(position).getGenero());
        holder.year.setText("Año de Publicación: " + books.get(position).getYear_p());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }


}
