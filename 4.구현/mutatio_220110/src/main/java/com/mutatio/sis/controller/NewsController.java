package com.mutatio.sis.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mutatio.sis.member.service.MemberService;
import com.mutatio.sis.member.vo.MemberVO;
import com.mutatio.sis.security.CustomUser;
import com.mutatio.sis.thesis.service.FactorServiceImpl;
import com.mutatio.sis.thesis.vo.ThesisVO;


@Controller
@RequestMapping("/member")
public class NewsController {
	
	@Inject
	@Qualifier("factorServiceImpl")
	FactorServiceImpl factorService;
	
	@Inject
	@Qualifier("memberService")
	MemberService memberService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/hotNews.do")
	public String factorList(Model model, HttpSession session) {
		List<ThesisVO> factor = factorService.factorList();
		model.addAttribute("factor", factor);
		
		CustomUser USER_INFO = (CustomUser)session.getAttribute("USER_INFO");
		List<Map<String,String>> interestMap = factorService.interestMap();
		
		Map<String, String> transMap= new HashMap<String, String>();
		for(Map<String, String> hash : interestMap) {
			String value = hash.get("CON_CODE");
			String value2 = hash.get("COUNT");
			transMap.put(value, value2);
		}
		model.addAttribute( "transMap", transMap );
		if(USER_INFO != null) {
			String memId = USER_INFO.getUsername();
			List<String> interest = factorService.interestList(memId);
			model.addAttribute( "interest", interest );
		}else {	
			List<String> interestDefault = new ArrayList<String>();
			interestDefault.add("코로나"); 						// 이 하드코딩은 무엇인가??????
			interestDefault.add("오미크론");
			model.addAttribute( "interest", interestDefault);
		}
		logger.info("hotNews 요청  :::{}",transMap);
		return "news/hotNews";
	}
	
	@RequestMapping("/chartData.do")
	@ResponseBody
	public Map<String,String> chart(Model model, HttpSession session) {
		List<Map<String,String>> interestMap = factorService.interestMap();
		Map<String, String> transMap= new HashMap<String, String>();
		for(Map<String, String> hash : interestMap) {
			String value = hash.get("CON_CODE");
			String value2 = hash.get("COUNT");
			transMap.put(value, value2);
		}
		logger.info("chartData 요청 transmap:::",transMap);
		return transMap;
	}
	
	
	
	@RequestMapping(value="/rankedAPI.do" ,produces = "application/xml; charset=UTF-8" )
	@ResponseBody
	public String recommendAPI(HttpServletRequest request) {
		String xmlData = "";
		try {
			StringBuilder urlBuilder = new StringBuilder(
					"https://api.dbpia.co.kr/v2/search/search.xml?target=rated_art&key=ed56b347ad1068d079232d35d7e8eca0"); /* URL */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			logger.info("Response code:::: {}", conn.getResponseCode());

			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
			}
			
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();

			xmlData = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return xmlData;
	}
	
	
	
	
}// class
