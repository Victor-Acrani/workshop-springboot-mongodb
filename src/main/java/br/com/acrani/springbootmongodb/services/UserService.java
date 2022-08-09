package br.com.acrani.springbootmongodb.services;

import br.com.acrani.springbootmongodb.dto.UserDto;
import br.com.acrani.springbootmongodb.models.User;
import br.com.acrani.springbootmongodb.repositories.UserRepository;
import br.com.acrani.springbootmongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
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

    public UserDto findById(String id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. Id:" + id));
        return new UserDto(user);
    }

    public User save(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return userRepository.save(user);

    }
}
