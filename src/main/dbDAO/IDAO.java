package dbDAO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Common Interface for accessing DB data
 */

public interface IDAO<T> {

    void create(T value);
    Optional<T> get(String id);
    public Collection<T> getAll();
    List<Optional<T>> getBatch(String id);
    void update(T value);
    void delete(String id);

}
