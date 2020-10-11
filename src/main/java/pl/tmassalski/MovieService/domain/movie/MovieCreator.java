package pl.tmassalski.MovieService.domain.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieCreator {

    private final MovieCreatorClient movieCreatorClient;

    @Transactional
    public Movie create(MovieCreatorCommand movieCreatorCommand) {
        Movie movie = Movie.generate(movieCreatorCommand);
        movieCreatorClient.create(movie);
        return movie;
    }
}
