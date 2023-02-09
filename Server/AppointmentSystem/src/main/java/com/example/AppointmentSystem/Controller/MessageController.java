package com.example.AppointmentSystem.Controller;


import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.MessageEntity;
import com.example.AppointmentSystem.Result;
import com.example.AppointmentSystem.Service.MessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Message")
public class MessageController {

    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    Result State = new Result();

    @RequestMapping("/queryLimit")
    public List<MessageEntity> queryLimit(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return messageService.queryLimit(currentPage,pageSize);
    }




    @RequestMapping("/getTotalNumber")
    public Integer getTotalNumber(){
        System.out.println(messageService.getTotalNumber());
        return messageService.getTotalNumber();
    }

    @PostMapping("/addMessage")
    public Result addMessage(@RequestBody MessageEntity messageEntity){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好
        try{
            messageService.addMessage(messageEntity);
            State.setCode("200");
            State.setMessage("成功增加确定的可预约时空地点异界负责人员");
        }catch (Exception exception){
            State.setCode("500");
            State.setMessage("增加异常");
//            System.out.println(exception);
        }
        return State;

    }

    @PutMapping("/updateMessage")
    public Result updateMessage(@RequestBody MessageEntity messageEntity){
        try{
            State.setCode("200");
            String message = messageService.updateMessage(messageEntity) == 1?"更新成功":"不存在该记录，更新失败";
            State.setMessage(message);
        }catch (Exception exception){
//            System.out.println(exception);
            State.setCode("500");
            State.setMessage("更新异常");
        }
        return State;
    }

    @DeleteMapping("/deleteMessage")
    public Result  deleteMessage(@RequestParam(value = "activity_name") String activity_name)  {

        try{

            System.out.println(activity_name);
            State.setCode("200");
            String message = messageService.deleteMessage(activity_name) == 1?"删除成功":"不存在该记录，删除失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("删除异常");
        }
        return State;
    }

}
