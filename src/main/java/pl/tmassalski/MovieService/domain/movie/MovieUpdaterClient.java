package pl.tmassalski.MovieService.domain.movie;

public interface MovieUpdaterClient {

    void update(Movie movie);
    void delete(Long id);
}
