package pl.tmassalski.MovieService.domain.actor;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ActorCreatorCommand {

    String firstName;
    String lastName;
}
