package cn.yuntangnet.service.impl;

import cn.yuntangnet.mapper.BusinessContentMapper;
import cn.yuntangnet.mapper.BusinessOrderMapper;
import cn.yuntangnet.pojo.BusinessContent;
import cn.yuntangnet.pojo.BusinessContentExample;
import cn.yuntangnet.pojo.BusinessOrder;
import cn.yuntangnet.pojo.BusinessOrderExample;
import cn.yuntangnet.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张茂林
 * @since 2018/3/7 14:34
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessContentMapper businessContentMapper;
    private final BusinessOrderMapper businessOrderMapper;

    @Autowired
    public BusinessServiceImpl(BusinessContentMapper businessContentMapper, BusinessOrderMapper businessOrderMapper) {
        this.businessContentMapper = businessContentMapper;
        this.businessOrderMapper = businessOrderMapper;
    }

    /**
     * 查找开启的商学院活动
     *
     * @return
     */
    @Override
    public List<BusinessContent> selectStartContent() {
        BusinessContentExample example = new BusinessContentExample();
        BusinessContentExample.Criteria criteria = example.createCriteria();
        //已开启的活动
        criteria.andContentStatusEqualTo("1");

        List<BusinessContent> list = businessContentMapper.selectByExample(example);
        return list;
    }

    /**
     * 根据ID查询活动
     *
     * @param id
     * @return
     */
    @Override
    public BusinessContent selectContentById(Long id) {
        BusinessContent businessContent = businessContentMapper.selectByPrimaryKey(id);
        return businessContent;
    }

    /**
     * 用户是否已下单
     *
     * @param userId
     * @return contentId
     */
    @Override
    public BusinessOrder getUserOrder(Long userId, Long contentId) {
        BusinessOrderExample businessOrderExample = new BusinessOrderExample();
        BusinessOrderExample.Criteria criteria = businessOrderExample.createCriteria();
        criteria.andUserWechatIdEqualTo(userId).andContentIdEqualTo(contentId).andIsPayEqualTo(true);

        List<BusinessOrder> list = businessOrderMapper.selectByExample(businessOrderExample);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    /**
     * 用户下单
     *
     * @param order
     */
    @Override
    public void saveOrder(BusinessOrder order) {
        businessOrderMapper.insertSelective(order);
    }
}
