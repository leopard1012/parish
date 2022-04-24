package com.parish.parish.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parish.parish.domain.ServiceAttendance;
import com.parish.parish.domain.ServiceAttendanceRepository;
import com.parish.parish.domain.User;
import com.parish.parish.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class ServiceAttendanceService {
    private final UserRepository userRepository;
    private final ServiceAttendanceRepository attendanceRepository;

    @Transactional
    public Long updateServiceAttendanceForSurveyForm(HashMap<String, Object> resultMap) {
        ObjectMapper mapper = new ObjectMapper();
        LocalDate attendDate = null;
        List<Object> attendCheck = new ArrayList<>();
        List<Object> targetPeople = new ArrayList<>();
        String serviceType = "SUNDAY";
        String leaderName = "";
        try {
//            Map<String, Object> resultMap = mapper.readValue(result.toString(), Map.class);
            leaderName = String.valueOf(resultMap.get("formTitle")).split(" ")[0];
            targetPeople = (List<Object>) resultMap.get("rows");
            List<Object> jsonObjects = (List<Object>) resultMap.get("results");
            for (Object obj : jsonObjects) {
//                Map<String, Object> objMap = mapper.readValue(String.valueOf(obj), Map.class);
                HashMap<String, Object> objMap = (HashMap<String, Object>) obj;
                if (String.valueOf(objMap.get("type")).equals("DATE")) {
                    attendDate =  LocalDate.parse(String.valueOf(objMap.get("response")), DateTimeFormatter.ISO_DATE);
                }
//                if (String.valueOf(objMap.get("type")).equals("SERVICE")) {
//                    serviceType =  String.valueOf(objMap.get("response"));
//                }
                if (String.valueOf(objMap.get("type")).equals("GRID")) {
                    attendCheck =  (List<Object>) objMap.get("response");
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        String leaderNameSeparator = "";
        int lastIdx = leaderName.length()-1;
        char chkChar = leaderName.charAt(lastIdx);
        if ((chkChar >= 65 && chkChar < 91) || (chkChar >= 97 && chkChar < 123)) { // A-Z || a-z
            leaderNameSeparator = leaderName.substring(lastIdx);
            leaderName = leaderName.substring(0, lastIdx);
        }

        User leaderInfo = userRepository.findByUserNameAndUserNameSeparator(leaderName, leaderNameSeparator).orElse(null);

        if (leaderInfo != null) {
            for (int j = 0 ; j < attendCheck.size() ; j++) {
                String userName = String.valueOf(String.valueOf(targetPeople.get(j)));
                String userNameSeparator = "";
                log.info("userName : " + userName);
                int alphaIdx = userName.length()-1;

                char chnm = userName.charAt(alphaIdx);
                log.info("userName char : " + chnm + " / " + (int) chnm);
                if ((chnm >= 65 && chnm < 91) || (chnm >= 97 && chnm < 123)) { // A-Z || a-z
                    userNameSeparator = userName.substring(alphaIdx);
                    userName = userName.substring(0, alphaIdx);
                }

                User user = userRepository.findByUserNameAndUserNameSeparator(userName, userNameSeparator).orElse(null);

                if (user == null) {
                    user = new User();
                    user.setUserName(userName);
                    user.setUserNameSeparator(userNameSeparator);
                    user.setParishCode(leaderInfo.getParishCode());
                    user.setAreaCode(leaderInfo.getAreaCode());
                    user.setPastoralCode(leaderInfo.getPastoralCode());

                    user = userRepository.save(user);
                }

                ServiceAttendance serviceAttendance = attendanceRepository.findByServiceDateAndServiceTypeAndUserId(attendDate, serviceType, user.getUserId()).orElse(null);
                if (serviceAttendance != null) {
                    // update
                    if (attendCheck.get(j) == null) {
                        attendanceRepository.delete(serviceAttendance);
                    } else if (String.valueOf(attendCheck.get(j)).equals("주일")) {
                        serviceAttendance.setIsOnline(false);
                        attendanceRepository.save(serviceAttendance);
                    } else {
                        serviceAttendance.setIsOnline(true);
                        attendanceRepository.save(serviceAttendance);
                    }
                } else {
                    // insert
                    if (attendCheck.get(j) != null) {
                        serviceAttendance = new ServiceAttendance();

                        serviceAttendance.setServiceType(serviceType);
                        serviceAttendance.setUserId(user.getUserId());
                        serviceAttendance.setServiceDate(attendDate);

                        if (String.valueOf(attendCheck.get(j)).equals("주일")) {
                            serviceAttendance.setIsOnline(false);
                        } else {
                            serviceAttendance.setIsOnline(true);
                        }
                        attendanceRepository.save(serviceAttendance);
                    }

                }
            }
        }

        log.info("result : " + resultMap);
        return 1L;
    }
}
