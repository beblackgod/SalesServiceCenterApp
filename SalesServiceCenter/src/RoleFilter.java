
import main.java.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "RoleFilter")
public class RoleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

       /* HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        User user = (User) req.getSession().getAttribute("user");
        if(user!=null) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("./auth");
        }
        */
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
