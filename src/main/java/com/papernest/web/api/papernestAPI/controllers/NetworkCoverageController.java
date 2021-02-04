package com.papernest.web.api.papernestAPI.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.papernest.web.api.papernestAPI.apiHandler.CSVReaderHandler;
import com.papernest.web.api.papernestAPI.apiHandler.GeocodingHandler;
import com.papernest.web.api.papernestAPI.apiHandler.IGeocoding;
import com.papernest.web.api.papernestAPI.dto.Coordinate;
import com.papernest.web.api.papernestAPI.dto.Coverage;
import com.papernest.web.api.papernestAPI.dto.Operator;
import com.papernest.web.api.papernestAPI.dto.Operators;

import org.apache.log4j.Logger;

@RestController
public class NetworkCoverageController {

	public static void main(String[] args) throws IOException, InterruptedException {
		NetworkCoverageController controller = new NetworkCoverageController();
		System.out.println(controller.getOperatorsCoverages("66 rue jean jaures puteaux"));

	}

	private static Logger logger = Logger.getLogger(NetworkCoverageController.class);
	
	//@Autowired
	//IGeocoding geocodingHandler;
	
	GeocodingHandler geocodingHandler = new GeocodingHandler();
	
	@GetMapping("/operators")
	@ResponseBody
	public Operators getOperatorsCoverages(@RequestParam(name = "q",required = true) String address) throws IOException, InterruptedException {
		
		List<Coverage> coverages = CSVReaderHandler.readCoveragesFromCSV();
		Operators operators = new Operators();
		
		Coordinate coordinate = geocodingHandler.getPosition(address);
		int x = (int) Double.parseDouble(coordinate.getX());
		int y = (int) Double.parseDouble(coordinate.getY());
		
		System.out.println("your address cordinate are "+coordinate);
		
		for(Coverage coverage:coverages) {
			switch(coverage.getOperateur()) {
			//Orange  
			case "20801":
				if(Integer.parseInt(coverage.getX()) == x && Integer.parseInt(coverage.getY()) == y) {
					operators.setOrange(new Operator(coverage.isTwoG(), coverage.isTreeG(), coverage.isFourG()));
				}
				break;
			//SFR  
			case "20810":
				if(Integer.parseInt(coverage.getX()) == x && Integer.parseInt(coverage.getY()) == y) {
					operators.setSFR(new Operator(coverage.isTwoG(), coverage.isTreeG(), coverage.isFourG()));
				}
			    break;
			//Free
			case "20815":
				if(Integer.parseInt(coverage.getX()) == x && Integer.parseInt(coverage.getY()) == y) {
					operators.setFree(new Operator(coverage.isTwoG(), coverage.isTreeG(), coverage.isFourG()));
				}
				break;
			//Bouygue  
			case "20820":
				if(Integer.parseInt(coverage.getX()) == x && Integer.parseInt(coverage.getY()) == y) {
					operators.setBouygue(new Operator(coverage.isTwoG(), coverage.isTreeG(), coverage.isFourG()));
				}
				 break;
			}
		}
		
		return operators;
	}

}
