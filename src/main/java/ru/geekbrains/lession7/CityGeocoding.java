package ru.geekbrains.lession7;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class CityGeocoding {
    private String city;
    final String HOST = "graphhopper.com";
    final String SCHEMA = "https";
    final String API = "api";
    final String APIVERSION = "1";
    final String SERVICE = "geocode";

    public CityGeocoding(String city) {
        this.city = city;
    }

    OkHttpClient client = new OkHttpClient();

    HttpUrl httpUrl = new HttpUrl.Builder()
            .host(HOST)
            .
    Request request = new Request.Builder()
            .url("https://graphhopper.com/api/1/geocode?q=berlin&locale=de&debug=true&key=api_key")
            .get()
            .build();

    Response response = client.newCall(request).execute();

}
