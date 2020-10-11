package pl.tmassalski.MovieService.domain.movie;

import lombok.Builder;
import lombok.Getter;
import pl.tmassalski.MovieService.domain.actor.Actor;
import pl.tmassalski.MovieService.domain.director.Director;

import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
public class MovieResponse {

    Long id;
    String title;
    int year;
    Set<Genre> genre = new HashSet<>();
    Set<Director> director = new HashSet<>();
    Set<Actor> actors = new HashSet<>();
    String plot;
}
