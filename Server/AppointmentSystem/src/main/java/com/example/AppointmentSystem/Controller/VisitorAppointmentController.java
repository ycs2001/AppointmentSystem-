package com.example.AppointmentSystem.Controller;
import com.example.AppointmentSystem.Entity.VisitorAppointmentEntity;
import com.example.AppointmentSystem.Service.VisitorAppointmentService;
import com.example.AppointmentSystem.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("visitorAppointment")
public class VisitorAppointmentController {
    private final VisitorAppointmentService visitorAppointmentService;


    public VisitorAppointmentController(VisitorAppointmentService visitorAppointmentService) {
        this.visitorAppointmentService = visitorAppointmentService;
    }
    Result State = new Result();

    @ApiOperation(value = "获取游客预约记录总数")
    @RequestMapping("/getTotalNumber")
    public Integer getTotalNumber(){
        System.out.println(visitorAppointmentService.getTotalNumber());
        return visitorAppointmentService.getTotalNumber();
    }

    @ApiOperation(value = "分页查寻预约数据")
    @RequestMapping("/queryLimit")
    public List<VisitorAppointmentEntity> getByLike(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return visitorAppointmentService.queryLimit(currentPage,pageSize);
    }

    @ApiOperation(value = "按身份证号搜索数据")
    @PostMapping("/ByID")
    public List<VisitorAppointmentEntity> id_card_number(@RequestBody VisitorAppointmentEntity VisitorAppointment){
        VisitorAppointment.setId_card_number("%"+VisitorAppointment.getId_card_number()+"%");
        return visitorAppointmentService.getByLike(VisitorAppointment);
    }

    @ApiOperation(value = "新增预约开放日期")
    @PostMapping("/addVisitorAppointment")


    public Result addVisitorAppointment(@RequestBody VisitorAppointmentEntity visitorAppointmentEntity){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好
        try{
            visitorAppointmentService.addVisitorAppointment(visitorAppointmentEntity);
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
    @PutMapping("/updateVisitorAppointment")
    public Result updateVisitorAppointment(@RequestBody VisitorAppointmentEntity visitorAppointmentEntity){
        try{
            State.setCode("200");
            String message = visitorAppointmentService.updateVisitorAppointment(visitorAppointmentEntity) == 1?"更新成功":"不存在该记录，更新失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("更新异常");
        }
        return State;
    }

    @ApiOperation(value = "删除该日预约信息")
    @DeleteMapping("/deleteVisitorAppointment")
    public Result  deleteVisitorAppointment(@RequestParam(value = "id_card_number")String id_card_number, @RequestParam(value = "visit_date") String visit_date)  {

        try{
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date_J = fmt.parse(visit_date);
            java.sql.Date date = new java.sql.Date(date_J.getTime());

//            System.out.println(id_card_number,visit_date);
            State.setCode("200");
            String message = visitorAppointmentService.deleteVisitorAppointment(id_card_number,date) == 1?"删除成功":"不存在该记录，删除失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("删除异常");
        }
        return State;
    }

}
