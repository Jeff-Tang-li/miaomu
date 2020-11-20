package com.miaomu.auth.controller;


import com.miaomu.auth.entity.MiaomuUser;
import com.miaomu.auth.service.impl.MiaomuUserServiceImpl;
import com.miaomu.common.entity.response.ResultResponse;
import com.miaomu.common.entity.vo.UserRequest;
import com.miaomu.common.enums.ResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jeff·Tang
 * @since 2020-11-19
 */
@RestController
@RequestMapping("/v1")
@Api(value = "用户模块",tags = "用户管理")
public class MiaomuUserController {
    @Autowired
    private MiaomuUserServiceImpl miaomuUserService;

    @PostMapping("user")
    @ApiOperation("添加")
    public ResultResponse addUser(@Valid @RequestBody UserRequest userRequest, BindingResult result) {
        if (result.hasErrors()) {
            return ResultResponse.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage(), null);
        }
        return miaomuUserService.addUser(userRequest);
    }

    @PutMapping("user")
    @ApiOperation("修改")
    public ResultResponse updateUser(@Valid @RequestBody UserRequest userRequest, BindingResult result) {
        if (result.hasErrors()) {
            return ResultResponse.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage(), null);
        }
        return miaomuUserService.updateUser(userRequest);
    }

    @DeleteMapping("user/{id}")
    @ApiOperation("删除")
    public ResultResponse deleteUser(@PathVariable Integer id) {
        return miaomuUserService.deleteUser(id);
    }

    @GetMapping("users")
    @ApiOperation("列表")
    public ResultResponse users(@RequestParam Integer currentPage, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false, defaultValue = "0") Integer sort, @RequestParam(required = false, defaultValue = "") String params) {
        return miaomuUserService.users(currentPage, pageSize, params, sort);
    }

    @GetMapping("user/{id}")
    @ApiOperation("详情")
    public ResultResponse user(@PathVariable Integer id) {
        return miaomuUserService.user(id);
    }

}
