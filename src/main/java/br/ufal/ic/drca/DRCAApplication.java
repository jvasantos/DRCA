package br.ufal.ic.drca;

import br.ufal.ic.drca.resources.IndexResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DRCAApplication extends Application<DRCAConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DRCAApplication().run( new String[] { "server" });
    }

    @Override
    public String getName() {
        return "DRCA";
    }

    @Override
    public void initialize(final Bootstrap<DRCAConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DRCAConfiguration configuration,
                    final Environment environment) {
       environment.jersey().register(new IndexResource());
    }

}
