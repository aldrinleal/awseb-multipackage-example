package io.ingenieux;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.ingenieux.resources.HealthCheckResource;

public class Main extends Application<ServiceConfiguration> {

  public static void main(String[] args) throws Exception {
    new Main().run(args);
  }

  @Override
  public String getName() {
    return "awseb-multipackage-example";
  }

  @Override
  public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
    bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor()));
  }

  @Override
  public void run(ServiceConfiguration cfg,
                  Environment env) throws Exception {
    env.jersey().register(HealthCheckResource.class);
  }
}
