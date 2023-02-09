package com.example.AppointmentSystem.Controller;

import com.example.AppointmentSystem.Aop.LogAnnotation;
import com.example.AppointmentSystem.Entity.MuseumManagementEntity;
import com.example.AppointmentSystem.Result;
import com.example.AppointmentSystem.Service.MuseumManagementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("MuseumManagement")
public class MuseumManagementController {
    private final MuseumManagementService museumManagementService;


    public MuseumManagementController(MuseumManagementService museumManagementService) {
        this.museumManagementService = museumManagementService;
    }

    Result State = new Result();

    @RequestMapping("/queryLimit")
    public List<MuseumManagementEntity> queryLimit(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return museumManagementService.queryLimit(currentPage,pageSize);
    }

    @RequestMapping("/queryActivity")
    public List<MuseumManagementEntity> queryActivity(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return museumManagementService.queryActivity(currentPage,pageSize);
    }

    @RequestMapping("/queryEvent")
    public List<MuseumManagementEntity> queryEvent(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return museumManagementService.queryEvent(currentPage,pageSize);
    }





    @ApiOperation(value = "新增")
    @LogAnnotation(operation = "增加配置方案")
    @PostMapping("/addMuseumManagementList")
    public Result addMuseumManagementList(@RequestBody MuseumManagementEntity museumManagementEntity){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好


        try {
            museumManagementService.addMuseumManagementList(museumManagementEntity);
            State.setCode("200");
            State.setMessage("增加用户成功");
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("增加用户异常");
        }
        return State;
    }


    @ApiOperation(value = "搜索数据")
    @PostMapping("/ByID")
    public List<MuseumManagementEntity> id_card_number(@RequestBody MuseumManagementEntity museumManagementEntity){
        museumManagementEntity.setMuseum_id("%"+ museumManagementEntity.getMuseum_id()+"%");
        return museumManagementService.getByLike( museumManagementEntity);
    }






    @ApiOperation(value = "更新")
    @LogAnnotation(operation = "更新配置方案")
    @PutMapping("/updateMuseumManagementList")
    public Result updateMuseumManagementList(@RequestBody MuseumManagementEntity museumManagementEntity){
        //Mybatis的更新操作成功返回1，用户不存在返回0，失败则抛异常
        try{
            State.setCode("200");
            String message = museumManagementService.updateMuseumManagementList(museumManagementEntity) == 1?"更新成功":"不存在该记录，更新失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("更新异常");
        }
        return State;
    }

    @ApiOperation(value = "删除")
    @LogAnnotation(operation = "删除配置方案")
    @DeleteMapping("/deleteMuseumManagementList")
    public Result  deleteMuseumManagementList(@RequestParam(value = "museum_id")String museum_id)  {


        try{
            State.setCode("200");
            String message = museumManagementService.deleteMuseumManagementList(museum_id) == 1?"删除成功":"不存在该记录，删除失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("删除异常");
        }
        return State;
    }


}
