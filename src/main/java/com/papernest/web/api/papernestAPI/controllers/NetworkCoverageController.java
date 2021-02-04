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

	private static Logger logger = Logger.getLogger(NetworkCoverageController.class);
	
	private static final String ORNAGE = "20801";
	private static final String SFR = "20810";
	private static final String FREE = "20815";
	private static final String BOUYGUE = "20820";
	
	//@Autowired
	//IGeocoding geocodingHandler;
	
	GeocodingHandler geocodingHandler = new GeocodingHandler();
	
	@GetMapping("/operators")
	@ResponseBody
	public Operators getOperatorsCoverages(@RequestParam(name = "q",required = true) String address) throws IOException, InterruptedException {
		
		List<Coverage> coverages = CSVReaderHandler.readCoveragesFromCSV();
		Operators operators = new Operators();
		
		List<Coordinate> coordinates = geocodingHandler.getPosition(address);
		
	for(Coordinate coordinate:coordinates) {
		for(Coverage coverage:coverages) {
			switch(coverage.getOperateur()) { 
			case ORNAGE:
				if(Integer.parseInt(coverage.getX()) == coordinate.getX() && Integer.parseInt(coverage.getY()) == coordinate.getY() && operators.getOrange() == null) {
					operators.setOrange(new Operator(coverage.isTwoG(), coverage.isTreeG(), coverage.isFourG()));
					break;
				}
			case SFR:
				if(Integer.parseInt(coverage.getX()) == coordinate.getX() && Integer.parseInt(coverage.getY()) == coordinate.getY() && operators.getSFR() == null) {
					operators.setSFR(new Operator(coverage.isTwoG(), coverage.isTreeG(), coverage.isFourG()));
					break;
				}
			case FREE:
				if(Integer.parseInt(coverage.getX()) == coordinate.getX() && Integer.parseInt(coverage.getY()) == coordinate.getY() && operators.getFree() == null) {
					operators.setFree(new Operator(coverage.isTwoG(), coverage.isTreeG(), coverage.isFourG()));
					break;
				}
			case BOUYGUE:
				if(Integer.parseInt(coverage.getX()) == coordinate.getX() && Integer.parseInt(coverage.getY()) == coordinate.getY() && operators.getBouygue() == null) {
					operators.setBouygue(new Operator(coverage.isTwoG(), coverage.isTreeG(), coverage.isFourG()));
					break;
				}
			}
		}
	}
		
		
		return operators;
	}

}
