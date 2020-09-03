package pl.tmassalski.MovieService.infrastructure.director;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.MovieService.domain.director.Director;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
