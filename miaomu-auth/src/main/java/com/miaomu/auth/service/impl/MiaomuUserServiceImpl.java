package com.miaomu.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaomu.common.entity.auth.MiaomuUser;
import com.miaomu.auth.mapper.MiaomuUserMapper;
import com.miaomu.auth.service.IMiaomuUserService;
import com.miaomu.common.entity.vo.UserRequest;
import com.miaomu.common.utils.AsserUtils;
import com.miaomu.common.utils.MD5Util;
import com.miaomu.common.utils.PhoneUtil;
import com.miaomu.common.utils.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addUser(UserRequest userRequest) {
        AsserUtils.isTrue(!PhoneUtil.isMobile(userRequest.getUserPhone()), "号码格式不正确");
        MiaomuUser one = this.getOne(new QueryWrapper<MiaomuUser>().lambda()
                .eq(MiaomuUser::getUserAccount, userRequest.getUserAccount())
                .eq(MiaomuUser::getIsValued, true));
        AsserUtils.isTrue(one != null, "注册的账号存在");
        one = new MiaomuUser();
        BeanUtils.copyProperties(userRequest, one);
        one.setUserSex(StringUtils.isEmpty(userRequest.getUserSex()) ? null : (userRequest.getUserSex() == 1));
        one.setUserPassword(MD5Util.getSaltMD5(userRequest.getUserPassword()));
        one.setUserBorth(StringUtils.isEmpty(userRequest.getUserBorth()) ? null : TimeUtils.toLocalDateTime(userRequest.getUserBorth()));
        AsserUtils.isTrue(!this.saveOrUpdate(one), "注册失败！");
        return ResponseEntity.ok("操作成功");
    }

    /**
     * 用户更新
     *
     * @param userRequest
     * @return
     */
    @Override
    public ResponseEntity<?> updateUser(UserRequest userRequest) {
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
        AsserUtils.isTrue(!this.saveOrUpdate(one), "更新失败！");
        return ResponseEntity.ok("操作成功");
    }

    /**
     * 用户删除
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<?> deleteUser(Integer userId) {
        MiaomuUser byId = this.getById(userId);
        AsserUtils.isTrue(byId == null, "该用户不存在");
        byId.setIsValued(false);
        byId.setUpdateTime(LocalDateTime.now(ZoneOffset.UTC));
        AsserUtils.isTrue(!this.saveOrUpdate(byId), "删除失败");
        return ResponseEntity.ok("操作成功");
    }

    @Override
    public ResponseEntity<?> users(Integer currentPage, Integer pageSize, String params, Integer sort) {

        AsserUtils.isTrue(sort != 1 && sort != 0, "非法参数");

        return ResponseEntity.ok(this.page(new Page<>(currentPage, pageSize), new QueryWrapper<MiaomuUser>()
                .lambda()
                .eq(MiaomuUser::getIsValued, true)
                .orderByDesc(sort == 0, MiaomuUser::getCreateTime)
                .orderByAsc(sort == 1, MiaomuUser::getCreateTime)));
    }

    @Override
    public ResponseEntity<?> user(Integer id) {
        return ResponseEntity.ok(this.getById(id));
    }


}
