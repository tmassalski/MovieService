package pl.tmassalski.MovieService.domain.movie;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieFacade implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final MovieCreator movieCreator;
    private final MovieRetrievalClient movieRetrievalClient;
    private final MovieUpdaterClient movieUpdaterClient;
    private final MovieUpdater movieUpdater;

    public Movie createMovie(MovieCreatorCommand movieCreatorCommand) {
        return movieCreator.create(movieCreatorCommand);
    }

    public Movie getMovieById(long movieId) {
        return movieRetrievalClient.getById(movieId);
    }

    public List<Movie> getAllMovies() {
        return movieRetrievalClient.getAll();
    }

    @Transactional
    public Movie updateMovie(MovieUpdateRequest movieUpdateRequest){
        Movie movie = getMovieById(movieUpdateRequest.getId());
        movieUpdater.update(movie, movieUpdateRequest);
        return movie;
    }

    public Boolean deleteMovie(Long id) {
        movieUpdaterClient.delete(id);
        return true;
    }
}
