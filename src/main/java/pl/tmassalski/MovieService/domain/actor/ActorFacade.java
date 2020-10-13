package pl.tmassalski.MovieService.domain.actor;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorFacade implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final ActorRetrievalClient actorRetrievalClient;
    private final ActorCreator actorCreator;
    private final ActorUpdaterClient actorUpdaterClient;

    public Actor createActor(ActorCreatorCommand actorCreatorCommand) {
        return actorCreator.create(actorCreatorCommand);
    }

    public Actor getActorById(long id) {
        return actorRetrievalClient.getById(id);
    }

    public List<Actor> getAllActors() {
        return actorRetrievalClient.getAll();
    }

    public Boolean deleteActor(Long id) {
        actorUpdaterClient.delete(id);
        return true;
    }

    @Transactional
    public Actor updateActor(ActorUpdateRequest actorUpdateRequest) {
        Actor actor = getActorById(actorUpdateRequest.getId());
        actor.setFirstName(actorUpdateRequest.getFirstName());
        actor.setLastName(actorUpdateRequest.getLastName());
        actorUpdaterClient.update(actor);
        return actor;
    }
}
