//package com.wams.api.service.user;
//
//import com.wams.api.mapper.UserMapper;
//import com.wams.api.model.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//
//    public final UserMapper userMapper;
//
//    @Override
//    public User findByUserId(String userId) {
//        return userMapper.findByUserId(userId);
//    }
//
//    @Override
//    public Optional<User> findByUserIdOptional(String userId) {
////        Optional<User> user = Optional.ofNullable(userMapper.findByUserId(userId));
//        return Optional.ofNullable(userMapper.findByUserId(userId));
//    }
//}
//
