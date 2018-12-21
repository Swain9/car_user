package cn.yuntangnet.service;

import cn.yuntangnet.pojo.SystemContract;
import cn.yuntangnet.util.ResultBean;

import java.util.List;

/**
 * @author 张茂林
 * @since 2018/1/11 10:53
 */
public interface ContractService {
    /**
     * 更新一个合同信息
     *
     * @param systemContract
     */
    void update(SystemContract systemContract);

    /**
     * 根据订单ID查询合同信息
     *
     * @param orderId
     * @return
     */
    SystemContract getByOrderId(String orderId);

    /**
     * 查询用户ID的订单
     *
     * @param id
     * @return
     */
    List<SystemContract> getByUserId(Long id, int total);

    /**
     * 检查用户输入的订单编号是否有效
     *
     * @param split
     * @return
     */
    ResultBean checkOrderId(String[] split);

    /**
     * 批量更新数据
     *
     * @param list
     */
    void updateBatch(List<SystemContract> list);
}
