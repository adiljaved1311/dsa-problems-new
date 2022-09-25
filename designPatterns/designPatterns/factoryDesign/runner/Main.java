package designPatterns.factoryDesign.runner;

import designPatterns.factoryDesign.phone.Android;
import designPatterns.factoryDesign.phone.OS;
import designPatterns.factoryDesign.phone.OperatingSystemFactory;

public class Main {
    public static void main(String[] args) {
        OperatingSystemFactory osf = new OperatingSystemFactory();
        OS obj = osf.getInstance("open");
        obj.spec();
        obj = osf.getInstance("secured");
        obj.spec();
    }
}
