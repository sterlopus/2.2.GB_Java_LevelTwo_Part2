/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ru.geekbrains.lession6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Lession6 {
    public static void main(String[] args) throws IOException {

        final String SCHEME = "https";
        final String HOST = "api.weather.yandex.ru";
        final String APIVERSION = "v2";
        final String SERVICE = "forecast";
        final String LAT = "59.936711";
        final String LON = "30.322501";
        final String LANGUAGE = "ru_RU";
        final String LIMIT = "5";
        final String YANDEXKEY = "X-Yandex-API-Key";
        final String YANDEXKEYVALUE = "2a155908-6074-4b5e-83d7-f2db755b6f43";

        HttpUrl url = new HttpUrl.Builder()             //make URL with params
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment(APIVERSION)
                .addPathSegment(SERVICE)
                .addQueryParameter("lat", LAT)
                .addQueryParameter("lon", LON)
                .addQueryParameter("lang", LANGUAGE)
                .addQueryParameter("limit", LIMIT)
                .build();

        System.out.println(url);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .addHeader(YANDEXKEY, YANDEXKEYVALUE)   //sent header with credentials
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(LIMIT + " days forecast is: " + response.body().string());

    }
}


/**
 * * 1.С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
 * * пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
 * **
 * * 2.Подобрать источник самостоятельно.
 * * Можно использовать api accuweather, порядок следующий: зарегистрироваться, зарегистрировать тестовое приложение*
 * * для получения api ключа, найдите нужный endpoint и изучите документацию. Бесплатный тарифный план предполагает*
 * * получение погоды не более чем на 5 дней вперед (этого достаточно для выполнения д/з).
 **/

