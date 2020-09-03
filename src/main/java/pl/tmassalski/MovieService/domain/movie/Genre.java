package pl.tmassalski.MovieService.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String genre;

    @ManyToMany(mappedBy = "genre", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Movie> movies = new HashSet<>();
}
