package pl.tmassalski.MovieService.domain.user;


import pl.tmassalski.MovieService.domain.Auditable;

public class User extends Auditable {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
