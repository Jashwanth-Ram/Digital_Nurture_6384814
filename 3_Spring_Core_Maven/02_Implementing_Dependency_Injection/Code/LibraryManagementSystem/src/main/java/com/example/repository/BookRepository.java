package com.example.repository;

public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository has been Created");
    }

    @Override
    public String toString(){
        return "BookRepository has Injected";
    }
}