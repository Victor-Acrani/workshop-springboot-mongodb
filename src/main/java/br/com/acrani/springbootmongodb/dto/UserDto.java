package br.com.acrani.springbootmongodb.dto;

import br.com.acrani.springbootmongodb.models.User;

import java.io.Serial;
import java.io.Serializable;

public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
