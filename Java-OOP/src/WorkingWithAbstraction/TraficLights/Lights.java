package WorkingWithAbstraction.TraficLights;

public enum Lights {
    GREEN("YELLOW"),
    YELLOW("RED"),
    RED("GREEN");

    private String light;

    Lights(String light) {
        this.light = light;
    }

    public String changer(String currentLight){
        switch (currentLight){
            case"GREEN":
                currentLight = "YELLOW";
                break;
            case"YELLOW":
                currentLight = "RED";
                break;
            case"RED":
                currentLight = "GREEN";
                break;
        }
        return currentLight;
    }
}
