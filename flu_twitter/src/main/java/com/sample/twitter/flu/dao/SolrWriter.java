package com.sample.twitter.flu.dao;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: ajaypromodh
 * Date: 13-01-17
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class SolrWriter {

    public static void main(String a[]) throws IOException, SolrServerException {
        BufferedReader in = new BufferedReader(new FileReader("/Users/ajaypromodh/Downloads/labelled_tweets.txt"));
        SolrServer server = new HttpSolrServer("http://localhost:8983/solr/");
        Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        int i=0;
        while (in.ready()) {
            i++;
            String s = in.readLine();
            String[] splitStuff = s.split(";@;");
            if (splitStuff.length > 4) {
            try {
            SolrInputDocument doc = new SolrInputDocument();
            //Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'").;
            doc.addField("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:sss").parse(splitStuff[0]));
            doc.addField("tweet_location", splitStuff[1]);
            doc.addField("text", splitStuff[2]);
            doc.addField("confidence_score", new Double(splitStuff[4]));
            doc.addField("condition", new Integer(splitStuff[3]));
            docs.add(doc);
            } catch (Exception e) {
                System.out.println("line number is: " + i);
            }
            }
            //doc.addField("");
        }
        in.close();
        server.add(docs);
        server.commit();

    }
}
