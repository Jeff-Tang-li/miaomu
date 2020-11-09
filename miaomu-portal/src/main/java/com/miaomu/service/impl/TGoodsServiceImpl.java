package com.miaomu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miaomu.common.entity.TGoods;
import com.miaomu.common.entity.response.ResultResponse;
import com.miaomu.mapper.TGoodsMapper;
import com.miaomu.service.ITGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jack.wang
 * @since 2020-11-03
 */
@Service
@Slf4j
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements ITGoodsService {


    @Override
    public ResultResponse listGoods(Integer current, Integer pageSize) {
        IPage<TGoods> page = this.page(new Page<>(current, pageSize), new QueryWrapper<>());
        return ResultResponse.successful(page);
    }
}
