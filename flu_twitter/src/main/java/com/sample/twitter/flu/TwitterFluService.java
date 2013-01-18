package com.sample.twitter.flu;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.migrations.MigrationsBundle;

/**
 * Created with IntelliJ IDEA.
 * User: sudo
 * Date: 1/13/13
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class TwitterFluService extends Service<TwitterFluConfiguration> {
    public static void main(String[] args) throws Exception {
        new TwitterFluService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TwitterFluConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
        bootstrap.addBundle(new AssetsBundle());

    }

    @Override
    public void run(TwitterFluConfiguration configuration,
                           Environment environment) {
//        final String template = configuration.getTemplate();
//        environment.addResource(new SampleDropwizardResource(template));
//        environment.addHealthCheck(new SampleDropwizardHealthCheck(template));
    }


}