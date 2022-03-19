package com.parish.parish.web;

import com.parish.parish.domain.User;
import com.parish.parish.service.UserService;
import com.parish.parish.web.dto.UserParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @RequestMapping(value = "/v1/users", method = RequestMethod.GET, consumes = "application/json")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @RequestMapping(value = "/v1/user", method = RequestMethod.PUT, consumes = "application/json")
    @Transactional
    public Long createUser(@RequestBody UserParam userParam) {
        return userService.createUser(userParam);
    }
}
