package validate.validator3;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
import validate.validator3.CarChecks;
import validate.validator3.DriverChecks;
import validate.validator3.RentalCar;

import java.util.ArrayList;
import java.util.List;

public class RentalCarGroupSequenceProvider implements DefaultGroupSequenceProvider<RentalCar> {
    public List<Class<?>> getValidationGroups(RentalCar car) {
        List<Class<?>> defaultGroupSequence = new ArrayList<Class<?>>();
        defaultGroupSequence.add(CarChecks.class);
        defaultGroupSequence.add(RentalCar.class);

        if (car != null && car.isRented()) {
            defaultGroupSequence.add(DriverChecks.class);
        }

        return defaultGroupSequence;
    }
}