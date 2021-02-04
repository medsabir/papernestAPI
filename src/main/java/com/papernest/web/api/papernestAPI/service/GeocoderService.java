package com.papernest.web.api.papernestAPI.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.papernest.web.api.papernestAPI.controllers.NetworkCoverageController;

@Service
public class GeocoderService {

	private static Logger logger = Logger.getLogger(GeocoderService.class);
    private static final String GEOCODING_RESOURCE = "https://api-adresse.data.gouv.fr/search/";

    public String Geocode(String query) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        String encodedQuery = query.replace(" ", "+");
        String requestUri = GEOCODING_RESOURCE + "?q=" + encodedQuery;
        HttpRequest geocodingRequest = HttpRequest.newBuilder().GET().uri(URI.create(requestUri))
                .timeout(Duration.ofMillis(2000)).build();

        HttpResponse<String> geocodingResponse = httpClient.send(geocodingRequest,
                HttpResponse.BodyHandlers.ofString());

        return (String) geocodingResponse.body();
    }

}

