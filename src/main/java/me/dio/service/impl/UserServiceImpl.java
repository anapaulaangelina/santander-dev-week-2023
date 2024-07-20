package me.dio.service.impl;

import java.util.List;
import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
    
    @Override
    public User update(User userToUpdate) {
        findById(userToUpdate.getId());
        return userRepository.save(userToUpdate);
    }
    
    @Override
    public void deletar(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }
    
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
