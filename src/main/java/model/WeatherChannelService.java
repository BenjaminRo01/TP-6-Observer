package model;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
public class WeatherChannelService implements ClimaOnline {
    private String url;
    public WeatherChannelService(String url) {
        this.url = url;
    }
    @Override
    public String temperatura() {
        String strTemperatura = "";
        try{
            HttpURLConnection connection = (HttpURLConnection) new URL(this.url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer informacion = new StringBuffer();
                String inputLine;

                while ((inputLine = br.readLine()) != null) {
                    informacion.append(inputLine);
                }
                br.close();

                JSONObject jsonObject = new JSONObject(informacion.toString());
                double temperatura = jsonObject.getJSONObject("main").getDouble("temp");
                strTemperatura = temperatura + "°C";
            }
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
        return strTemperatura;
    }
}