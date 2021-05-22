package naver.chatbot;

//네이버 음성합성 Open API 예제
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.stereotype.Service;

import naver.cloud.NaverService;

@Service("chatbotvoiceservice")
public class NaverVoiceService implements NaverService {

	@Override
	public String test(String image) {
		// TODO Auto-generated method stub
		return test(image, "mijin");
	}
	
	public String test(String responsetext, String speaker) {
		 StringBuffer response = new StringBuffer();
		 String returnfile = "";
	     String clientId = "5e4u5ybjxl";//애플리케이션 클라이언트 아이디값";
	     String clientSecret = "eAMFbHX7cgk0P2fOO9tYtEjic1IeeJcPeCfstqGK";//애플리케이션 클라이언트 시크릿값";
	     
	     try {
	         String text = URLEncoder.encode(responsetext, "UTF-8");

	         //clova voice 선택
	         String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
	         //clova premium voice 선택. 230 오류 발생
	         //String apiURL = "https://naveropenapi.apigw.ntruss.com/voice-premium/v1/tts";
	         //clova speech synthesis(css) 선택. 230 오류 발생
	         //String apiURL = "https://naveropenapi.apigw.ntruss.com/voice/v1/tts";
	         URL url = new URL(apiURL);
	         HttpURLConnection con = (HttpURLConnection)url.openConnection();
	         con.setRequestMethod("POST");
	         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	         con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	         // post request
	         String postParams = "speaker="+speaker+"&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
	         con.setDoOutput(true);
	         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	         wr.writeBytes(postParams);
	         wr.flush();
	         wr.close();
	         int responseCode = con.getResponseCode();
	         BufferedReader br;
	         if(responseCode==200) { // 정상 호출
	             InputStream is = con.getInputStream();
	             int read = 0;
	             byte[] bytes = new byte[1024];
	             // 랜덤한 이름으로 mp3 파일 생성
	             String tempname = Long.valueOf(new Date().getTime()).toString();
	             File f = new File("C:/upload/"+tempname + ".mp3");
	             f.createNewFile();
	             returnfile = tempname + ".mp3";
	             OutputStream outputStream = new FileOutputStream(f);
	             while ((read =is.read(bytes)) != -1) {
	                 outputStream.write(bytes, 0, read);
	             }
	             is.close();
	         } else {  // 오류 발생
	             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	             String inputLine;
	             
	             while ((inputLine = br.readLine()) != null) {
	                 response.append(inputLine);
	             }
	             br.close();
	             System.out.println(response.toString());
	         }
	     } catch (Exception e) {
	         System.out.println(e);
	     }
	     return returnfile;
	 }//test end


}

