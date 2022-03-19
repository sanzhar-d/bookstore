package com.company;

import java.sql.Connection;
import java.util.List;

public interface DbConnectorInterface {

    Connection getConnection();

    int saveGenre(Genre genre);

    int updateGenre(Genre genre);

    List<Genre> getAllGenres();

    Genre getGenreById(int id);

    void deleteGenreById(int id);

    int saveDiscount(Discount discount);

    List<Discount> getAllDiscounts();

    Discount getDiscountById(int id);

    void deleteDiscountById(int id);

    int savePosition(Position position);

    List<Position> getAllPositions();

    Position getPositionById(int id);

    void deletePositionById(int id);

    Book saveBook(Book book);


}
