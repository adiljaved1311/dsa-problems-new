package designPatterns.factoryDesignNotification;

//NotificationFactory to instantiate concrete class
public class NotificationFactory {
    public Notification createNotification(String type){
        if(type == null || type.isEmpty()){
            return null;
        }
        switch (type){
            case "SMS":
                return new SMSNotification();
            case "EMAIL":
                return new EmailNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type "+type);
        }
    }
}
