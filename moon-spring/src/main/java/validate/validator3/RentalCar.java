package validate.validator3;

import org.hibernate.validator.group.GroupSequenceProvider;

//@GroupSequence({ RentalCar.class, CarChecks.class, DriverChecks.class })
@GroupSequenceProvider(RentalCarGroupSequenceProvider.class)
public class RentalCar extends Car {
    private boolean rented;    

    public RentalCar(String manufacturer, String licencePlate, int seatCount) {
        super( manufacturer, licencePlate, seatCount );
    }

   public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}