package pl.tmassalski.MovieService.domain.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.actor.ActorRetrievalClient;
import pl.tmassalski.MovieService.domain.director.DirectorRetrievalClient;

import java.time.Year;

@Service
@RequiredArgsConstructor
public class MovieUpdater {

    private final MovieUpdaterClient movieUpdaterClient;
    private final GenreRetrievalClient genreRetrievalClient;
    private final ActorRetrievalClient actorRetrievalClient;
    private final DirectorRetrievalClient directorRetrievalClient;


    public Movie update (Movie movie, MovieUpdateRequest movieUpdateRequest) {
        movie.setTitle(movieUpdateRequest.getTitle());
        movie.setYear(Year.of(movieUpdateRequest.getYear()));
        movie.setPlot(movieUpdateRequest.getPlot());
        movieUpdateRequest.getGenreIds().forEach(id -> movie.getGenre().add(genreRetrievalClient.getById(id)));
        movieUpdateRequest.getActorIds().forEach(id -> movie.getActors().add(actorRetrievalClient.getById(id)));
        movieUpdateRequest.getDirectorIds().forEach(id -> movie.getDirector().add(directorRetrievalClient.getById(id)));
        movieUpdaterClient.update(movie);
        return movie;
    }


}
