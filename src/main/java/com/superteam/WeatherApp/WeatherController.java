package com.superteam.WeatherApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WeatherController {

    public static final String GOOGLE_API_KEY = "AIzaSyD4Ydc-Uq0N1Tnl9bQZFI0mhK3vcko_5Yk";

    @GetMapping
    public String getWeather(){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<html>");
        stringBuilder.append("<head><title>Weather App</title><style>#map {height: 400px;  width: 100%;  }</style></head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div id=\"map\"></div><script>function initMap() {var uluru = {lat: -25.344, lng: 131.036};var map = new google.maps.Map(document.getElementById('map'), {zoom: 4, center: uluru});var marker = new google.maps.Marker({position: uluru, map: map});}</script><script async defer src=\"https://maps.googleapis.com/maps/api/js?key=" + GOOGLE_API_KEY + "&callback=initMap\"></script>");

        stringBuilder.append("<h1>Winter is coming</h1>");

        stringBuilder.append("</body></html>");

        return stringBuilder.toString();
    }
}
