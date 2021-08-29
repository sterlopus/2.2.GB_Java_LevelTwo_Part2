package ru.geekbrains.lession8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class CityGeocoding {

    private String city;

    @Getter JsonNode lat;
    @Getter JsonNode lng;

    final String HOST = "graphhopper.com";
    final String SCHEMA = "https";
    final String API = "api";
    final String APIVERSION = "1";
    final String SERVICE = "geocode";
    final String APIKEY = "cdeac1fb-60f1-4bad-a278-5e99d731e9b9";


    public CityGeocoding(String city) throws IOException {  //constructor
        this.city = city;
    }

    public void cityCoordinates() throws IOException {    //method for get json by url
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme(SCHEMA)
                .host(HOST)
                .addPathSegment(API)
                .addPathSegment(APIVERSION)
                .addPathSegment(SERVICE)
                .addQueryParameter("q", city)
                .addQueryParameter("key", APIKEY)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();

        lat = objectMapper.readTree(body).at("/hits/0/point/lat");
        lng = objectMapper.readTree(body).at("/hits/0/point/lng");
    }
}
