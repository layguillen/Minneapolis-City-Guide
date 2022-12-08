package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Coordinates;
import com.techelevator.model.Landmark;
import com.techelevator.model.Route;
import com.techelevator.routeModels.Root;
import com.techelevator.routeModels.RouteAPI;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouteService implements iRouteService{

    //TODO: figure out base API URL
    private static final String API_URL = "https://api.openrouteservice.org/v2/directions/driving-car/{profile}/post";

    //this is Layla's API key that we can use for every request
    private static final String API_KEY = "5b3ce3597851110001cf624825acbbd93a1c4750ac7148d566eec1ad";

    private RestTemplate restTemplate = new RestTemplate();



    public ArrayList<RouteAPI> createRoute(String token, List<Landmark> landmarks){
        HttpEntity<Coordinates> entity = makeRouteEntity(landmarks, token);

        Root root = null;
        ArrayList<RouteAPI> routeAPI = null;
        try{

            root = restTemplate.exchange(API_URL, HttpMethod.POST, entity, Root.class).getBody();
            //TODO: decide what's needed here route or root
//            ObjectMapper om = new ObjectMapper();
//            root = om.readValue(API_URL, Root.class);
            routeAPI = root.getRoutes();

        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return routeAPI;
    }

    //Post and Put
    //TODO: pass in a list of landmarks, loop through it to then make an array of coordinates which then gets passed into the entity as the body
    private HttpEntity<Coordinates> makeRouteEntity(List<Landmark> landmarks, String token) {
        Coordinates coordinates = new Coordinates();
        int[][] array = new int[landmarks.size()][];
        coordinates.setCoordinatesArray(array);

        for (int i = 0; i < landmarks.size(); i++) {
            int[] intArray = new int[2];
            String[] a = landmarks.get(i).getAddress().getLongLat().split(",");
            intArray[0] = Integer.parseInt(a[0]);
            intArray[1] = Integer.parseInt(a[1]);

            array[i] = intArray;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        //pass API_KEY as authorization
        headers.add("Authorization", API_KEY);
        //TODO: pass in string array to HttpEntity in method signature
        return new HttpEntity<Coordinates>(coordinates, headers);
    }



}
