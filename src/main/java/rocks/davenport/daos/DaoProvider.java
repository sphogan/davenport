package rocks.davenport.daos;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.skife.jdbi.v2.DBI;

import java.util.Optional;

public class DaoProvider<T> implements Provider<T> {
    private final Class<T> type;
    private Optional<DBI> dbi;

    public DaoProvider(Class<T> type) {
        this.type = type;
        this.dbi = Optional.empty();
    }

    @Inject
    public void setDbi(DBI dbi) {
        this.dbi = Optional.of(dbi);
    }

    @Override
    public T get() {
        return dbi.get().onDemand(type);
    }
}
