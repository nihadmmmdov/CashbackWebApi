package com.example.transactioncashback.Service.user;

import com.example.transactioncashback.Dto.CreateUserRequest;
import com.example.transactioncashback.Dto.UpdateUserRequest;
import com.example.transactioncashback.Entity.User;
import com.example.transactioncashback.Repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public String createUser(CreateUserRequest request){
        User existingUser = userRepository.getByName(request.getName());
        if(Objects.isNull(existingUser)){
            User newUser = new User();
            newUser.setCreatedDate(LocalDateTime.now());
            newUser.setActive(true);
            newUser.setName(request.getName());
            newUser.setEmail(request.getEmail());
            userRepository.save(newUser);
            return newUser.getName() + "Created";
        }
        else{
            return "User is already exist";
        }
    }

    public String updateUser(UpdateUserRequest request) {
        User existingUser = userRepository.getById(request.getId());
        if(Objects.isNull(existingUser)){
            throw new RuntimeException();
        }
        existingUser.setName(request.getName());
        existingUser.setEmail(request.getEmail());
        userRepository.save(existingUser);
        return existingUser.getName() + " Updated";
    }

    public String deleteUser(Long id) {
        User existingUser = userRepository.getById(id);
        if(Objects.isNull(existingUser)){
            throw new RuntimeException();
        }
        userRepository.delete(existingUser);
        return existingUser.getName() + " Deleted";
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
