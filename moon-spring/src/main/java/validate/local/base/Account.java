package validate.local.base;


import org.apache.commons.lang.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Account {

    @NotEmpty(name = "记录序号")
    public String serNo;

    @NotEmpty(name = "用户号")
    public String userCode;

    @NotEmpty(name = "页数")
    public Long page;

    @NotEmpty(name = "页长")
    public Long pageSize;


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

    public static void main(String[] args) throws Exception {
        Account account = new Account();
        account.setSerNo("444");
        account.setUserCode("    ");
        checkParemeter(account);

    }

    private static void checkParemeter(Object object) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean flag = field.isAnnotationPresent(NotEmpty.class);
            if (flag) {
                NotEmpty annotationDto = field.getAnnotation(NotEmpty.class);
                Object o = getProperty(object, field.getName());
                System.out.println(o + "-" + field.getName() + "-" + field.getType() + "-" + annotationDto);

                if (o == null) {
                    System.out.println(annotationDto.name() + "不能为空");
                } else {
                    if (field.getType() == String.class) {
                        System.out.println(field.getName() + "=[" + o.toString()+"]");
                        if (StringUtils.isBlank(o.toString())) {
                            System.out.println(annotationDto.name() + "-不能为空");
                        }
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

    private static void test(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            System.out.println("----------------" + field.getName());
            Annotation[] annotations = field.getDeclaredAnnotations();
            boolean flag = field.isAnnotationPresent(NotEmpty.class);

            if (flag) {
                NotEmpty annotationDto = field.getAnnotation(NotEmpty.class);
                System.out.println(annotationDto);
            }
        }
    }

}
