package Utility;

public class Utilidades {

    public static String igualarPrecio (String precio) {
        int finalPrecio = precio.indexOf("*")-1;
        return (precio.substring(1, finalPrecio));
    }
}
