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

    //TODO method for adding/removing landmark to route

    //TODO method for changing starting location for route

    private Route mapRowToRoute(SqlRowSet results){
        Route route = new Route();

        return route;
    }

}
