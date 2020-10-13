package pl.tmassalski.MovieService.domain.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.MovieService.domain.actor.ActorRetrievalClient;
import pl.tmassalski.MovieService.domain.director.DirectorRetrievalClient;

@Service
@RequiredArgsConstructor
public class MovieCreator {

    private final MovieCreatorClient movieCreatorClient;
    private final GenreRetrievalClient genreRetrievalClient;
    private final ActorRetrievalClient actorRetrievalClient;
    private final DirectorRetrievalClient directorRetrievalClient;

    @Transactional
    public Movie create(MovieCreatorCommand movieCreatorCommand) {
        Movie movie = Movie.generate(movieCreatorCommand);
        movieCreatorCommand.getGenreId().forEach(genreId -> movie.getGenre().add(genreRetrievalClient.getById(genreId)));
        movieCreatorCommand.getActorId().forEach(actorId -> movie.getActors().add(actorRetrievalClient.getById(actorId)));
        movieCreatorCommand.getDirectorId().forEach(directorId -> movie.getDirector().add(directorRetrievalClient.getById(directorId)));
        movieCreatorClient.create(movie);
        return movie;
    }
}
