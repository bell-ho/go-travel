package org.zerock.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class APIController {
	
	@PostMapping(value = "/{contentid}" , produces ="application/xml;charset=utf-8" )
	 public static String detail(@PathVariable("contentid")int contentid) throws IOException {
		System.out.println("������");
		System.out.println("����ο;ߵ�"+contentid);
	        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ilqxDvc7FBGBNe7wXY4c5AipSyWcUaApekp9a0NKlurwayKHfKGYyKXUKAUcMW/5YF5i97dd355widhAAllD8Q=="); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*�� ������ ��� ��*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*���� ������ ��ȣ*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(������),AND(�ȵ���̵�),WIN(��������),ETC*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*���񽺸�=���ø�*/
	        urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(""+contentid, "UTF-8")); /*������ID*/
	        urlBuilder.append("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*�⺻���� ��ȸ����*/
	        urlBuilder.append("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*����, ����� ��ǥ�̹��� ��ȸ����*/
	        urlBuilder.append("&" + URLEncoder.encode("areacodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*�����ڵ�, �ñ����ڵ� ��ȸ����*/
	        urlBuilder.append("&" + URLEncoder.encode("catcodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*��,��,�Һз��ڵ� ��ȸ����*/
	        urlBuilder.append("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*�ּ�, ���ּ� ��ȸ����*/
	        urlBuilder.append("&" + URLEncoder.encode("mapinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*��ǥ X,Y ��ȸ����*/
	        urlBuilder.append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*������ ���� ��ȸ����*/
	        URL url = new URL(urlBuilder.toString());
	        System.out.println(url);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
			return sb.toString();
	    }

}
