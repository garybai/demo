package com.example.springsecuritywebfluxdemo.util;

import cn.hutool.core.date.DateUtil;
import com.example.springsecuritywebfluxdemo.model.Authority;
import com.example.springsecuritywebfluxdemo.model.UserPrincipal;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * JWT 工具类
 * @author Gary
 */
//@EnableConfigurationProperties(JwtConfig.class)
@Configuration
@Slf4j
public class JwtUtil {

    /**
     * 生成 JWT
     * @param id:
     * @param subject:
     * @param roles:
     * @param authorities:
     * @return java.lang.String
     * @author: Gary
     * @date: 2019/12/16 17:18
     */
    public String createJWT(Long id, String subject, List<String> roles, Collection<? extends GrantedAuthority> authorities) {
        Date now = new Date();
        JwtBuilder builder = Jwts.builder()
                .setId(id.toString())
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, "thisispassword");

        // 设置过期时间
        long ttl = 600000L;
        if (ttl > 0) {
            builder.setExpiration(DateUtil.offsetMillisecond(now, (int) ttl));
        }

        return builder.compact();
    }

    /**
     * 创建JWT
     *
     * @param authentication 用户认证信息
     * @return JWT
     */
    public String createJWT(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return createJWT(userPrincipal.getId(), userPrincipal.getUsername(), userPrincipal.getRoles(), userPrincipal.getAuthorities());
    }

    /**
     * 解析JWT
     *
     * @param jwt JWT
     * @return {@link Claims}
     */
    public Claims parseJWT(String jwt) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("thisispassword")
                    .parseClaimsJws(jwt)
                    .getBody();

            String username = claims.getSubject();

            // 校验redis中的JWT是否与当前的一致，不一致则代表用户已注销/用户在不同设备登录，均代表JWT已过期

            return claims;
        } catch (ExpiredJwtException e) {
            log.error("Token 已过期");
            throw new SecurityException("Token 已过期");
        } catch (UnsupportedJwtException e) {
            log.error("不支持的 Token");
            throw new SecurityException("不支持的 Token");
        } catch (MalformedJwtException e) {
            log.error("Token 无效");
            throw new SecurityException("Token 无效");
        } catch (SignatureException e) {
            log.error("无效的 Token 签名");
            throw new SecurityException("无效的 Token 签名");
        } catch (IllegalArgumentException e) {
            log.error("Token 参数不存在");
            throw new SecurityException("Token 参数不存在");
        }
    }

    /**
     * 根据 jwt 获取用户名
     *
     * @param jwt JWT
     * @return 用户名
     */
    public String getUsernameFromJWT(String jwt) {
        Claims claims = parseJWT(jwt);
        return claims.getSubject();
    }

    public Long getUserIdFromJWT(String jwt) {
        Claims claims = parseJWT(jwt);
        return Long.valueOf(claims.getId());
    }

    public List<Authority> getAuthoritiesFromJWT(String jwt) {
        Claims claims = parseJWT(jwt);
        return (List<Authority>) claims.get("authorities");
    }

    /**
     * 从 request 的 header 中获取 JWT
     *
     * @param request 请求
     * @return JWT
     */
//    public String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (StrUtil.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }

}
