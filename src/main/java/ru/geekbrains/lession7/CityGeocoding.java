package ru.geekbrains.lession7;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class CityGeocoding {

    @Getter private String city;

    final String HOST = "graphhopper.com";
    final String SCHEMA = "https";
    final String API = "api";
    final String APIVERSION = "1";
    final String SERVICE = "geocode";
    final String APIKEY = "cdeac1fb-60f1-4bad-a278-5e99d731e9b9";


    public CityGeocoding(String city) throws IOException {
        this.city = city;
    }

    public String cityCoordinates() throws IOException {
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
//        return body;

//        ObjectMapper objectMapper = new ObjectMapper();
//        Coordinates coordinates = objectMapper.readValue(body, Coordinates.class);
//        System.out.println("coords:" + coordinates);
        return body;
    }
}
