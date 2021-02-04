package com.papernest.web.api.papernestAPI.apiHandler;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.papernest.web.api.papernestAPI.dto.Coordinate;
import com.papernest.web.api.papernestAPI.service.GeocoderService;

@Service
public class GeocodingHandler implements IGeocoding{
	
	
	private static Logger logger = Logger.getLogger(GeocodingHandler.class);
	
	@Autowired
    GeocoderService geocoder = new GeocoderService();
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
    public Coordinate getPosition(String adrs){
		
		Coordinate coordinate = new Coordinate();
		
		try {
			
			String response = geocoder.Geocode(adrs);
			JsonNode responseJsonNode = mapper.readTree(response);
			JsonNode features = responseJsonNode.get("features");
			
			for (JsonNode feature : features) {
	            JsonNode address = feature.get("properties");
	            
	            String lat = address.get("x").asText();
	            String lng = address.get("y").asText();
	            if(lat != null && lng != null) {
	            	coordinate.setX(lat);
	            	coordinate.setY(lng);
	            	break;
	            }
	            
	        }
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return coordinate;
    }

}
