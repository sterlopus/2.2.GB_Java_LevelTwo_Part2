/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ru.geekbrains.lession7.parseClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.DayOfWeek;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parts {
    private Day day;

    public Parts(){
    }

    public Parts(Day day) {
        this.day = day;
    }

    public Day getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "day=" + day +
                '}';
    }
}
