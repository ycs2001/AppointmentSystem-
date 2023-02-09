package com.example.AppointmentSystem.Controller;
import com.example.AppointmentSystem.Aop.LogAnnotation;
import com.example.AppointmentSystem.Entity.ActivityEntity;
import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.LogEntity;
import com.example.AppointmentSystem.Result;
import com.example.AppointmentSystem.Service.ActivityService;
import com.example.AppointmentSystem.Service.LogService;
import com.example.AppointmentSystem.Util.WebUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("activity")
public class ActivityController {

    private final ActivityService activityService;
//    @Autowired
//    private LogService logService;


    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    Result State = new Result();

    @RequestMapping("/queryLimit")
    public List<ActivityEntity> queryLimit(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return activityService.queryLimit(currentPage,pageSize);
    }

    @ApiOperation(value = "按活动名搜索数据")
    @PostMapping("/ByID")
    public List<ActivityEntity> id_card_number(@RequestBody ActivityEntity activityEntity){
        activityEntity.setActivity_name("%"+activityEntity.getActivity_name()+"%");
        return activityService.getByLike(activityEntity);
    }

    @RequestMapping("/getTotalNumber")
    public Integer getTotalNumber(){
        System.out.println(activityService.getTotalNumber());
        return activityService.getTotalNumber();
    }

    @PostMapping("/addActivity")
    @LogAnnotation(operation = "增加活动")
    public Result addActivity(@RequestBody ActivityEntity activityEntity){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好

//        System.out.println(session.getAttribute("admin_id"));
        //获取管理员用户信息
//        System.out.println(user);
        try{
            activityService.addActivity(activityEntity);
            State.setCode("200");
            State.setMessage("成功增加确定的可预约时空地点异界负责人员");
        }catch (Exception exception){
            State.setCode("500");
            State.setMessage("增加异常");
//            System.out.println(exception);
        }
        return State;

    }

    @PutMapping("/updateActivity")
    @LogAnnotation(operation = "修改活动")
    public Result updateActivity(@RequestBody ActivityEntity activityEntity){
        try{
            State.setCode("200");
            String message = activityService.updateActivity(activityEntity) == 1?"更新成功":"不存在该记录，更新失败";
            State.setMessage(message);


        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("更新异常");
        }
        return State;
    }

    @DeleteMapping("/deleteActivity")
    @LogAnnotation(operation = "删除活动")
    public Result  deleteActivity(@RequestParam(value = "activity_name")String activity_name)   {

        try{

            System.out.println(activity_name);
            State.setCode("200");
            String message = activityService.deleteActivity(activity_name) == 1?"删除成功":"不存在该记录，删除失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("删除异常");
        }
        return State;
    }


    public HttpServletRequest getHttpServletRequest(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }
}
