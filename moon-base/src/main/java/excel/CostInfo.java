package excel;

import java.math.BigDecimal;
import java.util.Date;

public class CostInfo {

    private Long id;
    private String accountNo;// 账户号
    private String accountName;// 账户名
    private String accountType;// 账户类型
    private String accountTypeName;// 账户类型
    private String txCode;// 交易码
    private String txCodeName;// 交易码
    private String outOrderNo;// 外部订单号
    private BigDecimal txAmount;// 交易金额
    private String currency;// 币种
    private String bankCardNo;// 银行卡号
    private String bankName;// 银行名称
    private String channelCode;// 支付渠道编码
    private String channelCodeName;// 支付渠道编码
    private Date createTime;// 创建时间
    private String markInfo;// 备注
    private String txStatus;// 交易状态00 初始化 01成功 02失败 03处理中
    private String txStatusName;// 交易状态00 初始化 01成功 02失败 03处理中
    private Date txTime;// 交易时间
    private String txSerialNo;// 交易流水号
    private String startTime;// 开始时间
    private String endTime;// 结束时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }

    public String getTxCodeName() {
        return txCodeName;
    }

    public void setTxCodeName(String txCodeName) {
        this.txCodeName = txCodeName;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public BigDecimal getTxAmount() {
        return txAmount;
    }

    public void setTxAmount(BigDecimal txAmount) {
        this.txAmount = txAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelCodeName() {
        return channelCodeName;
    }

    public void setChannelCodeName(String channelCodeName) {
        this.channelCodeName = channelCodeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMarkInfo() {
        return markInfo;
    }

    public void setMarkInfo(String markInfo) {
        this.markInfo = markInfo;
    }

    public String getTxStatus() {
        return txStatus;
    }

    public void setTxStatus(String txStatus) {
        this.txStatus = txStatus;
    }

    public String getTxStatusName() {
        return txStatusName;
    }

    public void setTxStatusName(String txStatusName) {
        this.txStatusName = txStatusName;
    }

    public Date getTxTime() {
        return txTime;
    }

    public void setTxTime(Date txTime) {
        this.txTime = txTime;
    }

    public String getTxSerialNo() {
        return txSerialNo;
    }

    public void setTxSerialNo(String txSerialNo) {
        this.txSerialNo = txSerialNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CostInfo{" +
                "id=" + id +
                ", accountNo='" + accountNo + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", txCode='" + txCode + '\'' +
                ", txCodeName='" + txCodeName + '\'' +
                ", outOrderNo='" + outOrderNo + '\'' +
                ", txAmount=" + txAmount +
                ", currency='" + currency + '\'' +
                ", bankCardNo='" + bankCardNo + '\'' +
                ", bankName='" + bankName + '\'' +
                ", channelCode='" + channelCode + '\'' +
                ", channelCodeName='" + channelCodeName + '\'' +
                ", createTime=" + createTime +
                ", markInfo='" + markInfo + '\'' +
                ", txStatus='" + txStatus + '\'' +
                ", txStatusName='" + txStatusName + '\'' +
                ", txTime=" + txTime +
                ", txSerialNo='" + txSerialNo + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}