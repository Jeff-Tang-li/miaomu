package com.miaomu.controller;


import com.miaomu.common.entity.response.ResultResponse;
import com.miaomu.service.ITGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jack.wang
 * @since 2020-11-03
 */
@RestController
@RequestMapping("/v1")
public class TGoodsController {
    @Autowired
    private ITGoodsService iTGoodsService;

    @GetMapping("goods/{current}")
    public ResultResponse getlist(@PathVariable Integer current, @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return iTGoodsService.listGoods(current, pageSize);
    }

}
