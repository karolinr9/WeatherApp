package com.superteam.WeatherApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class WeatherController {


    public static final String GOOGLE_API_KEY = "AIzaSyD4Ydc-Uq0N1Tnl9bQZFI0mhK3vcko_5Yk";

    @GetMapping
    public String getWeather() throws IOException {
        WeatherHandler osloWeather = new WeatherHandler("59.93","10.75");
        WeatherHandler bergenWeather = new WeatherHandler("60.38","5.32");
        WeatherHandler trondheimWeather = new WeatherHandler("63.41","10.36");
        WeatherHandler kristiansandWeather = new WeatherHandler("58.15","7.93");
        WeatherHandler stavangerWeather = new WeatherHandler("58.94","5.61");

        String[] todaysIcons = {osloWeather.getTodaySymbolNumber(),
                bergenWeather.getTodaySymbolNumber(),
                trondheimWeather.getTodaySymbolNumber(),
                kristiansandWeather.getTodaySymbolNumber(),
                stavangerWeather.getTodaySymbolNumber()};

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>" +
                "<title>Weather App</title>" +
                "<style>#map {height: 800px;  width: 100%;  }</style>" +
                "</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div id=\"map\"></div>" +
                "<script>" +

                //Passing the weather values to a global variable
                "var weatherFromApi = getWeatherInfoFromApi();" +

                "function initMap() {" +
                    //Setting up the icon url's
                    "var weatherIcons = [" +
                    "'https://api.met.no/weatherapi/weathericon/1.1/?symbol=" + todaysIcons[0] + "&content_type=image/png'," +
                    "'https://api.met.no/weatherapi/weathericon/1.1/?symbol=" + todaysIcons[1] + "&content_type=image/png'," +
                    "'https://api.met.no/weatherapi/weathericon/1.1/?symbol=" + todaysIcons[2] + "&content_type=image/png'," +
                    "'https://api.met.no/weatherapi/weathericon/1.1/?symbol=" + todaysIcons[3] + "&content_type=image/png'," +
                    "'https://api.met.no/weatherapi/weathericon/1.1/?symbol=" + todaysIcons[4] + "&content_type=image/png'" +
                    "];" +

                    //Creating the positions to place the weather symbols
                    "var cities = [new google.maps.LatLng(59.93, 10.75)," +
                                    "new google.maps.LatLng(60.38, 5.32)," +
                                    "new google.maps.LatLng(63.41, 10.36)," +
                                    "new google.maps.LatLng(58.94, 5.61)," +
                                    "new google.maps.LatLng(58.15, 7.93)];" +

                    //Setting up the maps startup default values
                    "var map = new google.maps.Map(document.getElementById('map'), {zoom: 5, center: cities[0]});" +

                    //Setting up the marker positions with the right kind of weather icon
                    "for(i = 0; i < cities.length; i++) {" +
                        "var marker = new google.maps.Marker({" +
                            "position: cities[i]," +
                            "icon: weatherIcons[i]," +
                            "map: map" +
                        "});" +
                    "}" +
                "}" +
                "</script>" +

                "<script async defer src=\"https://maps.googleapis.com/maps/api/js?key=" + GOOGLE_API_KEY + "&callback=initMap\"></script>");

        stringBuilder.append("<h1>Winter is coming soon</h1>");

        stringBuilder.append("</body></html>");

        return stringBuilder.toString();
    }
}
