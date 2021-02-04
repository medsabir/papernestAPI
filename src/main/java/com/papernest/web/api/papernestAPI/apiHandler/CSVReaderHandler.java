package com.papernest.web.api.papernestAPI.apiHandler;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;

import org.apache.log4j.Logger;

import com.papernest.web.api.papernestAPI.dto.Coverage;


public class CSVReaderHandler{
	
	private static final String FILE_NAME = "Sites_mobiles_2G_3G_4G_France_metropolitaine.csv";
	
	public static List<Coverage> readCoveragesFromCSV() { 
		
		List<Coverage> Coverages = new ArrayList<>(); 
		Path pathToFile = Paths.get(FILE_NAME); 
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
		
			String line = br.readLine(); 
			
			while (line != null) { 
				
				String[] attributes = line.split(";"); 
				Coverage coverage = createCoverage(attributes); 
				Coverages.add(coverage); 
				line = br.readLine(); 
				} 
			} catch (IOException ioe) {
				ioe.printStackTrace(); } 
		return Coverages; 
		
	}
	
	private static Coverage createCoverage(String[] metadata) { 
		
		String operateur = metadata[0]; 
		String X = metadata[1]; 
		String Y = metadata[2]; 
		boolean twoG = "1".equals(metadata[3]); 
		boolean treeG = "1".equals(metadata[4]); 
		boolean fourG = "1".equals(metadata[5]); 
		return new Coverage(operateur, X, Y,twoG,treeG,fourG); 
		}}


