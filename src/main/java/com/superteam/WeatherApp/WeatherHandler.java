package com.superteam.WeatherApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class WeatherHandler {

	//temp global lat and long
	private String globalLat;
	private String globalLong;
	private String weatherUrl;
	private JSONObject jsonObject;
	private String todaySymbolNumber;
	private String tomorrowSymbolNumber;

	public WeatherHandler(String globalLat, String globalLong) throws IOException {
		this.globalLat = globalLat;
		this.globalLong = globalLong;
		setWeatherUrl(globalLat,globalLong);
		extractWeatherInformation();
	}


	private void extractWeatherInformation() throws IOException {
		try {
			jsonObject = XML.toJSONObject(getJsonString(weatherUrl));

			JSONObject todayJson = jsonObject.getJSONObject("weatherdata").getJSONObject("product").getJSONArray("time").getJSONObject(16);
			JSONObject tomorrowJson = jsonObject.getJSONObject("weatherdata").getJSONObject("product").getJSONArray("time").getJSONObject(136);

			JSONObject tempJsonObject = todayJson.getJSONObject("location").getJSONObject("symbol");
			JSONObject tempJsonObject2 = tomorrowJson.getJSONObject("location").getJSONObject("symbol");
			todaySymbolNumber = tempJsonObject.get("number").toString();
			tomorrowSymbolNumber = tempJsonObject2.get("number").toString();
		}
		catch(JSONException e){
			System.out.println(e.getMessage());
		}
	}

	public String getTodaySymbolNumber() {
		return todaySymbolNumber;
	}

	public String getTomorrowSymbolNumber() {
		return tomorrowSymbolNumber;
	}

	private String getJsonString(String url) throws IOException {
		URLConnection connection = new URL(url).openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		connection.connect();

		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = buffer.readLine()) != null) {
			stringBuilder.append(line);
		}

		return stringBuilder.toString();
	}

	private void setWeatherUrl(String latitude, String longitude) {
		this.weatherUrl = "https://api.met.no/weatherapi/locationforecast/1.9/?lat=" +
				latitude + "&lon=" + longitude;
	}

	/*
	public String getGlobalLat() {
		return globalLat;
	}

	public String getGlobalLong() {
		return globalLong;
	}
	*/
}
