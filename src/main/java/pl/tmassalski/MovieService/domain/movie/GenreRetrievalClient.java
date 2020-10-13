package pl.tmassalski.MovieService.domain.movie;

import java.util.List;

public interface GenreRetrievalClient {

    Genre getById(Long id);
    List<Genre> getAll();
}
