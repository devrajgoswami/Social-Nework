/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.vo;

/**
 *
 * @author Devraj
 */
public class PersonalDetailsVO {
    
    String aboutMe,favMovie,favMusic,favBook,favQuote,favCuisine;

    public PersonalDetailsVO(String aboutMe, String favMovie, String favMusic, String favBook, String favQuote, String favCuisine) {
        this.aboutMe = aboutMe;
        this.favMovie = favMovie;
        this.favMusic = favMusic;
        this.favBook = favBook;
        this.favQuote = favQuote;
        this.favCuisine = favCuisine;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getFavBook() {
        return favBook;
    }

    public void setFavBook(String favBook) {
        this.favBook = favBook;
    }

    public String getFavCuisine() {
        return favCuisine;
    }

    public void setFavCuisine(String favCuisine) {
        this.favCuisine = favCuisine;
    }

    public String getFavMovie() {
        return favMovie;
    }

    public void setFavMovie(String favMovie) {
        this.favMovie = favMovie;
    }

    public String getFavMusic() {
        return favMusic;
    }

    public void setFavMusic(String favMusic) {
        this.favMusic = favMusic;
    }

    public String getFavQuote() {
        return favQuote;
    }

    public void setFavQuote(String favQuote) {
        this.favQuote = favQuote;
    }
    
}
