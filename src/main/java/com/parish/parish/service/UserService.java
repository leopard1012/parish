package com.parish.parish.service;

import com.parish.parish.domain.User;
import com.parish.parish.domain.UserRepository;
import com.parish.parish.web.dto.UserParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public Long createUser(UserParam userParam) {
        User user = new User();
        user.setUserName(userParam.getUserName());
        user.setAffiliatedParish(userParam.getAffiliatedParish());

        User tmpUser = userRepository.save(user);

        return tmpUser.getUserId();
    }
}
