package com.avg.poc.quarkus;

import io.smallrye.config.SmallRyeConfig;
import org.eclipse.microprofile.config.Config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class PropertyPoCServerMockProducer {

    @Inject
    Config config;

    @Produces
    @ApplicationScoped
    @io.quarkus.test.Mock
    PropertyPoC propertyMock() {
        return config.unwrap(SmallRyeConfig.class).getConfigMapping(PropertyPoC.class);
    }
}
