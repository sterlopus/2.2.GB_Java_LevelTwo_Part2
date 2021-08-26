package ru.geekbrains.lession7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Lession7 {
    public static void main(String[] args) throws IOException {

        String  city = "Москва";

        CityGeocoding cityGeocoding = new CityGeocoding(city);
        cityGeocoding.cityCoordinates();

        String x = cityGeocoding.getLat().toString();
        String y = cityGeocoding.getLng().toString();

        System.out.println("[DEBUG coordinates]  x: " + x +"y: " +y); //todo: Delete before production


        WeatherReport weatherReport = new WeatherReport(x,y);
        System.out.println("[Debug main]  5 days forecast is: " + weatherReport.getWeatherReport());



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