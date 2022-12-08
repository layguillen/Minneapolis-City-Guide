package com.techelevator.routeModels;

import java.util.Date;

public class Engine {
    public String version;
    public Date build_date;
    public Date graph_date;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getBuild_date() {
        return build_date;
    }

    public void setBuild_date(Date build_date) {
        this.build_date = build_date;
    }

    public Date getGraph_date() {
        return graph_date;
    }

    public void setGraph_date(Date graph_date) {
        this.graph_date = graph_date;
    }
}
