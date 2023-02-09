package com.example.AppointmentSystem.Aop;

import com.example.AppointmentSystem.Entity.LogEntity;
import com.example.AppointmentSystem.Service.LogService;
import com.example.AppointmentSystem.Util.WebUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

@Component
@Aspect
public class LogAspect {

    @Autowired
    LogService logService;



 @Pointcut("@annotation(com.example.AppointmentSystem.Aop.LogAnnotation)")
    public void log(){

 }

 @Around("log()")
 public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

     //        1.获取方法签名对象
     MethodSignature signature = (MethodSignature) joinPoint.getSignature();

//        2.获取方法对象
     Method method = signature.getMethod();

//        3.获取方法上的注解 LogAnnotation为自定义注解类
     LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);


//     HttpServletRequest httpServletRequest = getHttpServletRequest();
//     //获取管理员用户信息
//     WebUtil webUtil = new WebUtil();
//     Map<String, Object> user = webUtil.getUser(httpServletRequest);

//     String admin_id = user.get("admin_id").toString();

     HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
     HttpSession session = request.getSession();
     String admin_id = session.getAttribute("admin_id").toString();

     String operation = annotation.operation();
     String creator = admin_id;

     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     String operation_time = sdf.format(new Date());


     DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
     Date date_J = null;
     try {
         date_J = fmt.parse(operation_time);
     } catch (ParseException e) {
         e.printStackTrace();
     }
     java.sql.Date date = new java.sql.Date(date_J.getTime());

     LogEntity logEntity = new LogEntity(operation,creator,date);

     Object proceed = joinPoint.proceed();
//     logEntity.setOperation(operation);
//     logEntity.setCreator(creator);
//     logEntity.setOperation_time(date);

     logService.addLog(logEntity);
     return proceed;

 }


    public HttpServletRequest getHttpServletRequest(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }


}
