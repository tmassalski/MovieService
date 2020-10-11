package pl.tmassalski.MovieService.domain.actor;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ActorResponse {

    private final long id;
    private final String firstName;
    private final String lastName;
}
