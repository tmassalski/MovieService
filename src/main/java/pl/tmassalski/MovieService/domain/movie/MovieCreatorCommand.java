package pl.tmassalski.MovieService.domain.movie;

import graphql.schema.GraphQLInputType;
import lombok.*;
import pl.tmassalski.MovieService.domain.actor.Actor;
import pl.tmassalski.MovieService.domain.director.Director;

import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
public class MovieCreatorCommand implements GraphQLInputType {

    String title;
    int year;
    Set<Long> genreId;
    Set<Long> directorId;
    Set<Long> actorId;
    String plot;

    @Override
    public String getName() {
        return "MovieCreatorInput";
    }
}
