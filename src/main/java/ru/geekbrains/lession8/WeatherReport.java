package ru.geekbrains.lession8;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.lession8.parseClasses.DailyForecast;
import ru.geekbrains.lession8.parseClasses.WeatherResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static ru.geekbrains.lession8.Lession8.city;

public class WeatherReport {
    //  variables + constants
    private String lat;
    private String lng;
    private WeatherResponse weatherResponse;

    final String SCHEME = "https";
    final String HOST = "api.weather.yandex.ru";
    final String APIVERSION = "v2";
    final String SERVICE = "forecast";
    final String LANGUAGE = "ru_RU";
    final String LIMIT = "5";
    final String YANDEXKEY = "X-Yandex-API-Key";
    final String YANDEXKEYVALUE = "2a155908-6074-4b5e-83d7-f2db755b6f43";

    //  constructors + getters
    public WeatherReport(){
    }

    public WeatherReport(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public WeatherResponse getWeatherResponse() {
        return weatherResponse;
    }


    //  methods
    public void getWeatherReport (Connection conn, Repository repo) throws IOException, SQLException {  //in: coordinates, out: json from YandexAPI

        HttpUrl url = new HttpUrl.Builder()             //make URL with params
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment(APIVERSION)
                .addPathSegment(SERVICE)
                .addQueryParameter("lat", lat)
                .addQueryParameter("lon", lng)
                .addQueryParameter("lang", LANGUAGE)
                .addQueryParameter("limit", LIMIT)
                .build();


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(YANDEXKEY, YANDEXKEYVALUE)                                                  //sent header with credentials
                .build();

        Response response = client.newCall(request).execute();                                         //get JSON response

        //todo: move this to new class/method
        ObjectMapper objectMapper = new ObjectMapper();

        weatherResponse = objectMapper.readValue(response.body().byteStream(), WeatherResponse.class);  //put json response to class

        for (DailyForecast forecast : weatherResponse.getDailyForecast()){
            System.out.printf("Температура в Москве на %s: %s\n",                                       //print weather forecasts from class
                    forecast.getDate(),
                    forecast.getParts().getDay().getTemp_avg());

            String sqlAddLineCommand = String.format(repo.sqlUpdateCommand, lat, lng, city,             // create string - SQL command for Table Update
                    forecast.getDate(), forecast.getParts().getDay().getTemp_avg());
            repo.writeToDatabase(conn, sqlAddLineCommand);                                              // update db table with new data from JSON

        }
    }
}
