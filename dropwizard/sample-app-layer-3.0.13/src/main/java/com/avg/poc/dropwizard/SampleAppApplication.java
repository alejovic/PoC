package com.avg.poc.dropwizard;

import com.avg.poc.dropwizard.dao.PersonHibernate;
import com.avg.poc.dropwizard.infrastructure.TemplateHealthCheck;
import com.avg.poc.dropwizard.controller.PersonResource;
import com.avg.poc.dropwizard.dao.Person;
import com.avg.poc.dropwizard.jdbi.PersonJdbi;
import com.avg.poc.dropwizard.repository.PersonRepository;
import com.avg.poc.dropwizard.service.PersonService;
import io.dropwizard.core.Application;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.jdbi3.JdbiFactory;
import org.jdbi.v3.core.Jdbi;
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

        PersonRepository personRepository = null;
        if(configuration.getRepository().equals("jdbi")) {
            LOGGER.info("Using JDBI repository");
            final JdbiFactory factory = new JdbiFactory();
            final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
            personRepository = new PersonJdbi(jdbi);
        } else {
            LOGGER.info("Using Hibernate repository");
            personRepository = new PersonHibernate(hibernateBundle.getSessionFactory());
        }

        final PersonService personService = new PersonService(personRepository);
        environment.jersey().register(new PersonResource(personService));

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck("TEST");
        environment.healthChecks().register("template", healthCheck);
    }
}
