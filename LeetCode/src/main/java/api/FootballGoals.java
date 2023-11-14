package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class FootballGoals {

    /*   https://github.com/devreena03/hackerrank-restapi-java/blob/main/src/com/reena/match/football-matches.md */

    public static void main(String[] args) throws IOException {

        try {
            String team = "Chelsea";
            int year = 2014;

            System.out.println(getTotalGoals(team, year));
        } catch (Exception e) {

        }

    }

    public static int getTotalGoals(String team, int year) throws IOException {
        int team1Goals = getTeam1TotalPageCount(year, team);

        int team2Goals = getTeam2TotalPageCount(year, team);

        return team1Goals+team2Goals;
    }

    public static int getTeam1TotalPageCount(int year, String team) throws IOException {
        int yearInput = year;
        String teamInput = URLEncoder.encode(team, "UTF-8");;

        String urlString =
                "https://jsonmock.hackerrank.com/api/football_matches?" +
                        "year=inputYear&team1=inputTeam";


        urlString =  urlString.replace("=inputYear", "=" + yearInput).replace("=inputTeam", "=" + teamInput);

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method
        connection.setRequestMethod("GET");


        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
//
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        // Parse JSON using Gson
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);

        int totalPages = jsonResponse.getAsJsonObject().get("total_pages").getAsInt();
        int totalPerPage = jsonResponse.getAsJsonObject().get("per_page").getAsInt();

        return getTeam1Goals(year, team, totalPages, totalPerPage);
    }

    public static int getTeam1Goals(int year, String team, int totalPages, int perPage) throws IOException{
        int team1Goals = 0;

        int yearInput = year;
        String teamInput = URLEncoder.encode(team, "UTF-8");;



        for (int i= 1; i <=totalPages;i++){
            String urlString =
                    "https://jsonmock.hackerrank.com/api/football_matches?" +
                            "year=inputYear&team1=inputTeam&page=inputPages";
            urlString =  urlString.replace("=inputYear", "=" + yearInput)
                    .replace("=inputTeam", "=" + teamInput).replace("=inputPages", "=" + i);

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method
            connection.setRequestMethod("GET");


            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
//
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Parse JSON using Gson
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
            JsonArray data = jsonResponse.getAsJsonArray("data");
            for (JsonElement e : data){
                int goals = e.getAsJsonObject().get("team1goals").getAsInt();
                team1Goals = team1Goals + goals;
            }


        }
        System.out.println(team1Goals);
        return team1Goals;
    }

    public static int getTeam2TotalPageCount(int year, String team) throws IOException {
        int yearInput = year;
        String teamInput = URLEncoder.encode(team, "UTF-8");;

        String urlString =
                "https://jsonmock.hackerrank.com/api/football_matches?" +
                        "year=inputYear&team2=inputTeam";


        urlString =  urlString.replace("=inputYear", "=" + yearInput).replace("=inputTeam", "=" + teamInput);

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method
        connection.setRequestMethod("GET");


        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
//
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        // Parse JSON using Gson
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);


        int totalPages = jsonResponse.getAsJsonObject().get("total_pages").getAsInt();
        int totalPerPage = jsonResponse.getAsJsonObject().get("per_page").getAsInt();


        return getTeam2Goals(year, team, totalPages, totalPerPage);
    }

    public static int getTeam2Goals(int year, String team, int totalPages, int perPage) throws IOException{
        int team2Goals = 0;

        int yearInput = year;
        String teamInput = URLEncoder.encode(team, "UTF-8");;


        for (int i= 1; i <=totalPages;i ++){
            String urlString =
                    "https://jsonmock.hackerrank.com/api/football_matches?" +
                            "year=inputYear&team2=inputTeam&page=inputPages";
            urlString =  urlString.replace("=inputYear", "=" + yearInput)
                    .replace("=inputTeam", "=" + teamInput).replace("=inputPages" , "=" + i);

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method
            connection.setRequestMethod("GET");


            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
//
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Parse JSON using Gson
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
            JsonArray data = jsonResponse.getAsJsonArray("data");
            for (JsonElement e : data){
                int goals = e.getAsJsonObject().get("team2goals").getAsInt();
                team2Goals = team2Goals + goals;
            }

        }
        System.out.println(team2Goals);
        return team2Goals;
    }
}