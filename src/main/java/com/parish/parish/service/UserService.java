package com.parish.parish.service;

import com.parish.parish.domain.User;
import com.parish.parish.domain.UserRepository;
import com.parish.parish.web.dto.UserParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Transactional
    public Long createUser(UserParam userParam) {
        User user = new User();
        user.setUserName(userParam.getUserName());
        user.setUserNameSeparator(userParam.getUserNameSeparator());
        user.setParishCode(userParam.getParishCode());
        user.setAreaCode(userParam.getAreaCode());
        user.setPastoralCode(userParam.getPastoralCode());

        User tmpUser = userRepository.save(user);

        return tmpUser.getUserId();
    }

    @Transactional
    public Boolean checkLeader(Long userId, Boolean parishLeader, Boolean areaLeader, Boolean pastoralLeader) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return false;
        } else {
            user.setParishLeader(parishLeader);
            user.setAreaLeader(areaLeader);
            user.setPastoralLeader(pastoralLeader);

            userRepository.save(user);

            return true;
        }
    }

    @Transactional
    public Boolean updateUser(Long userId, UserParam userParam) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return false;
        } else {
            // 목자이면서 지역이 변경되는 경우 -> 목장원들도 일괄적으로 지역변경
            if (user.getPastoralLeader() && user.getAreaCode() != userParam.getAreaCode()) {
                userRepository.updateUserAreaCode(userParam.getAreaCode(), user.getPastoralCode());
            }

            user.setUserName(userParam.getUserName());
            user.setUserNameSeparator(userParam.getUserNameSeparator());
            user.setParishCode(userParam.getParishCode());
            user.setAreaCode(userParam.getAreaCode());
            user.setPastoralCode(userParam.getPastoralCode());

            userRepository.save(user);

            return true;
        }
    }
}
