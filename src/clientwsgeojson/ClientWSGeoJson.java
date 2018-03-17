package clientwsgeojson;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientWSGeoJson {

    public static void main(String[] args) throws IOException, JSONException {
        String rest = getRestResponse();
        JSONObject obj = new JSONObject(rest);
        System.out.println("Obj: " + obj);
        
        JSONObject res = obj.getJSONObject("RestResponse").getJSONObject("result");
        System.out.println("res: " + res);
        
        String r1 = res.toString();
        System.out.println("r1: " + r1);
        
        Gson gson = new Gson();
        
        Country country = (Country) gson.fromJson(r1, Country.class);
        System.out.println(country.getName());
        System.out.println(country.getAlpha2_code());
        System.out.println(country.getAlpha3_code());
    }
    
    private static String getRestResponse() throws MalformedURLException, IOException {
        URL url = new URL(" http://services.groupkt.com/country/get/iso2code/IN ");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStreamReader input = new InputStreamReader(connection.getInputStream());
        try (BufferedReader reader = new BufferedReader(input)) {
            String line, result = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            return result;
        } 
    }
    
}
