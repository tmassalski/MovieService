package pl.tmassalski.MovieService.domain.director;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorFacade implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final DirectorRetrievalClient directorRetrievalClient;
    private final DirectorCreator directorCreator;
    private final DirectorUpdaterClient directorUpdaterClient;

    public Director getDirectorById(long id) {
        return directorRetrievalClient.getById(id);
    }

    public List<Director> getAllDirectors() {
        return directorRetrievalClient.getAll();
    }

    public Director createDirector(DirectorCreatorCommand directorCreatorCommand) {
        return directorCreator.create(directorCreatorCommand);
    }

    @Transactional
    public Director updateDirector(DirectorUpdateRequest directorUpdateRequest) {
        Director director = directorRetrievalClient.getById(directorUpdateRequest.getId());
        director.setFirstName(directorUpdateRequest.getFirstName());
        director.setLastName(directorUpdateRequest.getLastName());
        directorUpdaterClient.update(director);
        return director;
    }

    public boolean deleteDirector(Long id) {
        directorUpdaterClient.delete(id);
        return true;
    }

}
