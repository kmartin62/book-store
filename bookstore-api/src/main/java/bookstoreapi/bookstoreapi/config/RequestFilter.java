package bookstoreapi.bookstoreapi.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by @kmartin62
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter implements Filter{

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain){
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-auth-token");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Credentials", "true");

        if(!(req.getMethod().equalsIgnoreCase("OPTIONS"))) {
            try{
                filterChain.doFilter(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            res.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE");
            res.setHeader("Access-Control-Max-Age", "3600");
            res.setHeader("Access-Control-Allow-Headers", "authorization, content-type, x-auth-token" +
                    "access-control-request-headers, access-control-request-method, accept, origin, authorization, " +
                    "x-requested-with");
            res.setStatus(HttpServletResponse.SC_OK);
        }
    }

    public void init(FilterConfig filterConfig){}

    public void destroy(){}

}
