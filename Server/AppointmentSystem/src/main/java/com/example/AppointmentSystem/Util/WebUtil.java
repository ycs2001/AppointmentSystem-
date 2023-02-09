package com.example.AppointmentSystem.Util;




import javax.servlet.http.HttpServletRequest;
import java.util.Map;



public class WebUtil {
    public Map<String, Object>   getUser(HttpServletRequest request){
        Map<String, Object> attribute=null;
        if(request!=null){
            Object user = request.getSession().getAttribute("admin_id");
            attribute = (Map<String, Object>) user;}
        return attribute;
    }

}
