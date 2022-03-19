package com.company;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DbConnector implements DbConnectorInterface {

    public DbConnector() {
    }

    public Connection getConnection(){
        String url = "jdbc:postgresql://localhost:5432/bookstore";
        String username = "postgres";
        String password = "root";

        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public int saveGenre(Genre genre){
        Connection conn = getConnection();

        try {
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate("Insert into \"Genre\" (name) values('" + genre.getName() + "')");

            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<Genre> getAllGenres(){
        Connection conn = getConnection();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from \"Genre\"");

            List<Genre> genres = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Genre genre = new Genre();
                genre.setId(id);
                genre.setName(name);

                genres.add(genre);
            }

            conn.close();

            Genre genre = genres.get(0);

            return genres;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Genre getGenreById(int id){
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from \"Genre\" where id  = " + id);

            List<Genre> genres = new ArrayList<>();
            while (resultSet.next()){
                int idFromBase = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Genre genre = new Genre();
                genre.setId(idFromBase);
                genre.setName(name);

                genres.add(genre);
            }

            conn.close();

            Genre genre = genres.get(0);

            return genre;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteGenreById(int id) {
        Connection conn = getConnection();

        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("delete from \"Genre\" where id = " + id);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int saveDiscount(Discount discount){
        Connection conn = getConnection();

        String pattern = "yyyy-MM-dd";

// Create an instance of SimpleDateFormat used for formatting
// the string representation of date according to the chosen pattern
        DateFormat df = new SimpleDateFormat(pattern);

// Get the today date using Calendar object.
        //Date today = Calendar.getInstance().getTime();
// Using DateFormat format method we can create a string
// representation of a date with the defined format.
        String startDate = df.format(discount.getStart_date());

        String endDate = df.format(discount.getEnd_date());

// Print the result!
//        System.out.println("Today is: " + todayAsString);

        try {
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate("insert into \"Discount\" (percent, start_date, end_date) " +
                    "values (" + discount.getPercent() + " , DATE '" + startDate + "' , DATE '" + endDate + "')");

            conn.close();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Discount> getAllDiscounts() {
        return null;
    }

    @Override
    public Discount getDiscountById(int id) {
        return null;
    }

    @Override
    public void deleteDiscountById(int id) {

    }

    @Override
    public int savePosition(Position position) {
        return 0;
    }

    @Override
    public List<Position> getAllPositions() {
        return null;
    }

    @Override
    public Position getPositionById(int id) {
        return null;
    }

    @Override
    public void deletePositionById(int id) {

    }

    @Override
    public Book saveBook(Book book) {
        return null;
    }


}
