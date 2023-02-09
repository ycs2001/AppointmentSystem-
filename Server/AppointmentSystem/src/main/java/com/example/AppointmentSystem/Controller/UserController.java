package com.example.AppointmentSystem.Controller;
import com.example.AppointmentSystem.LogResult;
import io.swagger.annotations.*;
import com.example.AppointmentSystem.Entity.UserEntity;
import com.example.AppointmentSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.AppointmentSystem.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    HttpServletRequest request;

    String message = "";
    Result State = new Result();
    LogResult logResult = new LogResult();


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = -1, message = "Fail")
    })

    @ApiOperation(value = "分页查寻管理员数据")
    @RequestMapping("/queryLimit")
    public List<UserEntity> queryLimit(@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize){

        return userService.queryLimit(currentPage,pageSize);
    }

    @ApiOperation(value = "新增管理员")
    @PostMapping("/addUser")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "admin_id", value = "admin_id", dataType = "string",paramType = "body", required = true),
            @ApiImplicitParam(name = "admin_password", value = "admin_password", dataType = "string",paramType = "body", required = true),
            @ApiImplicitParam(name = "admin_user_name", value = "admin_user_name", dataType = "string",paramType = "body",  required = true),
            @ApiImplicitParam(name = "admin_phone_number", value = "admin_phone_number", dataType = "string", paramType = "body", required = true),
            @ApiImplicitParam(name = "admin_email", value = "admin_email", dataType = "string", paramType = "body", required = true)
    })
    public Result addUer(@RequestBody UserEntity user){
        //用Mybatis执行insert语句的时候，插入成功会返回1，不成功则会抛出异常，捕获一下异常就好


        try {
            userService.addUser(user);
            State.setCode("200");
            State.setMessage("增加用户成功");
        }catch (Exception exception){
            State.setCode("500");
            State.setMessage("增加用户异常");
        }
        return State;
    }

    @ApiOperation(value = "更新管理员")
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody UserEntity user){
        //Mybatis的更新操作成功返回1，用户不存在返回0，失败则抛异常

        try {
            message = userService.updateUser(user) == 1?"更新用户成功":"用户不存在，更新失败";
        }catch (Exception exception){
            message = "更新异常";
        }
        return message;
    }

    @ApiOperation(value = "删除管理员")
    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody UserEntity user){
        //Mybatis的删除操作和更新返回值一样，成功返回1，用户不存在返回0，失败则抛异常
        try {
            message = userService.deleteUser(user) == 1?"删除用户成功":"用户不存在，删除失败";
        }catch (Exception exception){
            message = "删除异常";
        }
        return message;
    }

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "admin_user_name", value = "好好学习", dataType = "string",paramType = "body", required = true),
            @ApiImplicitParam(name = "admin_password", value = "123456", dataType = "string",paramType = "body", required = true),
    })
    public LogResult login(@RequestBody UserEntity user){
        HttpSession session=request.getSession();
        String User = userService.login(user);
        session.setAttribute("admin_id",User);
//        System.out.println(session.getAttribute("admin_id"));
        if(User!=null){
            logResult.setCode("200");
            logResult.setAdmin_id(User);
            logResult.setToken(true);
            return logResult;
        }else {
//            System.out.println(userEntity.getAdmin_id());
            logResult.setCode("500");
            logResult.setAdmin_id("");
            logResult.setToken(false);
            return logResult;
        }
    }




}
