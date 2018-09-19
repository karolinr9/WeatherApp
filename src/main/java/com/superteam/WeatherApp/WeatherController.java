package com.superteam.WeatherApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    public static final String GOOGLE_API_KEY = "AIzaSyD4Ydc-Uq0N1Tnl9bQZFI0mhK3vcko_5Yk";

    @GetMapping
    public String getWeather(){

        StringBuilder stringBuilder = new StringBuilder();
        // Oslo 59.9303104,10.7555997
        //bergen 60.3879362,5.3220906
        stringBuilder.append("<html>");
        stringBuilder.append("<head>" +
                "<title>Weather App</title>" +
                "<style>#map {height: 800px;  width: 100%;  }</style>" +
                "</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div id=\"map\"></div>" +
                "<script>function initMap() {" +
                "var oslo = {lat: 59.93, lng: 10.75};" +
                "var bergen = {lat: 60.38, lng: 5.32};"+
                "var map = new google.maps.Map(document.getElementById('map'), {zoom: 4, center: oslo});" +
                "var markerOslo = new google.maps.Marker({position: oslo, icon: \"https://api.met.no/weatherapi/weathericon/1.1/?symbol=1&content_type=image/png\", map: map});" +
                "var markerBergen = new google.maps.Marker({position: bergen, map: map});" +
                "}</script>" +
                "<script async defer src=\"https://maps.googleapis.com/maps/api/js?key=" + GOOGLE_API_KEY + "&callback=initMap\"></script>");

        stringBuilder.append("<h1>Winter is coming soon</h1>");

        stringBuilder.append("</body></html>");

        return stringBuilder.toString();
    }
}
