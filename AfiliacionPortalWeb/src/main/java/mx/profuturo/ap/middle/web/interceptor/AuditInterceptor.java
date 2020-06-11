package mx.profuturo.ap.middle.web.interceptor;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.profuturo.ap.middle.web.annotation.ApplicationAudit;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuditInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(AuditInterceptor.class);
    private final DecimalFormat formatoMinutos = new DecimalFormat("###.## ");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            Method method = hm.getMethod();
            String methodName = method.getName();

            if (method.getDeclaringClass().isAnnotationPresent(Controller.class)) {
                if (method.isAnnotationPresent(ApplicationAudit.class)) {
                    request.setAttribute("startTime", System.currentTimeMillis());
                }
            } else if (method.getDeclaringClass().isAnnotationPresent(RestController.class)) {
                if (method.isAnnotationPresent(ApplicationAudit.class)) {
                    request.setAttribute("startTime", System.currentTimeMillis());
                }
            }
        }

        logger.info("[preHandle] {} {}" + getMatches(request.getRequestURI()) + getParameters(request));
        return true;
    }

    private String getMatches(String request) {
        if (request.startsWith("/AfiliacionPortal/"))
            return request;
        else
            return null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod hm = (HandlerMethod) handler;
        Method method = hm.getMethod();

        if (method.getDeclaringClass().isAnnotationPresent(Controller.class)) {
            if (method.isAnnotationPresent(ApplicationAudit.class)) {
                request.setAttribute("endTime", System.currentTimeMillis());
            }
        } else if (method.getDeclaringClass().isAnnotationPresent(RestController.class)) {
            if (method.isAnnotationPresent(ApplicationAudit.class)) {
                request.setAttribute("endTime", System.currentTimeMillis());
            }
        }
        logger.info("[postHandle] {} {}" + getMatches(request.getRequestURI()) + getParameters(request));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            Method method = hm.getMethod();

            if (null != method) {
                if (method.isAnnotationPresent(ApplicationAudit.class)) {
                    Object start = request.getAttribute("startTime");
                    Object end = request.getAttribute("endTime");

                    if (null != start && null != end) {
                        long startTime = (long) request.getAttribute("startTime");
                        long endTime = (long) request.getAttribute("endTime");
                        long executeTime = (endTime - startTime) / 1000;

                        String tFinal = "";

                        if (executeTime > 60) {
                            tFinal = formatoMinutos.format(executeTime / 60) + " min. (" + executeTime + " segundos)";
                        } else {
                            tFinal = executeTime + " segundos";
                        }

                        logger.info("Tiempo de respuesta a petici\u00f3n ::: " + method.getAnnotation(ApplicationAudit.class).value() + " " + tFinal);
                    }
                }
            }
        }
        if (ex != null)
            logger.error("[afterCompletion][Exception:{} {}" + ex + "]");
    }

    private String getParameters(HttpServletRequest request) {

        StringBuilder posted = new StringBuilder();
        Enumeration<?> e = request.getParameterNames();
        if (e != null) {
            posted.append("?");
        }
        String ipAddr = getRemoteAddr(request); // : ip;
        if (ipAddr != null && !ipAddr.equals("")) {
            posted.append("&_ip=" + ipAddr);
        }
        String auth = request.getHeader("Authorization");

        if ((auth == null) || !auth.startsWith("Basic ")) {
            final String userAgent = request.getHeader("User-Agent");
            posted.append("&User-Agent=" + userAgent);
        } else {
            posted.append("&Authorization =" + auth);
        }

        if (e != null)
            while (e.hasMoreElements()) {
                Object objectParam = e.nextElement();
                String param = (String) objectParam;
                String value = request.getParameter(param);
                posted.append("&" + param + "=" + value);
            }
        return posted.toString();
    }

    // get the source IP address of the HTTP request
    private String getRemoteAddr(HttpServletRequest request) {

        return request.getRemoteAddr();
    }
}
