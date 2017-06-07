package rocks.davenport;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.bundles.assets.AssetsBundleConfiguration;
import io.dropwizard.bundles.assets.AssetsConfiguration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DavenportConfiguration extends Configuration implements AssetsBundleConfiguration {
    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("rockerReloading")
    private boolean rockerReloading;

    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = AssetsConfiguration.builder().build();


    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public boolean isRockerReloading() {
        return rockerReloading;
    }

    @Override
    public AssetsConfiguration getAssetsConfiguration() {
        return assets;
    }
}
