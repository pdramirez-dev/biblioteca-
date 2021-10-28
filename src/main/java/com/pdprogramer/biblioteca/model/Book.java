package com.pdprogramer.biblioteca.model;

public class Book {

    private int iso;
    private String title;
    private String autor;
    private String genero;
    private String year_p;


    public Book(){

    }

    public Book(int iso, String title, String autor, String genero, String year_p) {
        this.iso = iso;
        this.title = title;
        this.autor = autor;
        this.genero = genero;
        this.year_p = year_p;
    }

    public Book(int iso, String title) {
        this.iso = iso;
        this.title = title;
    }

    public int getIso() {
        return iso;
    }

    public void setIso(int iso) {
        this.iso = iso;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getYear_p() {
        return year_p;
    }

    public void setYear_p(String year_p) {
        this.year_p = year_p;
    }
}
