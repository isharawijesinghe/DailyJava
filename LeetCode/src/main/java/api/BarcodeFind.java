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

public class BarcodeFind {


    public static int getDiscountPrice(String barcode) throws IOException {

        String urlString =
                "https://jsonmock.hackerrank.com/api/inventory?barcode=inputBarcode";


        urlString =  urlString.replace("=inputBarcode", "=" + barcode);

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");


        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);

        JsonArray dataArray = jsonResponse.getAsJsonArray("data");
        for (JsonElement e : dataArray){
            String returnedBarcode = e.getAsJsonObject().get("barcode").getAsString();
            if (returnedBarcode.equals(barcode)){
                int discount = e.getAsJsonObject().get("discount").getAsInt();
                int price = e.getAsJsonObject().get("price").getAsInt();
                int discountedPrice = price - ((discount / 100) * price);
                return discountedPrice;
            }

        }
        return -1;
    }

}
