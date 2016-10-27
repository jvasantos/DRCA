package br.ufal.ic.drca;

import br.ufal.ic.drca.core.Student;
import br.ufal.ic.drca.db.StudentDAO;
import br.ufal.ic.drca.resources.StudentsResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DRCAApplication extends Application<DRCAConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DRCAApplication().run( new String[] { "server", "config.yml" });
    }

    @Override
    public String getName() {
        return "DRCA";
    }
    
    
    private final HibernateBundle<DRCAConfiguration> hibernateBundle
    	= new HibernateBundle<DRCAConfiguration>(Student.class) {
    		@Override
    		public DataSourceFactory getDataSourceFactory(DRCAConfiguration configuration) {
    			return configuration.getDataSourceFactory();
    		}
		};
    
    @Override
    public void initialize(final Bootstrap<DRCAConfiguration> bootstrap) {
       bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final DRCAConfiguration configuration,
                    final Environment environment) {
       final StudentDAO studentDAO = new StudentDAO(hibernateBundle.getSessionFactory());
       
       environment.jersey().register(new StudentsResource(studentDAO));
    }

}
