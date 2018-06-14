/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Crazian
 */
public class CheckReq {

    public static void main(String[] args) {

        try {

            String url = "http://data.fixer.io/api/latest?access_key=a844bebe60cb44533d7b4fcc93d04bb5";
            //URL we recieved from data fixer with a unique API
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            int responseCode = con.getResponseCode();

            System.out.println("\n Sending the 'Get request to this URL: " + url);
            System.out.println("\n The Response Code is as follows: " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());

            JSONObject myResponse = new JSONObject(response.toString());
            //Converting the response string to a JSON Object

            System.out.println("base: " +myResponse.getString("base"));
            System.out.println("Success: " +myResponse.getBoolean("success"));
            System.out.println("TimeStamp: " +myResponse.getInt("timestamp"));
            System.out.println("Date: " +myResponse.getString("date"));
            //The Json response or JSON object has multple data types. Using JSON Editor I discovered what datatypes and printed them out using get Method. 
            JSONObject rateObj = new JSONObject(myResponse.getJSONObject("rates").toString());
            // Because rates is an object we created a object and use the getJSONObject method to recieve the rates object and convert it to a string.
            
            System.out.println("US Dollars: "+rateObj.getDouble("USD"));
            // I can now access the rateObj by using the Key. 
            
            //System.out.println("Rates: " +rateObj);
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}



























