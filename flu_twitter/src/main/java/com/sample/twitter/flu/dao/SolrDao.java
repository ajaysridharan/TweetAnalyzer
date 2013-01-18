package com.sample.twitter.flu.dao;

import com.sample.twitter.flu.bean.Tweet;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sudo
 * Date: 1/13/13
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class SolrDao {
    private HttpSolrServer server;
    private final String LOC_FIELD = "tweet_location";

    public SolrDao(HttpSolrServer server) {
        this.server = server;
    }

    public List<Tweet> getTweetFromServer(String queryString, String location, Double radiusInKm) throws SolrServerException {
        SolrQuery query = new SolrQuery();
        query.setQuery( queryString );
        query.setFilterQueries("{!geofilt pt=" + location + " sfield=" + LOC_FIELD + " d=" + radiusInKm + "}");
        QueryResponse rsp = server.query( query );
        SolrDocumentList docs = rsp.getResults();
        List<Tweet> beans = rsp.getBeans(Tweet.class);
        return beans;
    }
}
