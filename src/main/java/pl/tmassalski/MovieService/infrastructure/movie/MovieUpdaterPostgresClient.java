package pl.tmassalski.MovieService.infrastructure.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.movie.Movie;
import pl.tmassalski.MovieService.domain.movie.MovieUpdaterClient;

@RequiredArgsConstructor
@Service
public class MovieUpdaterPostgresClient implements MovieUpdaterClient {

    private final MovieRepository movieRepository;


    @Override
    public void update(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
