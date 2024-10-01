package org.java.Essentials.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        forEachFilter();
        mapAndCollect();
        reduce();
        lambdas();
        flatmap();
    }

    private static void forEachFilter() {
        System.out.println("_____________________1. THIS IS FOREACHFILTER!!!_____________________");

        List<String> list = Arrays.asList("Peter","Hans","Rüdiger","Werner");
        for(String s : list){
            if (!"Peter".equals(s)){
                System.out.println(s);
            }
        }
        System.out.println("-------------------------------");
        list.stream().filter(new Predicate<>() {
            @Override
            public boolean test(String s) {
                return "Peter".equals(s);
            }
        }).forEach(s-> System.out.println(s));
        System.out.println("-------------------------------");
        List<Kunde> kunden = Arrays.asList(
                new Kunde(22,"Marie","Müller"),
                new Kunde(35,"Peter","Schmidt"),
                new Kunde(29,"Markus","Bach"),
                new Kunde(18,"Markus","Engels")
        );
        kunden.stream().
                filter(p->p.getAlter()>25&&"Markus".equals(p.getVorname())).
                forEach(p->System.out.println("Kunde: "+p.getId()));
    }

    @SuppressWarnings("Convert2MethodRef")
    private static void mapAndCollect(){
        System.out.println("_____________________2. THIS IS MAPANDCOLLECT!!!_____________________");
        List<String> buchstaben = Arrays.asList("a","b","c","d","e","f");
        List<String> grossbuchstaben = new ArrayList<>();
        for(String s : buchstaben){
            grossbuchstaben.add(s.toUpperCase());
        }
        System.out.println(grossbuchstaben);

        System.out.println("-------------------------------");

        List<String> collect = buchstaben.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("-------------------------------");

        List<Kunde> kunden = Arrays.asList(
                new Kunde(22,"Marie","Müller"),
                new Kunde(35,"Peter","Schmidt"),
                new Kunde(29,"Markus","Bach"),
                new Kunde(18,"Markus","Engels")
        );

        List<String> kundennamen = new ArrayList<>();
        for (Kunde kunde : kunden) {
            kundennamen.add(kunde.getVorname());
        }
        System.out.println(kundennamen);

        System.out.println("-------------------------------");

        List<String> namensListe = kunden.stream().map(x -> x.getVorname()).collect(Collectors.toList());
        System.out.println(namensListe);
    }

    private static void reduce() {
        System.out.println("_____________________3. THIS IS REDUCE!!!_____________________");
        List<String> woerter = Arrays.asList("Der","beste","Kanal", "fuer","Programmierer");

        String string = woerter.stream().reduce((a,b)-> a + " " + b).get();

        System.out.println(string);

        System.out.println("-------------------------------");

        List<Integer> integerWerte = Arrays.asList(5,10,15,20,25);
        integerWerte.stream().reduce((zwischensumme,zahl)->zwischensumme+zahl).ifPresent(z->System.out.println(z));
        //Selber code verkürzt:
        integerWerte.stream().reduce(Integer::sum).ifPresent(System.out::println);

        System.out.println("-------------------------------");

        /* Wenn vor Lambda expression ein Wert angegeben wird ist dies der default Wert (identity), Rückgabetyp der Funktion ist
        dann kein Optional mehr! */
        Integer maximalWert = integerWerte.stream().reduce(0,Integer::max);
        System.out.println(maximalWert);

        System.out.println("-------------------------------");

        List<Benutzer> benutzers = Arrays.asList(new Benutzer("Frank",27),new Benutzer("Marie",29));
        int berechnetesAlter = benutzers.stream().reduce(0,(alter,benutzer)->alter + benutzer.getAlter(), Integer::sum);
        System.out.println(berechnetesAlter);
    }

    private static void lambdas(){
        System.out.println("_____________________4. THIS IS LAMBDAS!!!_____________________");
        System.out.println(useStreamableFunction((suffix)-> "Hello"+suffix));

        // You can also basically have this Lambda expression stored as an Object first before using it
        StreamableInterface streamableInterface = (suffix) -> "Test" + suffix;
        System.out.println(useStreamableFunction(streamableInterface));
    }

    private static void flatmap(){
        System.out.println("_____________________5. THIS IS FLATMAP!!!_____________________");

        List<String> strings = Arrays.asList("This","is","an","example","list");
        List<String> capsStrings = strings.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(capsStrings);

        System.out.println("-------------------------------");

        List<Integer> numbers = Arrays.asList(1,2);
        List<Integer> moreNumbers = Arrays.asList(3,4);
        List<List<Integer>> lisctception = Arrays.asList(numbers,moreNumbers);

        System.out.println(lisctception);
        List<Integer> numbersList =
                lisctception.stream().flatMap(listen -> listen.stream()).collect(Collectors.toList());

        System.out.println(numbersList);

        //Example use-case for combining Lists associated to Objects:
        // List<String> telefonnummern =
        // boundenListe.stream().flatmap(kunde -> kunde.getTeleconference().stream).collect(Collectors.toList());
    }

    //Helper Function for "lambdas()"
    private static String useStreamableFunction(StreamableInterface object){
        return object.streamableFunction(" You!!");
    }
}
