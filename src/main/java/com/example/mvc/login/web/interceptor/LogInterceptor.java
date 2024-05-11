//package com.example.mvc.login.web.interceptor;
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.UUID;
//
//@Log4j2
//public class LogInterceptor implements HandlerInterceptor {
//
//    public static final String LOG_ID = "logId";
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String requestURI = request.getRequestURI();
//        String uuid = UUID.randomUUID().toString();
//
//        request.setAttribute(LOG_ID, uuid);
//
//        if(handler instanceof HandlerMethod) {
//            // 호출할 컨트롤러 메서드의 모든 정보가 포함
//            HandlerMethod hm = (HandlerMethod) handler;
//        }
//
//        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("postHandle [{}]", modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        String requestURI = request.getRequestURI();
//        String logId = (String)request.getAttribute("logId");
//
//        log.info("RESPONSE [{}][{}][{}]", logId, requestURI, handler);
//
//        if(ex != null) {
//            log.error("afterCompletion error!!", ex);
//        }
//    }
//}
