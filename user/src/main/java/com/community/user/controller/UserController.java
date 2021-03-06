package com.community.user.controller;

import com.community.user.domain.User;
import com.community.user.entity.UserEntity;
import com.community.user.service.FollowService;
import com.community.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    
    private final UserService userService;

    @PostMapping("/register")
    public void createNewUser(@RequestBody User user) throws Exception {
        userService.createNewUser(user);
    }

    @GetMapping("/profile")
    public User getUserProfile(){

        User user = userService.getUserProfile();
        System.out.println(user);
        return user;
    }

    @GetMapping("/profile/from/username/{userName}")
    public UserEntity getUserFromUserName(@PathVariable("userName") String userName)
    {
        return userService.getUserByUserName(userName);
    }

    @GetMapping("/profile/{id}")
    public User getUserById(@PathVariable("id") long id)
    {
        return userService.getUserById(id);
    }
}
