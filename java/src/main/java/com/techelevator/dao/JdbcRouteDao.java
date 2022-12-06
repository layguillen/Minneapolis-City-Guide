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

    @Override
    public List<Route> listRoutes(){
        String sql = "";
        return null;
    }

    @Override
    public Route getRoute(){
        String sql = "";
        return null;
    }

    @Override
    public boolean createRoute(Route route){
        String sql = "";
        return false;
    }

    private Route mapRowToRoute(SqlRowSet results){
        Route route = new Route();

        return route;
    }

}
