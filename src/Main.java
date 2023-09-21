import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<LineObj> lessThan30 = new ArrayList<>();
        List<LineObj> valencianBar = new ArrayList<>();
        List<LineObj> alacantBar = new ArrayList<>();

        File file = new File("data.csv");
        File file1 = addDocAtEnd(file);
        int cont;
        Comparator<LineObj> compareByName = Comparator.comparing(LineObj::getNomLoc);

        Comparator<LineObj> compareClientsNumber = Comparator.comparing(LineObj::getClienMensual);

        if (fileExist(file)) {
            String[] formatead = formatSplit(readFile(file1).toString());
            formatead = formatEspace(formatead);
            List<LineObj> objLineList = createObjList(formatead);

            /*prueba formato borrar espacio InputMismatch error con los numeros por tener espacio*/
//               for (int i = 0; i < formatead.length; i++) {
//                 System.out.println(formatead[i]);
//              }
            /*prueba formato archivo formateado lineas bien*/
//            List<LineObj> objLineList = createObjList(formatead);
//                for (int i = 0; i < objLineList.size(); i++) {
//                 System.out.println(objLineList.get(i).toString());
//                  }
            fillUpList(objLineList, lessThan30, valencianBar, alacantBar);
//
            cont = countEmployers(objLineList);
            System.out.println("numero de locales con mas de 70 empleados = " + cont);
//            Collections.sort(lessThan30,compareByName);
//            for (LineObj o : lessThan30) {
//                System.out.println(o.getNomLoc());
//                System.out.println(o.getCiudad());
//                System.out.println(o.getDirecc());
//              //  System.out.println(o.getNumero_empleados());
//                System.out.println("----------------------");
//            }


//            showList(valencianBar);
//            Collections.sort(alacantBar, compareClientsNumber.reversed());
//            showList(alacantBar);


//            countCityLocation(objLineList);

        }

    }


    public static File addDocAtEnd(File file) {
        File file1 = new File("dataFormated.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line += ";";
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {


            e.printStackTrace();
        }
        return file1;
    }


    private static void fillUpList(List<LineObj> objLineList, List<LineObj> lessThan30, List<LineObj> valencianBar, List<LineObj> alacantBar) {
        try {
            for (int i = 1; i < objLineList.size(); i++) {
                if (Integer.parseInt(objLineList.get(i).getNumero_empleados()) <= 30) {
                    lessThan30.add(objLineList.get(i));
                } else if (objLineList.get(i).getCiudad().equals("Valencia")) {
                    valencianBar.add(objLineList.get(i));
                } else if (objLineList.get(i).getCiudad().equals("Alicante")) {
                    alacantBar.add(objLineList.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static  int countEmployers(  List<LineObj> objLineList){
        int cont = 0;
        for (int i = 1; i < objLineList.size(); i++) {
            if (Integer.parseInt(objLineList.get(i).getNumero_empleados()) > 70) {
                cont++;
            }
        }
        return cont;
    }


    public static  void showList(List<LineObj> o){
        System.out.println(o.toString());
    }

    public static List<LineObj> createObjList(String[] formated) {
        List<LineObj> ObjList = new ArrayList<>();
        LineObj bv;
        int i = 0;
        try {
            do {
                bv = new LineObj();
                bv.setNomLoc(formated[i]);
                i++;
                bv.setDirecc(formated[i]);
                i++;
                bv.setCodPos(formated[i]);
                i++;
                bv.setCiudad(formated[i]);
                i++;
                bv.setClienMensual(formated[i]);
                i++;
                bv.setTfn(formated[i]);
                i++;
                bv.setNumero_empleados(formated[i]);
                i++;
                bv.setNumero_platos_menu(formated[i]);
                i++;
                ObjList.add(bv);

            } while (i < formated.length -1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ObjList;
    }



    public static String[] formatSplit(String text) {
        String[] texts = text.split(";");
        return texts;
    }

    public static String[] formatEspace(String[] csv) {
        for (int i = 0; i < csv.length; i++) {
            csv[i] = csv[i].replace(" ", "");
        }
        return csv;
    }


    public static List<String> readFile(File file) {
        List<String> lineas = new ArrayList<>();

        try {
            lineas = Files.readAllLines(Paths.get(file.toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    public static boolean fileExist(File file) {
        boolean exist;
        exist = Files.exists(Paths.get(file.toURI()));
        return exist;
    }

    public static void countCityLocation(List<LineObj> list) {
        int Valencia = 0, Alicante = 0, Barcelona = 0, Sevilla = 0, Murcia = 0, Malaga = 0, Bilbao = 0, Madrid = 0, Zaragoza = 0;

        for (LineObj o : list) {
            switch (o.getCiudad()) {
                case "Valencia" -> Valencia++;
                case "Alicante" -> Alicante++;
                case "Barcelona" -> Barcelona++;
                case "Sevilla" -> Sevilla++;
                case "Murcia" -> Murcia++;
                case "Malaga" -> Malaga++;
                case "Bilbao" -> Bilbao++;
                case "Madrid" -> Madrid++;
                case "Zaragoza" -> Zaragoza++;
            }
        }

        System.out.println("Valencia: " + Valencia);
        System.out.println("Alicante: " + Alicante);
        System.out.println("Barcelona: " + Barcelona);
        System.out.println("Sevilla: " + Sevilla);
        System.out.println("Murcia: " + Murcia);
        System.out.println("Malaga: " + Malaga);
        System.out.println("Bilbao: " + Bilbao);
        System.out.println("Madrid: " + Madrid);
        System.out.println("Zaragoza: " + Zaragoza);
    }


}