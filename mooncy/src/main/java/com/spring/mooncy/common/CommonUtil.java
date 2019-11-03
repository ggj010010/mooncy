package com.spring.mooncy.common;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class CommonUtil {
	

	/**
	 * Gets the json call back string.
	 *
	 * @param callback the callback
	 * @param obj the obj
	 * @return the json call back string
	 * @throws IOException 
	 */
	public String readJSONStringFromRequestBody(HttpServletRequest request){
	    StringBuffer json = new StringBuffer();
	    String line = null;
	 
	    try {
	        BufferedReader reader = request.getReader();
	        while((line = reader.readLine()) != null) {
	            json.append(line);
	        }
	 
	    }catch(Exception e) {
	        System.out.println("Error reading JSON string: " + e.toString());
	    }
	    return json.toString();
	}


	public String getJsonCallBackString(String callback, Object obj) throws IOException {
		StringBuffer sb = new StringBuffer();
//		sb.append(callback).append("(");

		sb.append(toJson(obj));

//		sb.append(")");
		return sb.toString();
	}
	
	/**
	 * To json.
	 *
	 * @param obj the obj
	 * @return the string
	 * @throws IOException 
	 */
	public static String toJson(Object obj) throws IOException {
		String rtnStr = "";
		//create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //configure Object mapper for pretty print
//        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
        	rtnStr = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			
		}
        return rtnStr;
	}
}
