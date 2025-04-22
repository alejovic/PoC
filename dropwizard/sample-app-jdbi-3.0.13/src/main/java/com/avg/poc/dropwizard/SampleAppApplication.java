package com.avg.poc.dropwizard;

import com.avg.poc.dropwizard.health.TemplateHealthCheck;
import com.avg.poc.dropwizard.resources.PersonResource;
import com.avg.poc.dropwizard.db.PersonDAO;
import io.dropwizard.core.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.core.setup.Environment;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleAppApplication extends Application<SampleAppConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleAppApplication.class);


    public static void main(String[] args) throws Exception {
        new SampleAppApplication().run(args);
    }

    @Override
    public void run(SampleAppConfiguration configuration, Environment environment) {
        LOGGER.info("Environment from config: {}", environment.getName());

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

        // It activates all available JDBI 3 plugins automatically:
        //jdbi.installPlugins();

        final PersonDAO dao = jdbi.onDemand(PersonDAO.class);

        // Create table on startup
        dao.createTable();

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck("TEST");
        environment.healthChecks().register("template", healthCheck);

        environment.jersey().register(new PersonResource(dao));
    }
}
