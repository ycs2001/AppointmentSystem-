package com.example.AppointmentSystem.Controller;


import com.example.AppointmentSystem.Entity.ActivityAppointmentEntity;
import com.example.AppointmentSystem.Entity.VisitorAppointmentEntity;
import com.example.AppointmentSystem.Result;
import com.example.AppointmentSystem.Service.ActivityAppointmentService;
import com.example.AppointmentSystem.Service.VisitorAppointmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("activityAppointment")
public class ActivityAppointmentController {
    private final ActivityAppointmentService activityAppointmentService;

    public ActivityAppointmentController(ActivityAppointmentService activityAppointmentService) {
        this.activityAppointmentService = activityAppointmentService;
    }
    Result State = new Result();

    @ApiOperation(value = "获取活动预约记录总数")
    @RequestMapping("/getTotalNumber")
    public Integer getTotalNumber(){
        System.out.println(activityAppointmentService.getTotalNumber());
        return activityAppointmentService.getTotalNumber();
    }

    @ApiOperation(value = "分页查寻预约数据")
    @RequestMapping("/queryLimit")
    public List<ActivityAppointmentEntity> getByLike(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return activityAppointmentService.queryLimit(currentPage,pageSize);
    }

    @ApiOperation(value = "按活动名搜索数据")
    @PostMapping("/ByID")
    public List<ActivityAppointmentEntity> activity_name(@RequestBody ActivityAppointmentEntity ActivityAppointment){
        ActivityAppointment.setVisitor_name("%"+ActivityAppointment.getVisitor_name()+"%");
        return activityAppointmentService.getByLike(ActivityAppointment);
    }

    @ApiOperation(value = "新增预约活动")
    @PostMapping("/addActivityAppointment")

    public Result addActivityAppointment(@RequestBody ActivityAppointmentEntity activityAppointmentEntity){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好
        try{
            activityAppointmentService.addActivityAppointment(activityAppointmentEntity);
            State.setCode("200");
            State.setMessage("成功增加确定的可预约时空地点异界负责人员");
        }catch (Exception exception){
            State.setCode("500");
            State.setMessage("增加异常");
            System.out.println(exception);
        }
        return State;

    }

    @ApiOperation(value = "更新预约记录")
    @PutMapping("/updateActivityAppointment")
    public Result updateVisitorAppointment(@RequestBody ActivityAppointmentEntity activityAppointmentEntity){
        try{
            State.setCode("200");
            String message = activityAppointmentService.updateActivityAppointment(activityAppointmentEntity) == 1?"更新成功":"不存在该记录，更新失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("更新异常");
        }
        return State;
    }

    @ApiOperation(value = "删除该日预约信息")
    @DeleteMapping("/deleteActivityAppointment")
    public Result  deleteActivityAppointment(@RequestParam(value = "visitor_name")String activity_name, @RequestParam(value = "visit_date") String visit_date)  {

        try{
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date_J = fmt.parse(visit_date);
            java.sql.Date date = new java.sql.Date(date_J.getTime());

//            System.out.println(id_card_number,visit_date);
            State.setCode("200");
            String message = activityAppointmentService.deleteActivityAppointment(activity_name) == 1?"删除成功":"不存在该记录，删除失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("删除异常");
        }
        return State;
    }
}
