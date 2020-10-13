package pl.tmassalski.MovieService.infrastructure.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.movie.Genre;
import pl.tmassalski.MovieService.domain.movie.GenreRetrievalClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreRetrievalPostgresClient implements GenreRetrievalClient {

    private final GenreRepository genreRepository;

    @Override
    public Genre getById(Long id) {
        Optional<Genre> result = genreRepository.findById(id);
        return result.orElseThrow();
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
}
