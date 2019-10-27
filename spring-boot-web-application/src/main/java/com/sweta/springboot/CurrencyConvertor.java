package com.sweta.springboot;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class CurrencyConvertor {
    static StringBuffer sb = new StringBuffer();
    // Method to get the response from API
    public  String  getResponse(String base){
    	try {
    	String strURL = "https://api.exchangeratesapi.io/latest?base="+base;
    	URL url = new URL(strURL);
    	HttpURLConnection hr = (HttpURLConnection)url.openConnection();
    	if(hr.getResponseCode() == 200) {
			InputStream ir = hr.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(ir));
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
		}
	} catch(Exception e) {
    	System.out.println(e);
    }
		return sb.toString();
    }
    
    public  void  convertMapToCSV(String jsonObject, String filename) throws IOException {
        // Create a File and append if it already exists.
    	JSONObject json = new JSONObject(jsonObject);
    	JSONObject jarray = json.getJSONObject("rates");
    	String base = json.getString("base");
    	String path = "FileGenerated/" + filename;
    	HashMap<String, Object> yourHashMap = new Gson().fromJson(jarray.toString(),HashMap.class);
    	FileWriter writer;
		writer = new FileWriter(path , false);  //True = Append to file, false = 
        //Copy List of Map Object into CSV format at specified File location.
		yourHashMap.forEach((k,v)->{
			try {
				writer.write(base + k + "  : " + v  +"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
			writer.flush();
			System.out.println("Write success!");
			writer.close();
    }
}
