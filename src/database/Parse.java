package database;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Parse {

    private static String classesURL = "https://parse-server-biblioteca.herokuapp.com/parse/classes/";
    private static String parseURL = "https://parse-server-biblioteca.herokuapp.com/parse/";
    private static String appID = "myAppId";
    private static String masterKey = "myMasterKey";

    public static String bookTableRef = "Books";
    public static String employeeTableRef = "Employees";

//    public void getObject() throws IOException {
//        URL urlForGetRequest = new URL("https://hamburguerserver.herokuapp.com/parse/classes/Estoque");
//        String readLine = "";
//        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
//        conection.setRequestMethod("POST");
//        conection.setRequestProperty("X-Parse-Application-Id", "myAppId");
//        conection.setRequestProperty("X-Parse-Master-Key", "myMasterKey");
//        int responseCode = conection.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(conection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            while ((readLine = in .readLine()) != null) {
//                response.append(readLine);
//            } in .close();
//            // print result
//            System.out.println("JSON String Result " + response.toString());
//            //GetAndPost.POSTRequest(response.toString());
//        } else {
//            System.out.println("GET NOT WORKED");
//        }
//    }

    public static JSONObject getObject(String table) throws IOException{
        JSONParser jsonParser = new JSONParser();

        URL urlForGetRequest = new URL(classesURL + table);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("X-Parse-Application-Id", appID);
        conection.setRequestProperty("X-Parse-Master-Key", masterKey);
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            } in .close();

            try{
                Object obj = jsonParser.parse(response.toString());
                JSONObject jsonArray = (JSONObject) obj;
                return jsonArray;
            } catch (ParseException e){
                e.printStackTrace();
            }
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
        return new JSONObject();
    }

    public static void editObject(String table, String params, String objectId) throws IOException {
        URL obj = new URL(classesURL + table + "/" + objectId);
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("PUT");
        postConnection.setRequestProperty("X-Parse-Application-Id", appID);
        postConnection.setRequestProperty("X-Parse-Master-Key", masterKey);
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);

        OutputStream os = postConnection.getOutputStream();
        os.write(params.getBytes());
        os.flush();
        os.close();

        int responseCode = postConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();
            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("PUT NOT WORKED");
        }
    }

    public static void postObject(String table, String params) throws IOException {
        URL obj = new URL(classesURL + table);
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("X-Parse-Application-Id", appID);
        postConnection.setRequestProperty("X-Parse-Master-Key", masterKey);
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(params.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);
        System.out.println("POST Response Message : " + postConnection.getResponseMessage());
        if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();
            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST NOT WORKED");
        }
    }

    public static void deleteObject(String table, String params) throws IOException {

    }
}
