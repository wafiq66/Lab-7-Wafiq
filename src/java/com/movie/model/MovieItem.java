package com.movie.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */

import java.io.Serializable;

public class MovieItem implements Serializable {
    
    private String title;
    private String year;
    private String genre;
    
    //default constructor
    public MovieItem(){
        this.title = "";
        this.year = "";
        this.genre = "";
    }
    //normal constructor
    public MovieItem(String title, String year, String genre){
        this.title = title;
        this.year = year;
        this.genre = genre;
    }
    
    public String getTitle(){
        return this.title;
    }
    public String getYear(){
        return this.year;
    }
    public String getGenre(){
        return this.genre;
    }
}
