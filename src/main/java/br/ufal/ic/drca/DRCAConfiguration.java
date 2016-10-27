package br.ufal.ic.drca;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class DRCAConfiguration extends Configuration {
    
	@NotNull
	@Valid
	private DataSourceFactory dataSourceFactory = new DataSourceFactory();
	
	@JsonProperty("database")
	public DataSourceFactory getDataSourceFactory() {
		return dataSourceFactory;
	}
}
