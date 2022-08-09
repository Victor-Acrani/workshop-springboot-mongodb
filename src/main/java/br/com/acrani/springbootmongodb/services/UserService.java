package br.com.acrani.springbootmongodb.services;

import br.com.acrani.springbootmongodb.dto.UserDto;
import br.com.acrani.springbootmongodb.models.User;
import br.com.acrani.springbootmongodb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll(){
        List<User> all = userRepository.findAll();
        return all.stream().map(UserDto::new).toList();
    }
}
