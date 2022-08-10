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

    public User findById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. Id:" + id));

    }

    public User save(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return userRepository.save(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(String id, UserDto userDto){
        User user = findById(id);
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        return userRepository.save(user);
    }

}
