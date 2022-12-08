package com.techelevator.dao;

import com.techelevator.model.Route;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcRouteDao implements RouteDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcRouteDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO: method that calls RouteService


    //gets routes from database
    @Override
    public List<Route> listRoutes(){
        String sql = "";
        return null;
    }

    //gets route from database
    @Override
    public Route getRoute(){
        String sql = "";
        return null;
    }




    //Insert new route into database
    @Override
    public boolean createRoute(Route route){
        String sql = "";
        return false;
    }

    //TODO fix sql statement, method for adding landmark to route
    @Override
    public Route addLandmarkToRoute(Route route, int landmarkId){
        if(route == null) throw new IllegalArgumentException("Route cannot be null");

        Route result = route;
        String sql = " UPDATE routes_landmarks " +
                    " SET ";

        int num = jdbcTemplate.update(sql, route.getRouteId(), landmarkId);
        if(num != 1){
            return null;
        }
        return result;
    }

    //TODO fix sql statement, method for removing landmark to route
    @Override
    public Route removeLandmarkToRoute(Route route, int landmarkId){
        if(route == null) throw new IllegalArgumentException("Route cannot be null");

        Route result = route;
        String sql = " UPDATE routes_landmarks " +
                " SET ";

        int num = jdbcTemplate.update(sql, route.getRouteId(), landmarkId);
        if(num != 1){
            return null;
        }
        return result;
    }


    //TODO fix sql statement, method for changing starting location for route
    @Override
    public Route updateStartingLocation(Route route, int startId){
        if(route == null) throw new IllegalArgumentException("Route cannot be null");

        Route result = route;
        String sql = " UPDATE routes " +
                " SET ";

        int num = jdbcTemplate.update(sql, route.getRouteId(), startId);
        if(num != 1){
            return null;
        }
        return result;
    }

    private Route mapRowToRoute(SqlRowSet results){
        Route route = new Route();

        return route;
    }

}
