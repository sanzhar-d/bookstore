package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DbConnectorInterface dbConnector = new DbConnector();

//        Genre genre = new Genre();
//        genre.setName("adventures");
//        dbConnector.saveGenre(genre);
//
//        List<Genre> genreList = dbConnector.getAllGenres();
//        System.out.println(genreList.size());

//        Discount discount = new Discount();
//        discount.setPercent(15);
//        discount.setStart_date(new Date());
//        discount.setEnd_date(new Date());
//        dbConnector.saveDiscount(discount);

        //вызов метода по получению жанра по id
        Genre genre = dbConnector.getGenreById(7);
        System.out.println(genre.getName());

        //вызов метода по редактированию объекта Genre
        genre.setName("poem");
        dbConnector.updateGenre(genre);

        //вызов метода по удалению жанра по id
        dbConnector.deleteGenreById(6);



        


    }

}
