package cn.knet.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserPermFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
        Subject subject = getSubject(request, response);
        if (subject.isAuthenticated()) {
            return true;
        }
        return false;
    }
}