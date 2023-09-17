public class P {
    public static void main(String[] args) {
        String sCiudades = "#01avila;#02madrid;#03toledo;#04santander";
        String[] items = sCiudades.split(";");

        for (String item: items)
            System.out.println(item);
    }
}
