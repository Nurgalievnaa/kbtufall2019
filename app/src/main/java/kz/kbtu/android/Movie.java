package kz.kbtu.android;

import java.io.Serializable;
import java.util.Date;

class Movie implements Serializable {
    String name;
    String urlImage;
    Date date;
    String genre;
    String desc;


    Movie(String name, String urlImage, Date date, String genre, String desc) {
        this.name = name;
        this.urlImage = urlImage;
        this.date = date;
        this.genre = genre;
        this.desc = desc;
    }
}
