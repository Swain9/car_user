package cn.yuntangnet.service.impl;

import cn.yuntangnet.mapper.SystemContractMapper;
import cn.yuntangnet.pojo.SystemContract;
import cn.yuntangnet.pojo.SystemContractExample;
import cn.yuntangnet.service.ContractService;
import cn.yuntangnet.util.ResultBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author 张茂林
 * @since 2018/1/11 10:54
 */
@Service
public class ContractServiceImpl implements ContractService {


    private final SystemContractMapper systemContractMapper;

    @Autowired
    public ContractServiceImpl(SystemContractMapper systemContractMapper) {
        this.systemContractMapper = systemContractMapper;
    }

    /**
     * 添加一个合同信息
     *
     * @param systemContract
     */
    @Override
    @Transactional
    public void update(SystemContract systemContract) {
        systemContractMapper.updateByPrimaryKey(systemContract);
    }

    /**
     * 根据订单ID查询合同信息
     *
     * @param orderId
     * @return
     */
    @Override
    public SystemContract getByOrderId(String orderId) {
        SystemContractExample example = new SystemContractExample();
        SystemContractExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);

        List<SystemContract> list = systemContractMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 查询用户ID的订单
     *
     * @param id
     * @return
     */
    @Override
    public List<SystemContract> getByUserId(Long id, int total) {
        int pageNum = (total / 10) + 1;
        //设置分页信息
        PageHelper.startPage(pageNum, 10);
        //执行查询
        SystemContractExample example = new SystemContractExample();
        SystemContractExample.Criteria criteria = example.createCriteria();
        criteria.andSendIdEqualTo(id);
        example.setOrderByClause("gmt_create desc");

        List<SystemContract> list = systemContractMapper.selectByExample(example);
        //取查询结果
        PageInfo<SystemContract> pageInfo = new PageInfo<>(list);
        //设置分页结果
        return list;
    }

    /**
     * 检查用户输入的订单编号是否有效
     *
     * @param split
     * @return
     */
    @Override
    public ResultBean checkOrderId(String[] split) {

        SystemContractExample example = new SystemContractExample();
        SystemContractExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdIn(Arrays.asList(split));
        List<SystemContract> list = systemContractMapper.selectByExample(example);
        if (list.size() != split.length) {
            return ResultBean.error("订单编号不存在");
        }
        for (SystemContract systemContract : list) {
            if (!"1".equals(systemContract.getContractStatus())) {
                return ResultBean.error("存在已提交的订单");
            }
        }

        return ResultBean.ok(list);
    }

    /**
     * 批量更新数据
     *
     * @param list
     */
    @Override
    @Transactional
    public void updateBatch(List<SystemContract> list) {
        for (SystemContract contract : list) {
            this.update(contract);
        }
    }
}
