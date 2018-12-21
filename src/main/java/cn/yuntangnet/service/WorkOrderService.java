package cn.yuntangnet.service;

import cn.yuntangnet.pojo.WorkOrder;

import java.util.List;

/**
 * @author 张茂林
 * @since 2017/12/15 15:13
 */
public interface WorkOrderService {
    /**
     * 添加一个工单
     *
     * @param workOrder
     */
    void save(WorkOrder workOrder);

    /**
     * 根据用户ID 查询工单
     *
     * @param id
     * @param total
     * @return
     */
    List<WorkOrder> getOrderListByUserId(Long id, int total);

    /**
     * 根据主键ID查询
     *
     * @param id
     * @return
     */
    WorkOrder getById(Long id);
}
