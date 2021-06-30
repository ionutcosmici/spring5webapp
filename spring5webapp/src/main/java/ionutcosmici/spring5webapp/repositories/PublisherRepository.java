package ionutcosmici.spring5webapp.repositories;

import ionutcosmici.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
