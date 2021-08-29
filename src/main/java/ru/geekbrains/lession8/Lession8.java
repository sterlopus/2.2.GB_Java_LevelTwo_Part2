package ru.geekbrains.lession8;

import java.io.IOException;
import java.sql.*;

public class Lession8 {

    static String city = "Москва";

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Repository repo = new Repository();


        Connection  connection = DriverManager.getConnection(repo.dbAddress);           //open db conection
        Statement statement = connection.createStatement();                             //start statement
        repo.writeToDatabase(connection, repo.getCreateTableCommand());                 //create table if not exist


        CityGeocoding cityGeocoding = new CityGeocoding(city);
        cityGeocoding.cityCoordinates();                                                // get coordinates by city name
        String x = cityGeocoding.getLat().toString();
        String y = cityGeocoding.getLng().toString();


        WeatherReport weatherReport = new WeatherReport(x,y);
        weatherReport.getWeatherReport(connection, repo);                               // get forecast, put to db & print


        repo.databasePrint(statement.executeQuery(repo.all));                           // total db output to console

        connection.close();

    }
}

/**
 * Реализовать корректный вывод информации о текущей погоде.
 *
 * Создать класс WeatherResponse и десериализовать ответ сервера.
 * Выводить пользователю только текстовое описание погоды и температуру в градусах Цельсия.
 *
 * Реализовать корректный выход из программы
 *
 * Реализовать вывод погоды на следующие 5 дней в формате:
 * В городе CITY на дату DATE ожидается WEATHER_TEXT, температура - TEMPERATURE
 *
 */