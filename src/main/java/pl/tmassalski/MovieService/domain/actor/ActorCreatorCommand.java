package pl.tmassalski.MovieService.domain.actor;

import graphql.schema.GraphQLInputType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ActorCreatorCommand implements GraphQLInputType {

    String firstName;
    String lastName;

    @Override
    public String getName() {
        return "ActorCreatorCommand";
    }
}
