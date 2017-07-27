package application.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StatisticsHandlerInterceptor implements HandlerInterceptor {
    private final static String REFERER="referer";
    private final DateFormat formater = new SimpleDateFormat("HH:mm:ss_MM-dd-yyyy");

    @Autowired
    HttpSender httpSender;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        StatisticDataHolder holder = new StatisticDataHolder();
//        holder.setRefererPath(request.getHeader(REFERER));
//        holder.setSessionCreated(formater.format(new Date(request.getSession().getCreationTime())));
//        holder.setTargetPath(request.getRequestURI());
        String userName;
        try{
            userName = request.getUserPrincipal().getName();
        } catch (NullPointerException e){
            userName="NULL USER";
        }
//        holder.setUserName(userName);
//        System.out.println("SENDING in HI: "+holder);
//        httpSender.sendInterceptorData(holder);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
