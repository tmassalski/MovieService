package pl.tmassalski.MovieService.infrastructure.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.movie.GenreUpdaterClient;

@RequiredArgsConstructor
@Service
public class GenreUpdaterPostgresClient implements GenreUpdaterClient {

    private final GenreRepository genreRepository;

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
