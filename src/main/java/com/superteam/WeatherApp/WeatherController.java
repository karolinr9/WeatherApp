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
        //Oslo 59.9303104,10.7555997
        //bergen 60.3879362,5.3220906
        stringBuilder.append("<html>");
        stringBuilder.append("<head>" +
                "<title>Weather App</title>" +
                "<style>#map {height: 800px;  width: 100%;  }</style>" +
                "</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div id=\"map\"></div>" +
                "<script>" +
                "function getWeatherInfoFromApi() {" +
                    /*
                    //Have to write some request logic to the weather API here
                    */

                    //Returning the neccesary weather info
                    //This is just a hardcoded version of the values we have to get from the weather API
                    "var weatherInfo = [\"sun\", \"rain\", \"sun\", \"cloud\", \"rain\"];" +
                    "return weatherInfo;" +
                "}" +

                //Passing the weather values to a global variable
                "var weatherFromApi = getWeatherInfoFromApi();" +

                "function initMap() {" +
                    //Creating a JS object that contains the various weather icon links
                    "var iconUrl = \"https://api.met.no/weatherapi/weathericon/1.1/?symbol=\";" +
                    "var icons = {" +
                    "sun: {icon: iconUrl + \"1&content_type=image/png\"}," +
                    "cloud: {icon: iconUrl + \"4&content_type=image/png\"}," +
                    "rain: {icon: iconUrl + \"10&content_type=image/png\"} };" +

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
                        "var weatherIcon = null;" +
                        "if(weatherFromApi[i] === \"sun\") {" +
                            "weatherIcon = weatherFromApi[i];" +
                        "} else if(weatherFromApi[i] === \"cloud\") {" +
                            "weatherIcon = weatherFromApi[i];" +
                        "} else {" +
                            "weatherIcon = weatherFromApi[i];" +
                        "}" +

                        "var marker = new google.maps.Marker({" +
                            "position: cities[i]," +
                            "icon: icons[weatherIcon][\"icon\"]," +
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
