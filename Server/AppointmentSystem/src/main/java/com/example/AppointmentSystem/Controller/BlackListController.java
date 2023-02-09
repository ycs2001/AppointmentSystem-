package com.example.AppointmentSystem.Controller;

import com.example.AppointmentSystem.Entity.ActivityEntity;
import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.VisitorAppointmentEntity;
import com.example.AppointmentSystem.Result;
import com.example.AppointmentSystem.Service.BlackListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("BlackList")
public class BlackListController {
    private final BlackListService blackListService;


    public BlackListController(BlackListService blackListService) {
        this.blackListService = blackListService;
    }

    Result State = new Result();

    @RequestMapping("/queryLimit")
    public List<BlackListEntity> queryLimit(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return blackListService.queryLimit(currentPage,pageSize);
    }

    @ApiOperation(value = "按身份证号搜索数据")
    @PostMapping("/ByID")
    public List<BlackListEntity> id_card_number(@RequestBody BlackListEntity blackListEntity){
        blackListEntity.setID_card_number("%"+blackListEntity.getID_card_number()+"%");
        return blackListService.getByLike( blackListEntity);
    }

    @RequestMapping("/getTotalNumber")
    public Integer getTotalNumber(){
        System.out.println(blackListService.getTotalNumber());
        return blackListService.getTotalNumber();
    }

    @PostMapping("/addBlackList")
    public Result addBlackList(@RequestBody BlackListEntity blackListEntity){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好
        try{
            blackListService.addBlackList(blackListEntity);
            State.setCode("200");
            State.setMessage("成功增加确定的可预约时空地点异界负责人员");
        }catch (Exception exception){
            State.setCode("500");
            State.setMessage("增加异常");
//            System.out.println(exception);
        }
        return State;

    }

    @PutMapping("/updateBlackList")
    public Result updateBlackList(@RequestBody BlackListEntity blackListEntity){
        try{
            State.setCode("200");
            String message = blackListService.updateBlackList(blackListEntity) == 1?"更新成功":"不存在该记录，更新失败";
            State.setMessage(message);
        }catch (Exception exception){
//            System.out.println(exception);
            State.setCode("500");
            State.setMessage("更新异常");
        }
        return State;
    }

    @DeleteMapping("/deleteBlackList")
    public Result  deleteActivity(@RequestParam(value = "id_card_number") String id_card_number)  {

        try{

            System.out.println(id_card_number);
            State.setCode("200");
            String message = blackListService.deleteBlackList(id_card_number) == 1?"删除成功":"不存在该记录，删除失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("删除异常");
        }
        return State;
    }



}
