package ionutcosmici.spring5webapp.repositories;

import ionutcosmici.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
