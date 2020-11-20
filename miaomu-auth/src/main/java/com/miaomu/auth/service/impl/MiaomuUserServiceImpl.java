package com.miaomu.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miaomu.auth.entity.MiaomuUser;
import com.miaomu.auth.mapper.MiaomuUserMapper;
import com.miaomu.auth.service.IMiaomuUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaomu.common.entity.response.ResultResponse;
import com.miaomu.common.entity.vo.UserRequest;
import com.miaomu.common.utils.AsserUtils;
import com.miaomu.common.utils.MD5Util;
import com.miaomu.common.utils.PhoneUtil;
import com.miaomu.common.utils.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jeff·Tang
 * @since 2020-11-19
 */
@Service
public class MiaomuUserServiceImpl extends ServiceImpl<MiaomuUserMapper, MiaomuUser> implements IMiaomuUserService {

    /**
     * 用户添加
     *
     * @param userRequest
     * @return
     */
    @Override
    public ResultResponse addUser(UserRequest userRequest) {
        AsserUtils.isTrue(!PhoneUtil.isMobile(userRequest.getUserPhone()), "号码格式不正确");
        MiaomuUser one = this.getOne(new QueryWrapper<MiaomuUser>().lambda()
                .eq(MiaomuUser::getUserAccount, userRequest.getUserAccount())
                .eq(MiaomuUser::getIsValued, true));
        AsserUtils.isTrue(one != null, "注册的账号存在");
        one = new MiaomuUser();
        BeanUtils.copyProperties(userRequest, one);
        one.setCreateTime(LocalDateTime.now(ZoneOffset.UTC));
        one.setUserSex(StringUtils.isEmpty(userRequest.getUserSex()) ? null : (userRequest.getUserSex() == 1));
        one.setUserPassword(MD5Util.getSaltMD5(userRequest.getUserPassword()));
        one.setUserBorth(StringUtils.isEmpty(userRequest.getUserBorth()) ? null : TimeUtils.toLocalDateTime(userRequest.getUserBorth()));
        one.setFirstLogin(LocalDateTime.now(ZoneOffset.UTC));
        one.setLastLogin(LocalDateTime.now(ZoneOffset.UTC));
        one.setIsValued(true);
        AsserUtils.isTrue(!this.saveOrUpdate(one), "添加失败！");
        return ResultResponse.successful("操作成功");
    }

    /**
     * 用户更新
     *
     * @param userRequest
     * @return
     */
    @Override
    public ResultResponse updateUser(UserRequest userRequest) {
        MiaomuUser one = this.getById(userRequest.getId());
        AsserUtils.isTrue(one == null, "该用户不存在");
        if (!one.getUserAccount().equals(userRequest.getUserAccount())) {
            AsserUtils.isTrue(this.getOne(new QueryWrapper<MiaomuUser>().lambda()
                    .ne(MiaomuUser::getId, userRequest.getId())
                    .eq(MiaomuUser::getUserAccount, userRequest.getUserAccount())
                    .eq(MiaomuUser::getIsValued, true)) != null, "账户已经存在");
        }
        if (!userRequest.getUserPhone().equals(one.getUserPhone())) {
            AsserUtils.isTrue(!PhoneUtil.isMobile(userRequest.getUserPhone()), "号码格式不正确");
        }
        BeanUtils.copyProperties(userRequest, one);
        one.setUserPassword(userRequest.getUserPassword().equals(one.getUserPassword()) ? one.getUserPassword() :
                MD5Util.getSaltMD5(userRequest.getUserPassword()));
        one.setUpdateTime(LocalDateTime.now(ZoneOffset.UTC));
        AsserUtils.isTrue(!this.saveOrUpdate(one), "更新失败！");
        return ResultResponse.successful("操作成功");
    }

    /**
     * 用户删除
     *
     * @param userId
     * @return
     */
    @Override
    public ResultResponse deleteUser(Integer userId) {
        MiaomuUser byId = this.getById(userId);
        AsserUtils.isTrue(byId == null, "该用户不存在");
        byId.setIsValued(false);
        byId.setUpdateTime(LocalDateTime.now(ZoneOffset.UTC));
        AsserUtils.isTrue(!this.saveOrUpdate(byId), "删除失败");
        return ResultResponse.successful("操作成功");
    }

    @Override
    public ResultResponse users(Integer currentPage, Integer pageSize, String params, Integer sort) {
        return ResultResponse.successful(this.page(new Page<>(currentPage, pageSize), new QueryWrapper<MiaomuUser>()
                .lambda()
                .eq(MiaomuUser::getIsValued, true)
                .orderByDesc(sort == 0, MiaomuUser::getCreateTime)
                .orderByAsc(sort == 1, MiaomuUser::getCreateTime)));
    }

    @Override
    public ResultResponse user(Integer id) {
        return ResultResponse.successful(this.getById(id));
    }


}
