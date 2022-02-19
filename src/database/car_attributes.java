
package database;

public class car_attributes {
    
    private static String model_name;
    private static String manufacture_type;
    private static String Year_of_purchase;
    private static String avilable_color;
    private static String price;
    private static String code_car;
    private static String Car_Image;

    public car_attributes() {
    }

    public static String getModel_name() {
        return model_name;
    }

    public static void setModel_name(String model_name) {
        car_attributes.model_name = model_name;
    }

    public static String getManufacture_type() {
        return manufacture_type;
    }

    public static void setManufacture_type(String manufacture_type) {
        car_attributes.manufacture_type = manufacture_type;
    }

    public static String getYear_of_purchase() {
        return Year_of_purchase;
    }

    public static void setYear_of_purchase(String Year_of_purchase) {
        car_attributes.Year_of_purchase = Year_of_purchase;
    }

    public static String getAvilable_color() {
        return avilable_color;
    }

    public static void setAvilable_color(String avilable_color) {
        car_attributes.avilable_color = avilable_color;
    }

    public static String getPrice() {
        return price;
    }

    public static void setPrice(String price) {
        car_attributes.price = price;
    }

    public static String getCode_car() {
        return code_car;
    }

    public static void setCode_car(String code_car) {
        car_attributes.code_car = code_car;
    }

    public static String getCar_Image() {
        return Car_Image;
    }

    public static void setCar_Image(String Car_Image) {
        car_attributes.Car_Image = Car_Image;
    }
    
    
    
}
