package com.example.AppointmentSystem.Controller;

import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.VenueEntity;
import com.example.AppointmentSystem.Result;
import com.example.AppointmentSystem.Service.VenueService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("Venue")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }
    Result State = new Result();

    @RequestMapping("/queryLimit")
    public List<VenueEntity> queryLimit(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return venueService.queryLimit(currentPage,pageSize);
    }

    @RequestMapping("/queryVenue")
    public List<VenueEntity> queryVenue(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize){
        return venueService.queryVenue(currentPage,pageSize);
    }



    @PostMapping("/getByLike")
    public List<VenueEntity> getByLike(@RequestBody VenueEntity venueEntity){
        venueEntity.setVenue_name("%"+venueEntity.getVenue_name()+"%");
        return venueService.getByLike(venueEntity);
    }

    @RequestMapping("/getTotalNumber")
    public Integer getTotalNumber(){
        System.out.println(venueService.getTotalNumber());
        return venueService.getTotalNumber();
    }

    @PostMapping("/addVenue")
    public Result addVenue(@RequestBody VenueEntity venueEntity){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好
        System.out.println(venueEntity.getVenue_picture());
        try{
            venueService.addVenue(venueEntity);
            State.setCode("200");
            State.setMessage("成功增加确定的可预约时空地点异界负责人员");
        }catch (Exception exception){
            State.setCode("500");
            State.setMessage("增加异常");
//            System.out.println(exception);
        }
        return State;

    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file,@RequestParam("venue_name") String venue_name){
        VenueEntity venueEntity = new VenueEntity();
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            State.setCode("200");
//            venueEntity.setVenue_name("梦回大宋");
            byte[] data = file.getBytes();
//            System.out.println(data);
            venueEntity.setVenue_name(venue_name);
            venueEntity.setVenue_picture(data);
            String message = venueService.upload(venueEntity) == 1?"更新成功":"不存在该记录，更新失败";
            State.setMessage(message);
        } catch (IOException e) {
            State.setCode("500");
            State.setMessage("更新异常");
            e.printStackTrace();
        }
        return State;
    }


    @PutMapping("/updateVenue")
    public Result updateBlackList(@RequestBody VenueEntity venueEntity){
        try{
            System.out.println(venueEntity.getVenue_picture());
            State.setCode("200");
            String message = venueService.updateVenue(venueEntity) == 1?"更新成功":"不存在该记录，更新失败";
            State.setMessage(message);
        }catch (Exception exception){
//            System.out.println(exception);
            State.setCode("500");
            State.setMessage("更新异常");
        }
        return State;
    }

    @DeleteMapping("/deleteVenue")
    public Result  deleteVenue(@RequestParam(value = "venue_name") String venue_name)  {

        try{

            System.out.println(venue_name);
            State.setCode("200");
            String message = venueService.deleteVenue(venue_name) == 1?"删除成功":"不存在该记录，删除失败";
            State.setMessage(message);
        }catch (Exception exception){
            System.out.println(exception);
            State.setCode("500");
            State.setMessage("删除异常");
        }
        return State;
    }


}
