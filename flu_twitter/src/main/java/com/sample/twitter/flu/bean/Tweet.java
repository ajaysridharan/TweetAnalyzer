package com.sample.twitter.flu.bean;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sudo
 * Date: 1/13/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tweet {
    @Field("text") private List text;
    @Field("tweet_location") private String location;
    @Field("confidence_score") private Double confidence;
    @Field("condition") private Integer condition;
    @Field("source") private String source;
    @Field("timestamp") private Date time;

    public Tweet(List text, String location, Double confidence, Integer condition, String source, Date time) {
        this.text = text;
        this.location = location;
        this.confidence = confidence;
        this.condition = condition;
        this.source = source;
        this.time = time;
    }

    public Tweet() {
    }

    public void setText(List text) {
        this.text = text;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List getText() {
        return text;
    }

    public String getLocation() {
        return location;
    }

    public Double getConfidence() {
        return confidence;
    }

    public Integer getCondition() {
        return condition;
    }

    public String getSource() {
        return source;
    }

    public Date getTime() {
        return time;
    }
}
