package br.com.acrani.springbootmongodb.dto;

import br.com.acrani.springbootmongodb.models.User;

import java.io.Serial;
import java.io.Serializable;

public class AuthorDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    public AuthorDto() {
    }

    public AuthorDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
