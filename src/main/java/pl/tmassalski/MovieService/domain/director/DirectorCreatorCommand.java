package pl.tmassalski.MovieService.domain.director;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DirectorCreatorCommand {

    String firstName;
    String lastName;
}
