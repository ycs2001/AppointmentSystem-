package com.example.AppointmentSystem.Controller;
import com.example.AppointmentSystem.Aop.LogAnnotation;
import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.VisitEntity;
import com.example.AppointmentSystem.Result;
import com.example.AppointmentSystem.Service.VisitService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("visit")
public class VisitController {
    private final VisitService visitService;

    Result State = new Result();

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @ApiOperation(value = "获取预约记录总数")
    @RequestMapping("/getTotalNumber")
    public Integer getTotalNumber(){
        System.out.println(visitService.getTotalNumber());
        return visitService.getTotalNumber();
    }



    @ApiOperation(value = "分页查寻预约数据")
    @RequestMapping("/queryLimit")
    public List<VisitEntity> queryLimit(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return visitService.queryLimit(currentPage,pageSize);
    }

    @PostMapping("/queryDate")
    public VisitEntity queryDate(@RequestBody VisitEntity visitEntity) throws ParseException {

//        String S = visitEntity.getOpen_date().toString();
//        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
//        Date date_J = fmt.parse(S);
//        java.sql.Date date = new java.sql.Date(date_J.getTime());
        System.out.println(visitEntity.getOpen_date());



        return  visitService.queryDate(visitEntity.getOpen_date());
    }

    @PostMapping("/queryNumber")
    public VisitEntity queryNumber(@RequestBody VisitEntity visitEntity) throws ParseException {

//        String S = visitEntity.getOpen_date().toString();
//        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
//        Date date_J = fmt.parse(S);
//        java.sql.Date date = new java.sql.Date(date_J.getTime());
        System.out.println(visitEntity.getOpen_date());



        return  visitService.queryNumber(visitEntity.getOpen_date());
    }






    @ApiOperation(value = "按日期搜索数据")
    @PostMapping("/ByID")
    public List<VisitEntity> id_card_number(@RequestBody VisitEntity visitEntity){

//        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
//        Date date_J = fmt.parse(visitEntity.getOpen_date());
//        java.sql.Date date = new java.sql.Date(date_J.getTime());
        return visitService.getByLike(visitEntity);
    }

    @ApiOperation(value = "新增预约开放日期")
    @LogAnnotation(operation = "新增预约配置")
    @PostMapping("/addVisit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "open_location", value = "open_location", dataType = "string",paramType = "body", required = true),
            @ApiImplicitParam(name = "open_start_time", value = "open_start_time", dataType = "Time",paramType = "body", required = true),
            @ApiImplicitParam(name = "open_end_time", value = "open_end_time", dataType = "Time",paramType = "body",  required = true),
            @ApiImplicitParam(name = "open_people_number", value = "open_people_number", dataType = "int", paramType = "body", required = true),
            @ApiImplicitParam(name = "open_staff_in_charge", value = "open_staff_in_charge", dataType = "string", paramType = "body", required = true),
            @ApiImplicitParam(name = "open_date", value = "open_date", dataType = "Date",paramType = "body", required = true),
    })

    public Result addVisit(@RequestBody VisitEntity visit){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好
        try{
            visitService.addVisit(visit);
            State.setCode("200");
            State.setMessage("成功增加确定的可预约时空地点异界负责人员");
        }catch (Exception exception){
            State.setCode("500");
            State.setMessage("增加异常");
            System.out.println(exception);
        }
        return State;

    }

    @ApiOperation(value = "更新预约配置")
    @LogAnnotation(operation = "新增预约配置")
    @PutMapping("/updateVisit")
    public Result updateVisit(@RequestBody VisitEntity visit){
        try{
            State.setCode("200");
            String message = visitService.updateVisit(visit) == 1?"更新成功":"不存在该记录，更新失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("更新异常");
        }
        return State;
    }

    @ApiOperation(value = "删除该日预约信息")
    @LogAnnotation(operation = "删除该日预约信息")
    @DeleteMapping("/deleteVisit")
    public Result  deleteVisit(@RequestParam(value = "open_date")String date_S)  {


        try{
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            Date date_J = fmt.parse(date_S);
            java.sql.Date date = new java.sql.Date(date_J.getTime());

            System.out.println(date);
            State.setCode("200");
            String message = visitService.deleteVisit(date) == 1?"删除成功":"不存在该记录，删除失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("删除异常");
        }
        return State;
    }




}
