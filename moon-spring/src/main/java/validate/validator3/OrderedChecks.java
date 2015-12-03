package validate.validator3;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, CarChecks.class, DriverChecks.class})
public interface OrderedChecks {
}