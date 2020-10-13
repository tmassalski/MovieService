package pl.tmassalski.MovieService.domain.movie;

import java.util.List;

public interface MovieRetrievalClient {

    Movie getById(long id);
    List<Movie> getAll();
}
