package pl.tmassalski.MovieService.infrastructure.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.movie.Movie;
import pl.tmassalski.MovieService.domain.movie.MovieCreatorClient;

@Service
@RequiredArgsConstructor
public class MoviePostgresCreatorClient implements MovieCreatorClient {

    private final MovieRepository movieRepository;

    @Override
    public void create(Movie movie) {
        movieRepository.save(movie);
    }
}
