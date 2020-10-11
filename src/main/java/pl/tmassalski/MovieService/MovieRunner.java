package pl.tmassalski.MovieService;

import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.tmassalski.MovieService.domain.actor.Actor;
import pl.tmassalski.MovieService.domain.director.Director;
import pl.tmassalski.MovieService.domain.movie.Genre;
import pl.tmassalski.MovieService.domain.movie.MovieCreator;
import pl.tmassalski.MovieService.domain.movie.MovieCreatorCommand;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class MovieRunner implements CommandLineRunner {

    private final MovieCreator movieCreator;

    private void movieServiceInvocation() {

        Actor actor = new Actor();
        actor.setFirstName("Keanu");
        actor.setLastName("Reeves");
        Actor actor1 = new Actor();
        actor1.setFirstName("Laurence");
        actor1.setLastName("Fishburne");
        Set<Actor> actors = new HashSet<>();
        actors.add(actor);
        actors.add(actor1);
        Director director = new Director();
        director.setFirstName("Lilly");
        director.setLastName("Wachowski");
        Set<Director> directors = new HashSet<>();
        directors.add(director);
        Genre genre = new Genre();
        genre.setGenre("Sci-Fi");
        Set<Genre> genres = new HashSet<>();
        genres.add(genre);

        MovieCreatorCommand movieCreatorCommand = MovieCreatorCommand.builder()
                .title("The Matrix")
                .year(1999)
                .genre(genres)
                .director(directors)
                .actors(actors)
                .plot("dupa")
                .build();
        movieCreator.create(movieCreatorCommand);
    }
    @Override
    public void run(String... args) throws Exception {
        movieServiceInvocation();
    }
}
