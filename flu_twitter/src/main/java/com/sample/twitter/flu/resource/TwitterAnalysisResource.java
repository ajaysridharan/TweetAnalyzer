package com.sample.twitter.flu.resource;

import com.sample.twitter.flu.dao.SolrDao;
import com.yammer.metrics.annotation.Metered;
import org.apache.solr.client.solrj.SolrServerException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.HttpURLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: sudo
 * Date: 1/13/13
 * Time: 6:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/analyze/tweets")
public class TwitterAnalysisResource {
    private SolrDao solrDao;

    public TwitterAnalysisResource(SolrDao solrDao) {
        this.solrDao = solrDao;
    }

    @GET
    @Metered
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTweets(@QueryParam("radius") Double radius, @QueryParam("location") String location, @QueryParam("query") String query) throws SolrServerException {
        Response result = null;

        return Response.status(HttpURLConnection.HTTP_OK).entity(solrDao.getTweetFromServer(query, location, radius)).build();

    }
}
