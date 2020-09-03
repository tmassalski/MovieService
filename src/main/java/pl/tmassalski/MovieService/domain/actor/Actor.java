package pl.tmassalski.MovieService.domain.actor;

import lombok.*;
import pl.tmassalski.MovieService.domain.Auditable;
import pl.tmassalski.MovieService.domain.movie.Movie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Actor extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Movie> movies = new HashSet<>();

    public static Actor generate(ActorCreatorCommand actorCreatorCommand) {
        Actor actor = new Actor();
        actor.setFirstName(actorCreatorCommand.getFirstName());
        actor.setLastName(actorCreatorCommand.getLastName());
        return actor;
    }
}
