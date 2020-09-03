package pl.tmassalski.MovieService.domain.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ActorCreator {

    private final ActorCreatorClient actorCreatorClient;

    @Transactional
    public void create(ActorCreatorCommand actorCreatorCommand) {
        Actor actor = Actor.generate(actorCreatorCommand);
        actorCreatorClient.create(actor);
    }
}
