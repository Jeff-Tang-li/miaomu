package com.miaomu.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jack.wang
 * @since 2020-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TGoods extends Model<TGoods> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    /**
     * 分类id
     */
    private Integer catId;

    /**
     * 扩展分类id
     */
    private Integer extendCatId;

    /**
     * 求购地区
     */
    private String goodsSn;

    /**
     * 发货地区
     */
    private String goodsName;

    /**
     * 点击数
     */
    private Integer clickCount;

    /**
     * 库存数量
     */
    private Integer storeCount;

    /**
     * 拨打数
     */
    private Integer commentCount;

    /**
     * 商品重量克为单位
     */
    private Integer weight;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 本店价
     */
    private BigDecimal shopPrice;

    /**
     * 商品成本价
     */
    private BigDecimal costPrice;

    /**
     * 商品关键词
     */
    private String keywords;

    /**
     * 商品简单描述
     */
    private String goodsRemark;

    /**
     * 商品详细描述
     */
    private String goodsContent;

    /**
     * 商品上传原始图
     */
    private String originalImg;

    /**
     * 是否有效
     */
    private Integer isValid;

    /**
     * 1为供应,2为求购
     */
    private Integer isOnSale;

    /**
     * 是否包邮0否1是
     */
    private Integer isFreeShipping;

    /**
     * 商品排序
     */
    private Integer sort;

    /**
     * 是否实地看货1是0不是
     */
    private Integer isRecommend;

    /**
     * 是否新品
     */
    private Integer isNew;

    /**
     * 是否热卖
     */
    private Integer isHot;

    /**
     * 最后更新时间
     */
    private Long lastUpdate;

    /**
     * 商品所属类型id，取值表goods_type的cat_id
     */
    private Integer goodsType;

    /**
     * 商品规格类型，取值表goods_type的cat_id
     */
    private Integer specType;

    /**
     * 购买商品赠送积分
     */
    private Integer giveIntegral;

    /**
     * 积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     */
    private Integer exchangeIntegral;

    /**
     * 发布商ID
     */
    private Integer suppliersId;

    /**
     * 商品销量
     */
    private Long salesSum;

    /**
     * 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     */
    private Integer promType;

    /**
     * 优惠活动id
     */
    private Integer promId;

    /**
     * 佣金用于分销分成
     */
    private BigDecimal commission;

    /**
     * SPU
     */
    private String spu;

    /**
     * SKU
     */
    private String sku;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    /**
     * 地址
     */
    private String adress;

    /**
     * gps
     */
    private String gps;

    /**
     * 用户
     */
    private Integer userId;


    @Override
    protected Serializable pkVal() {
        return this.goodsId;
    }

}
