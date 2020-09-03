package pl.tmassalski.MovieService.infrastructure.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.MovieService.domain.movie.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
