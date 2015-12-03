package validate.local;


import org.apache.commons.lang.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Account {

    @NotEmpty(name = "记录序号", length = 6)
    public String serNo;

    @NotEmpty(name = "用户号")
    public String userCode;

    @NotEmpty(name = "页数", length = 11)
    @Max("PageSize")
    public Long page;

    @NotEmpty(name = "页长", length = 11)
    @Size(max = 11)
    public Long pageSize;

    @NotEmpty(name = "金额", length = 11)
    public BigDecimal amount;

    @NotEmpty(name = "交易")
    public TxCode txCode;

    public String getSerNo() {
        return serNo;
    }

    public void setSerNo(String serNo) {
        this.serNo = serNo;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TxCode getTxCode() {
        return txCode;
    }

    public void setTxCode(TxCode txCode) {
        this.txCode = txCode;
    }

    public static void main(String[] args) throws Exception {
        Account account = new Account();
        account.setSerNo("1234567");
        account.setUserCode("    ");
        account.setTxCode(TxCode.RECHARGE);
        account.setPage(11L);
        account.setPageSize(10L);
        checkParemeter(account);

    }

    private static void checkParemeter(Object object) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();


        for (Field field : fields) {
            Object o = getProperty(object, field.getName());

            //1.校对NotEmpty
            boolean flag = field.isAnnotationPresent(NotEmpty.class);
            if (flag) {
                System.out.println("---------------------校对NotEmpty-------------------------");

                NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
                System.out.println(o + "-" + field.getName() + "-" + field.getType() + "-" + notEmpty);
                //校验null
                if (o == null) {
                    System.out.println(notEmpty.name() + "不能为空");
                } else {
                    System.out.println(field.getName() + "=[" + o.toString() + "]");

                    //校验非空
                    if (field.getType() == String.class) {
                        if (StringUtils.isBlank(o.toString())) {
                            System.out.println(notEmpty.name() + "-不能为空");
                        }
                    }
                    //校对长度
                    String valueStr = o.toString();
                    if (valueStr.length() > notEmpty.length()) {
                        System.out.println(notEmpty.name() + "长度大于" + notEmpty.length());

                    }
                }
            }
            //校验Max
            boolean flagMax = field.isAnnotationPresent(Max.class);
            if (flagMax) {
                System.out.println("---------------------校对max-------------------------");
                Max max = field.getAnnotation(Max.class);
                System.out.println(o + "-" + field.getName() + "-" + field.getType() + "-" + max);

                Object maxValue = getProperty(object, max.value());
                if (maxValue != null && o != null) {
                    if ((maxValue.toString()).compareTo(o.toString()) <= 0) {
                        System.out.println(field.getName() + "值不应大于" + max.value());
                    }
                }

            }


        }
    }

    public static Object getProperty(Object object, String proName) throws Exception {
        PropertyDescriptor proDescriptor = new PropertyDescriptor(proName, object.getClass());
        Method methodGetX = proDescriptor.getReadMethod();
        Object objx = methodGetX.invoke(object);
        return objx;
    }


}
