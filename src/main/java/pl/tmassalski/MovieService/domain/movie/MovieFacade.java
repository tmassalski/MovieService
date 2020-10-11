package pl.tmassalski.MovieService.domain.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieFacade {

    private final MovieCreator movieCreator;
    private final MovieRetrievalClient movieRetrievalClient;

    public Movie create(MovieCreatorCommand movieCreatorCommand) {
        return movieCreator.create(movieCreatorCommand);
    }

    public MovieResponse getMovieById(long movieId) {
        Movie movie = movieRetrievalClient.getById(movieId);
        return movie.generateResponse();
    }
}
