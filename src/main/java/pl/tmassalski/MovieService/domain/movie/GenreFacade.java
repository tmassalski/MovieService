package pl.tmassalski.MovieService.domain.movie;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreFacade implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final GenreCreatorClient genreCreatorClient;
    private final GenreRetrievalClient genreRetrievalClient;
    private final GenreUpdaterClient genreUpdaterClient;

    public Genre getGenreById(Long id) {
        return genreRetrievalClient.getById(id);
    }

    public List<Genre> getAllGenre() {
        return genreRetrievalClient.getAll();
    }

    public Genre createGenre(String genre) {
        Genre newGenre = Genre.generate(genre);
        genreCreatorClient.create(newGenre);
        return newGenre;
    }

    public Boolean deleteGenre(Long id) {
        genreUpdaterClient.delete(id);
        return true;
    }
}
