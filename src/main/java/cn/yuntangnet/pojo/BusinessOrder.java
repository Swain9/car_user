package cn.yuntangnet.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table business_order
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class BusinessOrder implements Serializable {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   下单ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.user_wechat_id
     *
     * @mbg.generated
     */
    private Long userWechatId;

    /**
     * Database Column Remarks:
     *   微信下单ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.open_id
     *
     * @mbg.generated
     */
    private String openId;

    /**
     * Database Column Remarks:
     *   订单号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     * Database Column Remarks:
     *   活动ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.content_id
     *
     * @mbg.generated
     */
    private Long contentId;

    /**
     * Database Column Remarks:
     *   外部订单统一标识
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.prepay_id
     *
     * @mbg.generated
     */
    private String prepayId;

    /**
     * Database Column Remarks:
     *   ip地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.ip_address
     *
     * @mbg.generated
     */
    private String ipAddress;

    /**
     * Database Column Remarks:
     *   用户姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * Database Column Remarks:
     *   联系手机号码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.user_phone
     *
     * @mbg.generated
     */
    private String userPhone;

    /**
     * Database Column Remarks:
     *   支付金额
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.pay_money
     *
     * @mbg.generated
     */
    private Long payMoney;

    /**
     * Database Column Remarks:
     *   支付日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.pay_datetime
     *
     * @mbg.generated
     */
    private Date payDatetime;

    /**
     * Database Column Remarks:
     *   支付方式 1.微信支付 2.支付宝支付 3.银联支付,4.后台添加
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.pay_type
     *
     * @mbg.generated
     */
    private String payType;

    /**
     * Database Column Remarks:
     *   是否已付款
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.is_pay
     *
     * @mbg.generated
     */
    private Boolean isPay;

    /**
     * Database Column Remarks:
     *   是否已处理
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.is_done
     *
     * @mbg.generated
     */
    private Boolean isDone;

    /**
     * Database Column Remarks:
     *   返积分账号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.platform_id
     *
     * @mbg.generated
     */
    private String platformId;

    /**
     * Database Column Remarks:
     *   返积分手机号码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.platform_phone
     *
     * @mbg.generated
     */
    private String platformPhone;

    /**
     * Database Column Remarks:
     *   返积分平台
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.platform_name
     *
     * @mbg.generated
     */
    private String platformName;

    /**
     * Database Column Remarks:
     *   操作的管理员
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.admin_name
     *
     * @mbg.generated
     */
    private String adminName;

    /**
     * Database Column Remarks:
     *   创建日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.gmt_create
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     * Database Column Remarks:
     *   更新日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business_order.gmt_modified
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table business_order
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.id
     *
     * @return the value of business_order.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.id
     *
     * @param id the value for business_order.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.user_wechat_id
     *
     * @return the value of business_order.user_wechat_id
     *
     * @mbg.generated
     */
    public Long getUserWechatId() {
        return userWechatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.user_wechat_id
     *
     * @param userWechatId the value for business_order.user_wechat_id
     *
     * @mbg.generated
     */
    public void setUserWechatId(Long userWechatId) {
        this.userWechatId = userWechatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.open_id
     *
     * @return the value of business_order.open_id
     *
     * @mbg.generated
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.open_id
     *
     * @param openId the value for business_order.open_id
     *
     * @mbg.generated
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.order_id
     *
     * @return the value of business_order.order_id
     *
     * @mbg.generated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.order_id
     *
     * @param orderId the value for business_order.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.content_id
     *
     * @return the value of business_order.content_id
     *
     * @mbg.generated
     */
    public Long getContentId() {
        return contentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.content_id
     *
     * @param contentId the value for business_order.content_id
     *
     * @mbg.generated
     */
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.prepay_id
     *
     * @return the value of business_order.prepay_id
     *
     * @mbg.generated
     */
    public String getPrepayId() {
        return prepayId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.prepay_id
     *
     * @param prepayId the value for business_order.prepay_id
     *
     * @mbg.generated
     */
    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.ip_address
     *
     * @return the value of business_order.ip_address
     *
     * @mbg.generated
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.ip_address
     *
     * @param ipAddress the value for business_order.ip_address
     *
     * @mbg.generated
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.user_name
     *
     * @return the value of business_order.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.user_name
     *
     * @param userName the value for business_order.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.user_phone
     *
     * @return the value of business_order.user_phone
     *
     * @mbg.generated
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.user_phone
     *
     * @param userPhone the value for business_order.user_phone
     *
     * @mbg.generated
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.pay_money
     *
     * @return the value of business_order.pay_money
     *
     * @mbg.generated
     */
    public Long getPayMoney() {
        return payMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.pay_money
     *
     * @param payMoney the value for business_order.pay_money
     *
     * @mbg.generated
     */
    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.pay_datetime
     *
     * @return the value of business_order.pay_datetime
     *
     * @mbg.generated
     */
    public Date getPayDatetime() {
        return payDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.pay_datetime
     *
     * @param payDatetime the value for business_order.pay_datetime
     *
     * @mbg.generated
     */
    public void setPayDatetime(Date payDatetime) {
        this.payDatetime = payDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.pay_type
     *
     * @return the value of business_order.pay_type
     *
     * @mbg.generated
     */
    public String getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.pay_type
     *
     * @param payType the value for business_order.pay_type
     *
     * @mbg.generated
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.is_pay
     *
     * @return the value of business_order.is_pay
     *
     * @mbg.generated
     */
    public Boolean getIsPay() {
        return isPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.is_pay
     *
     * @param isPay the value for business_order.is_pay
     *
     * @mbg.generated
     */
    public void setIsPay(Boolean isPay) {
        this.isPay = isPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.is_done
     *
     * @return the value of business_order.is_done
     *
     * @mbg.generated
     */
    public Boolean getIsDone() {
        return isDone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.is_done
     *
     * @param isDone the value for business_order.is_done
     *
     * @mbg.generated
     */
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.platform_id
     *
     * @return the value of business_order.platform_id
     *
     * @mbg.generated
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.platform_id
     *
     * @param platformId the value for business_order.platform_id
     *
     * @mbg.generated
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId == null ? null : platformId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.platform_phone
     *
     * @return the value of business_order.platform_phone
     *
     * @mbg.generated
     */
    public String getPlatformPhone() {
        return platformPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.platform_phone
     *
     * @param platformPhone the value for business_order.platform_phone
     *
     * @mbg.generated
     */
    public void setPlatformPhone(String platformPhone) {
        this.platformPhone = platformPhone == null ? null : platformPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.platform_name
     *
     * @return the value of business_order.platform_name
     *
     * @mbg.generated
     */
    public String getPlatformName() {
        return platformName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.platform_name
     *
     * @param platformName the value for business_order.platform_name
     *
     * @mbg.generated
     */
    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.admin_name
     *
     * @return the value of business_order.admin_name
     *
     * @mbg.generated
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.admin_name
     *
     * @param adminName the value for business_order.admin_name
     *
     * @mbg.generated
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.gmt_create
     *
     * @return the value of business_order.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.gmt_create
     *
     * @param gmtCreate the value for business_order.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business_order.gmt_modified
     *
     * @return the value of business_order.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business_order.gmt_modified
     *
     * @param gmtModified the value for business_order.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}