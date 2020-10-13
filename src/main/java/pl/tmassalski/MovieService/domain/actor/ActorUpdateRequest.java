package pl.tmassalski.MovieService.domain.actor;

import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ActorUpdateRequest implements GraphQLInputType {

    Long id;
    String firstName;
    String lastName;

    @Override
    public String getName() {
        return "ActorUpdateRequest";
    }
}
