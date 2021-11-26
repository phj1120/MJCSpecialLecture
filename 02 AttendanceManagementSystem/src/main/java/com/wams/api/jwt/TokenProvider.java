package com.wams.api.jwt;

//import com.wams.api.model.User;
import com.wams.api.mapper.UserMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class TokenProvider implements InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
    private static final String AUTHORITIES_KEY = "auth";
    private Key key;
    private final long tokenValidityInMilliseconds = 864000;
    @Value("${spring.jwt.secret}")
    private String secret;
    //    private final UserRepository userRepository;
//    public TokenProvider(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    private UserMapper userMapper;
    public TokenProvider(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

//    private UserService userService;
//
//    public TokenProvider(UserService userService) {
//        this.userService = userService;
//    }


    @Override
    //@Component로 빈이 생성이 되고 주입 받은 후
    // secret값을 BASE64.decode 해서 key 변수에 할당하기 위해
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    //    Authentication 객체에 포함되어 있는 권한 정보를 이용해 토큰 생성
    public String createToken(Authentication authentication) {


//        com.wams.api.model.User user = userMapper.findByUserId(authentication.getName());
        com.wams.api.model.User user = userMapper.findByUserId(authentication.getName());
//        이게 맞나 싶긴 한데 id랑 name 이랑 살짝 섞여서 코드 더러워짐, 더 생각해보면 깔끔하게 가능 할 듯
//        com.wams.api.model.entity.User user = userRepository.findByUserId(authentication.getName()).get();
        String userRole = user.getUserRole();
        String userId = user.getUserId();
        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInMilliseconds);

//        이런식으로 하면 payload에 원하는 메시지 추가 가능함
//        Map<String, Object> payloads = new HashMap<>();
//        payloads.put("username", authentication.getName());
//        payloads.put("auth", userRole);

        return Jwts.builder()
//                .setClaims(payloads)
//                .setSubject(authentication.getName())
                .setSubject(userId)
                .claim(AUTHORITIES_KEY, userRole)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(validity)
                .compact();
    }

    //    토큰의 정보를 이용해 Authentication 객체를 리턴하는
    public Authentication getAuthentication(String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            logger.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            logger.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            logger.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            logger.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }
}
