package com.miaomu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miaomu.common.entity.TGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.miaomu.common.entity.response.ResultResponse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jack.wang
 * @since 2020-11-03
 */
public interface ITGoodsService extends IService<TGoods> {
    /**
     * 查询所有商品
     */
    ResultResponse listGoods(Integer current, Integer pageSize);



}
