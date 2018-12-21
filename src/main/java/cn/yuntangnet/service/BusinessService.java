package cn.yuntangnet.service;

import cn.yuntangnet.pojo.BusinessContent;
import cn.yuntangnet.pojo.BusinessOrder;

import java.util.List;

/**
 * @author 张茂林
 * @since 2018/3/7 14:34
 */
public interface BusinessService {
    /**
     * 查找开启的商学院活动
     *
     * @return
     */
    List<BusinessContent> selectStartContent();

    /**
     * 根据ID查询活动
     *
     * @param id
     * @return
     */
    BusinessContent selectContentById(Long id);

    /**
     * 用户是否已下单
     *
     * @param userId
     * @param contentId
     * @return
     */
    BusinessOrder getUserOrder(Long userId, Long contentId);

    /**
     * 用户下单
     *
     * @param order
     */
    void saveOrder(BusinessOrder order);
}
