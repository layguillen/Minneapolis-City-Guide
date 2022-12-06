package com.techelevator.services;

import com.techelevator.model.Route;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RouteService implements iRouteService{

    //TODO: figure out base API URL
    private static final String API_URL = "https://api.openrouteservice.org/v2/directions/driving-car";

    //this is Layla's API key that we can use for every request
    private static final String API_KEY = "5b3ce3597851110001cf624825acbbd93a1c4750ac7148d566eec1ad";

    private RestTemplate restTemplate = new RestTemplate();

    public Route createRoute(String token, Route route){
        HttpEntity<Route> entity = makeRouteEntity(route, token);

        Route routeToReturn = null;
        try{
            routeToReturn = restTemplate.postForObject(API_URL, entity, Route.class);
        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return routeToReturn;
    }

    //Post and Put
    private HttpEntity<Route> makeRouteEntity(Route route, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        //pass API_KEY as authorization
        headers.add("Authorization", API_KEY);
        return new HttpEntity<>(route, headers);
    }



}
