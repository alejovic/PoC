package com.avg.poc.dropwizard;

import com.avg.poc.dropwizard.api.PersonResource;
import com.avg.poc.dropwizard.db.PersonDAO;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class SampleAppApplication extends Application<SampleAppConfiguration> {

    public static void main(String[] args) throws Exception {
        new SampleAppApplication().run(args);
    }

    @Override
    public void run(SampleAppConfiguration configuration, Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

        final PersonDAO dao = jdbi.onDemand(PersonDAO.class);

        // Create table on startup
        dao.createTable();

        environment.jersey().register(new PersonResource(dao));
    }
}
