package me.dio.service;
import java.util.List;

import me.dio.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

    void deletar(Long id);

    User update(User userToUpdate);

    List<User> findAll();
}
