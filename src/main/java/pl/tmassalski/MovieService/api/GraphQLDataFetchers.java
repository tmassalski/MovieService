package pl.tmassalski.MovieService.api;

import graphql.schema.DataFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tmassalski.MovieService.domain.actor.Actor;
import pl.tmassalski.MovieService.domain.actor.ActorFacade;
import pl.tmassalski.MovieService.domain.director.Director;
import pl.tmassalski.MovieService.domain.movie.Genre;
import pl.tmassalski.MovieService.domain.movie.MovieCreatorCommand;
import pl.tmassalski.MovieService.domain.movie.MovieFacade;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class GraphQLDataFetchers {

    private final MovieFacade movieFacade;
    private final ActorFacade actorFacade;

    public DataFetcher getMovieByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String movieId = dataFetchingEnvironment.getArgument("id");
            return movieFacade.getMovieById(Long.parseLong(movieId));
        };
    }

    public DataFetcher getActorByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String actorId = dataFetchingEnvironment.getArgument("id");
            return actorFacade.getActorById(Long.parseLong(actorId));
        };
    }

    public DataFetcher addMovieDataFetcher() {
        return dataFetchingEnvironment -> {
            String title = dataFetchingEnvironment.getArgument("title");
            int year = dataFetchingEnvironment.getArgument("year");
            Set<Genre> genre = dataFetchingEnvironment.getArgument("genre");
            Set<Director> director = dataFetchingEnvironment.getArgument("director");
            Set<Actor> actors = dataFetchingEnvironment.getArgument("actors");
            String plot = dataFetchingEnvironment.getArgument("plot");
            MovieCreatorCommand command = CreateCommand(title, year, genre, director, actors, plot);
            return movieFacade.create(command);
        };
    }

    private MovieCreatorCommand CreateCommand(String title, int year, Set<Genre> genre, Set<Director> director, Set<Actor> actors, String plot) {
        return MovieCreatorCommand.builder()
                .title(title)
                .year(year)
                .genre(genre)
                .director(director)
                .actors(actors)
                .plot(plot)
                .build();
    }
}
