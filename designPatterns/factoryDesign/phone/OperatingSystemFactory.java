package designPatterns.factoryDesign.phone;

public class OperatingSystemFactory {
    public OS getInstance(String str){
        if(str.equals("open"))
            return new Android();
        else if(str.equals("secured"))
            return new IOS();
        else
            return new Windows();
    }
}
