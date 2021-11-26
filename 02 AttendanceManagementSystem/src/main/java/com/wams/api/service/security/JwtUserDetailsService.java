// UserDetailsService를 구현
package com.wams.api.service.security;

//import com.wams.api.mapper.UserMapper;
//import com.wams.api.model.entity.User;
//import com.wams.api.repositroy.UserRepository;

import com.wams.api.mapper.UserMapper;
import com.wams.api.model.User;
//import com.wams.api.repositroy.UserRepository;
//import com.wams.api.model.entity.User;
//import com.wams.api.repositroy.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

// 자동으로 의존관계를 주입주나 봄
// userDetailsService를 어디서 쓰는지는 잘..
//@Component("userDetailsService")
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

//   private final UserRepository userRepository;
//   private final UserService userService;

   private final UserMapper userMapper;

   public UserDetails loadUserByUsername(final String userId) {

      return findByUserIdOptional(userId)
              .map(user -> createUser(user))
              .orElseThrow(() -> new UsernameNotFoundException(userId + " -> 데이터베이스에서 찾을 수 없습니다."));

//      System.out.println(userRepository.findByUserId(userId));
//      return userRepository.findByUserId(userId)
//              .map(user -> createUser(user))
//              .orElseThrow(() -> new UsernameNotFoundException(userId + " -> 데이터베이스에서 찾을 수 없습니다."));
   }

   public Optional<User> findByUserIdOptional(String userId) {
      Optional<User> user = Optional.ofNullable(userMapper.findByUserId(userId));
      return Optional.ofNullable(userMapper.findByUserId(userId));
   }

   //   바로 위에서 호출 됨
   //   유저가 활성화 상태라면 유저의 권한정보 이름, 패스워드를 가지고 유저 객체 리턴
   private org.springframework.security.core.userdetails.User createUser(User user) {
//      System.out.println("JwtUserDetailsService.createUser 실행");
      List<GrantedAuthority> grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole()));
      return new org.springframework.security.core.userdetails.User(user.getUserId(),
              user.getUserPassword(),
              grantedAuthorities);
   }
}

