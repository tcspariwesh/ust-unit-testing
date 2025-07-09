package com.ust;

import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class RestClient {

  public static void main(String[] args) throws Exception {
    URL url = new URL("http://localhost:3000/account");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    int httpStatusCode = connection.getResponseCode();//call api  
    System.out.println(httpStatusCode);
    StringBuilder response = new StringBuilder("");
    if (httpStatusCode == 200) { //collect entire response data in a string object
      Scanner scanner = new Scanner(url.openStream());
      while (scanner.hasNext()) {
        String line = scanner.nextLine();
        response.append(line);
    }
    scanner.close();
    JsonReader reader = Json.createReader(new StringReader(response.toString()));
    JsonArray array = reader.readArray();
    for (int idx = 0; idx < array.size(); idx++) {
        JsonObject account = (JsonObject) array.get(idx);
        System.out.println(account);
        System.out.println(account.getString("name"));
        System.out.println(account.getInt("qty"));

    }
    // System.out.println(array.get(0).get("qty"));
    }
    // JSONObject data= parser.parse(response);
  }
}
