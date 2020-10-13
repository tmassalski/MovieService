package pl.tmassalski.MovieService.infrastructure.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.actor.Actor;
import pl.tmassalski.MovieService.domain.actor.ActorUpdaterClient;

@Service
@RequiredArgsConstructor
public class ActorUpdaterPostgresClient implements ActorUpdaterClient {

    private final ActorRepository actorRepository;


    @Override
    public void update(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public void delete(Long id) {
        actorRepository.deleteById(id);
    }
}
