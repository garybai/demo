package com.example.springsecuritydynamicdemo.config;

import com.example.springsecuritydynamicdemo.entity.AuthorityPO;
import com.example.springsecuritydynamicdemo.entity.RolePO;
import com.example.springsecuritydynamicdemo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author Gary
 * @className MyFilter
 * @description TODO
 * @date 2019/11/23 13:19
 **/
@Component
public class MyFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private AuthorityService authorityService;

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<AuthorityPO> allAuthority = authorityService.getAllAuthority();
        for (AuthorityPO authorityPO : allAuthority) {
            if(pathMatcher.match(authorityPO.getResource(), requestUrl)){
                List<RolePO> roles = authorityPO.getRoles();
                String[] rolesStr = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    rolesStr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(rolesStr);
            }
        }
        return SecurityConfig.createList("ROLE_login");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
