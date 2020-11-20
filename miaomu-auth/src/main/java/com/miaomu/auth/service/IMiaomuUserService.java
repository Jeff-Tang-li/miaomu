package com.miaomu.auth.service;

import com.miaomu.auth.entity.MiaomuUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.miaomu.common.entity.response.ResultResponse;
import com.miaomu.common.entity.vo.UserRequest;
import com.miaomu.common.enums.ResponseEnum;

import java.util.List;

/**
 * <p>auth
 * 服务类
 * </p>
 *
 * @author jeff·Tang
 * @since 2020-11-19
 */
public interface IMiaomuUserService extends IService<MiaomuUser> {
    /**
     * 添加用户
     *
     * @param userRequest
     * @return
     */
    ResultResponse addUser(UserRequest userRequest);

    /**
     * 更新用户
     *
     * @param userRequest
     * @return
     */
    ResultResponse updateUser(UserRequest userRequest);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    ResultResponse deleteUser(Integer id);

    ResultResponse users(Integer currentPage, Integer pageSize, String params, Integer sort);

    ResultResponse user(Integer id);
}
