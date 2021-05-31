package ExamPreparation.easterRaces.entities.cars;

import static ExamPreparation.easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar{
    public SportsCar(String model, int horsePower) {
        super(model, horsePower, 3000);
    }

    public static int valid(int horsePower){
        if(horsePower<250 || horsePower>450){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        return horsePower;
    }
}
