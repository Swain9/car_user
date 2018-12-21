package cn.yuntangnet.service.impl;

import cn.yuntangnet.mapper.WorkOrderMapper;
import cn.yuntangnet.pojo.WorkOrder;
import cn.yuntangnet.pojo.WorkOrderExample;
import cn.yuntangnet.service.WorkOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张茂林
 * @since 2017/12/15 15:13
 */
@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    @Autowired
    private WorkOrderMapper workOrderMapper;

    /**
     * 添加一个工单
     *
     * @param workOrder
     */
    @Override
    @Transactional
    public void save(WorkOrder workOrder) {
        workOrderMapper.insert(workOrder);
    }

    /**
     * 根据用户ID 查询工单
     *
     * @param id
     * @param total
     * @return
     */
    @Override
    public List<WorkOrder> getOrderListByUserId(Long id, int total) {
        int pageNum = (total / 10) + 1;
        //设置分页信息
        PageHelper.startPage(pageNum, 10);
        //执行查询
        WorkOrderExample example = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserWechatIdEqualTo(id);
        example.setOrderByClause("gmt_create desc");

        List<WorkOrder> list = workOrderMapper.selectByExample(example);
        //取查询结果
        PageInfo<WorkOrder> pageInfo = new PageInfo<>(list);
        //设置分页结果
        return list;
    }

    /**
     * 根据主键ID查询
     *
     * @param id
     * @return
     */
    @Override
    public WorkOrder getById(Long id) {
        WorkOrder workOrder = workOrderMapper.selectByPrimaryKey(id);
        return workOrder;
    }
}
