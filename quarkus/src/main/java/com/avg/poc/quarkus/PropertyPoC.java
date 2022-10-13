package com.avg.poc.quarkus;


import io.smallrye.config.ConfigMapping;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@ConfigMapping(prefix = "quarkus-poc")
public interface PropertyPoC {

    String property1();

    String property2();

    Set<Properties> properties();

    interface Properties {
        String property1();
        String property2();
    }

    PropertyList list();

    interface PropertyList {
        Optional<List<String>> properties();
    }

}
