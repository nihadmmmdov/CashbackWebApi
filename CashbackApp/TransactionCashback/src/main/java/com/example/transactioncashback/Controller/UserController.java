package com.example.transactioncashback.Controller;

import com.example.transactioncashback.Dto.CreateUserRequest;
import com.example.transactioncashback.Dto.UpdateUserRequest;
import com.example.transactioncashback.Entity.User;
import com.example.transactioncashback.Service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) {
        userService.createUser(request);
        return ResponseEntity.ok("User created successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UpdateUserRequest request) {
        userService.updateUser(request);
        return ResponseEntity.ok("User updated successfully");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
    @GetMapping("/get")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}
