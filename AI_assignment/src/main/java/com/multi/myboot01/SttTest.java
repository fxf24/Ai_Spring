package com.multi.myboot01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class SttTest {
	static String result = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer response = new StringBuffer();
		String clientId = "5e4u5ybjxl";             // Application Client ID";
        String clientSecret = "eAMFbHX7cgk0P2fOO9tYtEjic1IeeJcPeCfstqGK";     // Application Client Secret";

        
        try {
            String imgFile = "C:/python_source/images/sample.wav";
            
            File voiceFile = new File(imgFile);     
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=Kor";
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(voiceFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;

            if(br != null) {
               
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		
		JSONObject json = new JSONObject(response.toString());
		String text = (String)json.get("text");
		System.out.println("STT:" + text);
		result = text;
	}

}
