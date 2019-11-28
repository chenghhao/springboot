package cn.knet.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dcx
 * @create 2019-11-25 10:29
 */
@Configuration
public class ShiroConfig {
    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager manager,@Qualifier("userPermFilter") UserPermFilter userPermFilter) {
        logger.info("securityManager。。。。。");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(manager);
        Map<String, Filter> filterMaps = new HashMap<>();
        filterMaps.put("userPermFilter", userPermFilter);
        shiroFilterFactoryBean.setFilters(filterMaps);
        Map<String, String> filterMap = new HashMap<>();
        filterMap.put("/", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/ui/**", "anon");
        filterMap.put("/asset/**", "anon");
        filterMap.put("/**", "authc");
        //需要设置权限时
        filterMap.put("/**","userPermFilter");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
        shiroFilterFactoryBean.setLoginUrl("/login");
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getManager(@Qualifier("realm") MyRealm realm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    @Bean(name = "realm")
    public MyRealm getMyRealm() {
        return new MyRealm();
    }

    @Bean(name="userPermFilter")
    public UserPermFilter getUserPermFilter(){
        return new UserPermFilter();
    }
}
