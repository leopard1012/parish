package com.parish.parish.web;

import com.parish.parish.domain.User;
import com.parish.parish.service.UserService;
import com.parish.parish.web.dto.UserParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/users")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @PutMapping(value = "/user")
    @Transactional
    public Long createUser(@RequestBody UserParam userParam) {
        return userService.createUser(userParam);
    }

    @PatchMapping(value = "/user/{userId}/check-leader")
    @Transactional
    public Boolean checkLeader(
            @PathVariable Long userId,
            @RequestParam Boolean parishLeader,
            @RequestParam Boolean areaLeader,
            @RequestParam Boolean pastoralLeader
    ) {
        return userService.checkLeader(userId, parishLeader, areaLeader, pastoralLeader);
    }

    @PostMapping(value = "/user/{userId}")
    @Transactional
    public Boolean updateUser(
            @PathVariable Long userId,
            @RequestBody UserParam userParam
    ) {
        return userService.updateUser(userId, userParam);
    }
}
