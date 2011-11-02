package lib;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author namvt
 */
public class ServiceFinder {

    public static ApplicationContext getContext(HttpServletRequest httpRequest) {
    	return WebApplicationContextUtils.getRequiredWebApplicationContext(
                httpRequest.getSession().getServletContext());
    }
}
