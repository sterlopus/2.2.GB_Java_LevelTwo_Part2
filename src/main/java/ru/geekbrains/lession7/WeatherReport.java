package ru.geekbrains.lession7;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherReport{
    private String lat;
    private String lng;

    final String SCHEME = "https";
    final String HOST = "api.weather.yandex.ru";
    final String APIVERSION = "v2";
    final String SERVICE = "forecast";
    final String LANGUAGE = "ru_RU";
    final String LIMIT = "5";
    final String YANDEXKEY = "X-Yandex-API-Key";
    final String YANDEXKEYVALUE = "2a155908-6074-4b5e-83d7-f2db755b6f43";

    public WeatherReport(){
    }

    public WeatherReport(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getWeatherReport () throws IOException {  //in: coordinates, out: json from YandexAPI

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

        System.out.println("[Debug WeatherReport] YandexApiUrl: " + url);    //todo: Delete before production

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(YANDEXKEY, YANDEXKEYVALUE)   //sent header with credentials
                .build();

        Response response = client.newCall(request).execute();
        String report = response.body().string();

        return report;
    }
}
