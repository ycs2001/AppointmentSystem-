package com.example.AppointmentSystem.Controller;

import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.LogEntity;
import com.example.AppointmentSystem.Service.LogService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("log")
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @RequestMapping("/queryLimit")
    public List<LogEntity> queryLimit(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return logService.queryLimit(currentPage,pageSize);
    }

    @RequestMapping("/getByDate")
    public List<LogEntity> getByDate(@RequestBody LogEntity logEntity){
        return logService.getByDate(logEntity);
    }
    @RequestMapping("/getByCreator")
    public List<LogEntity> getByCreator(@RequestBody LogEntity logEntity){
        return logService.getByCreator(logEntity);
    }
    @RequestMapping("/getByOperation")
    public List<LogEntity> getByOperation(@RequestBody LogEntity logEntity){
        return logService.getByOperation(logEntity);
    }



    @RequestMapping("/getTotalNumber")
    public Integer getTotalNumber(){
        System.out.println(logService.getTotalNumber());
        return logService.getTotalNumber();
    }

}
