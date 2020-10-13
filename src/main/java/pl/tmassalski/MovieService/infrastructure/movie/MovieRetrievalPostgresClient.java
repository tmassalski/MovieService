package pl.tmassalski.MovieService.infrastructure.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.movie.Movie;
import pl.tmassalski.MovieService.domain.movie.MovieRetrievalClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieRetrievalPostgresClient implements MovieRetrievalClient {

    private final MovieRepository movieRepository;

    @Override
    public Movie getById(long movieId) {

        Optional<Movie> result = movieRepository.findById(movieId);
        return result.orElseThrow();
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
