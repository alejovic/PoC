package com.avg.poc.dropwizard;

import com.avg.poc.dropwizard.resources.PersonResource;
import com.avg.poc.dropwizard.db.Person;
import com.avg.poc.dropwizard.db.PersonDAO;
import io.dropwizard.Application;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SampleAppApplication extends Application<SampleAppConfiguration> {

    public static void main(String[] args) throws Exception {
        new SampleAppApplication().run(args);
    }

    private final HibernateBundle<SampleAppConfiguration> hibernateBundle =
            new HibernateBundle<SampleAppConfiguration>(Person.class) {
                @Override
                public io.dropwizard.db.DataSourceFactory getDataSourceFactory(SampleAppConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(Bootstrap<SampleAppConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(SampleAppConfiguration configuration, Environment environment) {
        final PersonDAO personDAO = new PersonDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new PersonResource(personDAO));
    }
}
