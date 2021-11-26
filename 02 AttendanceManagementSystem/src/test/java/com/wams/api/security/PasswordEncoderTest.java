//package com.wams.api.security;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class PasswordEncoderTest {
//
////    @Autowired
////    private UserService userService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Test
//    @DisplayName("패스워드 암호화 테스트")
//    void passwordEncode() {
//        // given
//        String rawPassword = "1234";
//
//        // when
//        String encodedPassword = passwordEncoder.encode(rawPassword);
//        System.out.println("encodedPassword = " + encodedPassword);
//        // then
//        assertAll(
//                () -> assertNotEquals(rawPassword, encodedPassword),
//                () -> assertTrue(passwordEncoder.matches(rawPassword, encodedPassword))
//        );
////        System.out.println("encodedPassword = " + encodedPassword);
////        overseer
////        $2a$10$S0BTZc2fxNa3i.dfXux5Hu10a.rRXEdQOI79dVkmjn56BZnkLPe72
//
////        candidate
////        $2a$10$PR2YsOUfFZqLjw7znsuBseNbX7LpnhDlSH53rMP4yEgFiTbcwWBBW
//
//
//
//    }
//}
