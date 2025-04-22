package com.avg.poc.dropwizard;

import com.avg.poc.dropwizard.health.TemplateHealthCheck;
import com.avg.poc.dropwizard.resources.PersonResource;
import com.avg.poc.dropwizard.db.Person;
import com.avg.poc.dropwizard.db.PersonDAO;
import io.dropwizard.core.Application;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleAppApplication extends Application<SampleAppConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleAppApplication.class);

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
        LOGGER.info("Environment from config: {}", environment.getName());
        final PersonDAO personDAO = new PersonDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new PersonResource(personDAO));

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck("TEST");
        environment.healthChecks().register("template", healthCheck);
    }
}
