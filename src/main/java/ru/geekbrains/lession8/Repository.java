package ru.geekbrains.lession8;

import java.sql.*;

public class Repository {

    //  constants
    final String  createTableCommand = "CREATE TABLE IF NOT EXISTS WeatherForecasts " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "Latitude TEXT NOT NULL, " +
            "Longitude TEXT NOT NULL, " +
            "City TEXT NOT NULL, " +
            "Date TEXT NOT NULL, " +
            "Temperature INTEGER NOT NULL)";

    final String sqlUpdateCommand = "INSERT INTO WeatherForecasts (Latitude, Longitude, City, Date, Temperature) VALUES ('%s', '%s', '%s', '%s', %s);";
    final String dbAddress = "jdbc:sqlite:src/main/java/ru/geekbrains/lession8/projectdatabase.db";
    final String all = "SELECT * FROM WeatherForecasts";

    //  constructors + getters

    public String getCreateTableCommand() {
        return createTableCommand;
    }

    public String getDbAddress() {
        return dbAddress;
    }

    public String getSqlUpdateCommand() {
        return sqlUpdateCommand;
    }


    //  methods
    public void writeToDatabase (Connection connection, String sqlUpdateCmnd) throws SQLException {
        Statement stmnt = connection.createStatement();
        stmnt.executeUpdate(sqlUpdateCmnd);
    }

    public void databasePrint (ResultSet rs) throws SQLException {
        System.out.println("\nFull database looks like:");
        while (rs.next()) {                                                         //  вывод содержимого БД в консоль
            for (int i = 1; i < 7; i++) {
                System.out.printf (" " + rs.getString(i));
            }
            System.out.printf(System.lineSeparator());
        }
    }

}
