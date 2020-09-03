package pl.tmassalski.MovieService.infrastructure.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.MovieService.domain.movie.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
