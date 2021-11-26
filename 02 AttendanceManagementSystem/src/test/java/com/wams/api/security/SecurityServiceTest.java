package com.wams.api.security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SecurityServiceTest {

//    SecurityService securityService = new SecurityService();

//    @Test
//    @DisplayName("토큰생성 성공")
//    void createTokentest() {
//        //given
//        String subject = "test";
//        long expTime = 10000L;
//
//        //when
//        String token = securityService.createToken(subject, expTime);
//
//        //then
//        assertThat(securityService.validateToken(token)).isTrue();
//    }
//
//    @Test
//    @DisplayName("토큰생성 만료시간 짧음")
//    void createTokenShortExpTimetest() {
//        //given
//        String subject = "test";
//        long expTime = -1L;
//
//        //when
//        assertThrows(RuntimeException.class,
//                () -> securityService.createToken(subject, expTime));
//
//        //then
//    }
//
//    @Test
//    @DisplayName("subject 가져오기")
//    void getSubjecttest() {
//        //given
//        String subject = "test";
//        long expTime = 10000L;
//
//        //when
//        String token = securityService.createToken(subject, expTime);
//        String getsubject = securityService.getSubject(token);
//
//        //then
//        assertThat(getsubject).isEqualTo("test");
//    }
}