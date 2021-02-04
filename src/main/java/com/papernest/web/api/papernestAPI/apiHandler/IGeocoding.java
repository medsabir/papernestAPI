package com.papernest.web.api.papernestAPI.apiHandler;

import java.io.IOException;
import java.util.List;

import com.papernest.web.api.papernestAPI.dto.Coordinate;

public interface IGeocoding {

	public List<Coordinate> getPosition(String adrs) throws IOException, InterruptedException;
	
}
