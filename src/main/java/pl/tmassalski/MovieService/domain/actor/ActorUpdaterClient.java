package pl.tmassalski.MovieService.domain.actor;

public interface ActorUpdaterClient {

    void update(Actor actor);
    void delete(Long Id);
}
