package pl.tmassalski.MovieService.domain.director;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class Director extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "director", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Movie> movies = new HashSet<>();

    public static Director generate(DirectorCreatorCommand directorCreatorCommand) {
        Director director = new Director();
        director.setFirstName(directorCreatorCommand.getFirstName());
        director.setLastName(directorCreatorCommand.getLastName());
        return director;
    }
}
