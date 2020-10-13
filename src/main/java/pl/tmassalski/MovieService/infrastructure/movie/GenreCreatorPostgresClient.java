package pl.tmassalski.MovieService.infrastructure.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.movie.Genre;
import pl.tmassalski.MovieService.domain.movie.GenreCreatorClient;

@Service
@RequiredArgsConstructor
public class GenreCreatorPostgresClient implements GenreCreatorClient {

    private final GenreRepository genreRepository;

    @Override
    public void create(Genre genre) {
        genreRepository.save(genre);
    }
}
