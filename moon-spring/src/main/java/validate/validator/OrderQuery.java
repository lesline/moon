package validate.validator;

import java.util.Date;

// 'to'所表示的日期必须在'from'所表示的日期之后
// @QueryConstraint 是一个定制化的 constraint
public class OrderQuery {
    private Date from;
    private Date to;
}