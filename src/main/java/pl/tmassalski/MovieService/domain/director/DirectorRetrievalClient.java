package pl.tmassalski.MovieService.domain.director;

import java.util.List;

public interface DirectorRetrievalClient {

    Director getById(Long id);
    List<Director> getAll();
}
