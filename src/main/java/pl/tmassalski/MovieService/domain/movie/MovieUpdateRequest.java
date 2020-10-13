package pl.tmassalski.MovieService.domain.movie;

import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
public class MovieUpdateRequest implements GraphQLInputType {

    private Long id;
    private String title;
    private int year;
    private Set<Long> genreIds;
    private Set<Long> directorIds;
    private Set<Long> actorIds;
    private String plot;

    @Override
    public String getName() {
        return "MovieUpdateRequest";
    }
}
