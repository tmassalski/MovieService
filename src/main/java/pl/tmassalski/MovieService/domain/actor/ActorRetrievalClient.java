package pl.tmassalski.MovieService.domain.actor;

import java.util.List;

public interface ActorRetrievalClient {

    Actor getById(long id);
    List<Actor> getAll();
}
