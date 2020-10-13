package pl.tmassalski.MovieService.domain.director;

public interface DirectorUpdaterClient {

    void update(Director director);
    void delete(Long id);

}
