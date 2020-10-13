package pl.tmassalski.MovieService.domain.director;

import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class DirectorUpdateRequest implements GraphQLInputType {

    Long id;
    String firstName;
    String lastName;

    @Override
    public String getName() {
        return "DirectorUpdateRequest";
    }
}
