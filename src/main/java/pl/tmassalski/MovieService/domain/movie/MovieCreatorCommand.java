package pl.tmassalski.MovieService.domain.movie;

import lombok.Builder;
import lombok.Getter;
import pl.tmassalski.MovieService.domain.actor.Actor;
import pl.tmassalski.MovieService.domain.director.Director;

import java.util.Set;

@Builder
@Getter
public class MovieCreatorCommand {

    String title;
    int year;
    Set<Genre> genre;
    Set<Director> director;
    Set<Actor> actors;
    String plot;
}
