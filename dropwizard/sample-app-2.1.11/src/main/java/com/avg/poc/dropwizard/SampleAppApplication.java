package com.avg.poc.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class SampleAppApplication extends Application<SampleAppConfiguration> {

    public static void main(String[] args) throws Exception {
        new SampleAppApplication().run(args);
    }

    @Override
    public void run(SampleAppConfiguration configuration, Environment environment) {

    }
}
