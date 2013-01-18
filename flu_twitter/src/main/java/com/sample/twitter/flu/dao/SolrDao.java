package com.sample.twitter.flu.dao;

/**
 * Created with IntelliJ IDEA.
 * User: sudo
 * Date: 1/13/13
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class SolrDao {
    private final Double lat;
    private final Double lon;
    private String text;

    public SolrDao(Double lat, Double lon, String text) {
        this.lat = lat;
        this.lon = lon;
        this.text = text;
    }
}
