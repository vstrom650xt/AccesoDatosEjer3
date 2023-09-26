package controller;

import BadEjer.LineObj;
import models.LineObjStm;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Logic {
     static List<LineObjStm> outPutData;
    public   void readFile(){
        Path path = Paths.get("data.csv");//es como una variable aunq sea una funcion que se llama convertidor

        Function<String,LineObjStm> convertidor = a ->{
         String[]p  =  a.split(";".trim());
            return  new LineObjStm(p[0],p[1],p[2],p[3],p[4],p[5],(Integer.parseInt(p[6].trim())),Integer.parseInt(p[7].trim()));
        };

        try{
            if (fileExist(path.toFile())){
                outPutData= Files.lines(path).skip(1).map(convertidor).toList(); // el toList para convertirlo , aqui es donde se llama a la funcion lambda
//                System.out.println(countEmployers());
//                System.out.println(lessThan300());
//                System.out.println(fromValencia());
//                System.out.println(fromAlicante());
                System.out.println(countCity());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static  int countEmployers(){
       return (int) outPutData.stream()
                .skip(1)
                .filter(p -> p.getNumero_empleados()>70)
                .count();
    }

    public static boolean fileExist(File file) {
        boolean exist;
        exist = Files.exists(Paths.get(file.toURI()));
        return exist;
    }

    public <LineObjStm> List<models.LineObjStm> lessThan300(){
        return  outPutData.stream()
                .skip(1)
                .filter(p->p.getNumero_empleados()<30)
                .toList();
    }

    public <LineObjStm> List<models.LineObjStm> fromValencia(){
        return  outPutData.stream()
                .skip(1)
                .filter(p->p.getCiudad().equals("Valencia"))
                .toList();
    }



    public <LineObjStm> List<models.LineObjStm> fromAlicante(){

        return  outPutData.stream()
                .skip(1)
                .filter(p->p.getCiudad().equals("Alicante"))
                .sorted(Comparator.comparing(models.LineObjStm::getClienMensual).reversed())
                .toList();
    }


    public static Map<String, Long> countCity(){
        return   outPutData.stream()
                .skip(1)
                .collect(Collectors.groupingBy(LineObjStm::getCiudad,Collectors.counting()));
    }



}
