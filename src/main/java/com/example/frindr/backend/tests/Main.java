package com.example.frindr.backend.tests;

import com.example.frindr.backend.fruit.Complete_tree;
import com.example.frindr.backend.fruit.Tree;
import com.example.frindr.backend.fruit.Date;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Complete_tree tree;
        try {
            tree = new Complete_tree();
        } catch (IOException e) {
            System.out.println("invalid file bozo");
            System.out.println(e.getMessage());
            return;
        }
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("1:quit\n2:Loop testing\n3:Stream Testing\n4:List Filter Testing\n5:Date Filter Testing\n6:location Testing\nselection: ");
                int inp  = Integer.parseInt(input.nextLine());
                switch (inp) {
                    case 1: return;
                    case 2: loopTest(tree); break;
                    case 3: streamTest(tree); break;
                    case 4: listTest(tree); break;
                    case 5: dateTest(tree); break;
                    case 6: locationTest(tree);break;
                }
            }catch (NumberFormatException e){
                System.out.println("please enter one of the available numbers");
            }
        }
    }


//=================================================================
// this shows how to use standard loop methods
// =================================================================
    public static void  loopTest(Complete_tree tree) {
            List<String> fruits = tree.getFruitTypes();
            try {
                for (String fruit : fruits) {
                    System.out.println("\n" + fruit);
                    Complete_tree selectFruit = tree.getFruit(fruit);
                    if (selectFruit == null) {
                        throw new IllegalArgumentException("Fruit not found");
                    }

                    List<String> bioNames = selectFruit.getSpeciesAdvanced();
                    for (String bion : bioNames) {
                        System.out.println(bion);
                    }

                    List<String> normName = selectFruit.getCommonSpecies();
                    for (String norm : normName) {
                        System.out.println("\t" + norm);
                    }
                }
            } catch (IllegalAccessError e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Null pointer occurred");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("why did this happen");
            }
        }

//=================================================================
// this shows how to use the stream methods
// =================================================================
    public static void streamTest(Complete_tree tree) {
        List<String> Fruits = tree.getFruitNamesStreams();
        for (String fruit : Fruits) {
            System.out.println("\n" + fruit);
            Complete_tree selectFruit = tree.getFruitStream(fruit);

            List<String> bioNames = selectFruit.getSpeciesAdvancedStream();
            for (String bion : bioNames) {
                System.out.println(bion);
            }

            List<String> normName = selectFruit.getSpeciesCommonStream();
            for (String norm : normName) {
                System.out.println("\t" + norm);
            }
        }
    }
//=================================================================
// this shows how to use the get FruitListStream method used when the number of active fruit filters > 1
// =================================================================
    public static void listTest(Complete_tree tree) {
        List<String> testSelection = new ArrayList<>();

        testSelection.add("Saskatoon"); // hitting the filter button adds / removes an item from the list
        testSelection.add("Plum");

        Complete_tree listTest = tree.getFruitListStream(testSelection);

        System.out.println(listTest.getFruitNamesStreams());
        System.out.println(listTest.getCount());

        for (Tree tree1 : listTest.getTrees()) {
            System.out.println("\n"+tree1);
        }
    }
//=================================================================
// this shows how to use the date filter method
// =================================================================
    public static void dateTest(Complete_tree tree) {
        Date queryDate;

        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("please enter a date in the formant YYYY/MM/DD or leave blank for default\nDate: ");
            String inp = input.nextLine();
            if(inp.isEmpty()){queryDate = new Date("1990/01/01");break;
            }else {try{queryDate = new Date(inp);break;}
                catch(Exception e){System.out.println(e.getMessage());}
            }
        }

        Complete_tree dateTest;
        dateTest = tree.dateFilter(queryDate, Complete_tree.mode.lessThan);
        System.out.println(dateTest.getFruitNamesStreams());
        System.out.println(dateTest.getCount());

        dateTest = tree.dateFilter(queryDate, Complete_tree.mode.equals);
        System.out.println(dateTest.getFruitNamesStreams());
        System.out.println(dateTest.getCount());

        dateTest = tree.dateFilter(queryDate, Complete_tree.mode.greaterThan);
        System.out.println(dateTest.getFruitNamesStreams());
        System.out.println(dateTest.getCount());

    }
//=================================================================
// this shows how to use the Location filter method
// =================================================================
    public static void locationTest(Complete_tree tree){
        Scanner input = new Scanner(System.in);
        double radius;
        while(true) {
            System.out.print("please enter Number for a radius in KM or leave blank for default\nRadius: ");
            String inp = input.nextLine();
            if (inp.isEmpty()) {
                radius = 10.0;break;
            } else {
                try {radius = Double.parseDouble(inp);
                    if (radius<0){throw new IllegalArgumentException("radius must be a positive number");}
                    break;
                } catch (Exception e) {System.out.println(e.getMessage());}
            }
        }
        String address;
        System.out.print("please enter an Address or leave blank for default\nAddress: ");
        String inp = input.nextLine();
        if (inp.isEmpty()) {
            address = "1713,ROBERTSON PLACE SW";
        } else {
            address = inp;
        }
        Complete_tree inRad;

        try{
            inRad = tree.InRadius(radius,address);
            System.out.println("There are "+inRad.getCount()+" trees with edible fruit within "+radius+ "km of " + address);
        }catch(Exception e){System.out.println("\n"+e.getMessage()+"\n");}
    }
}






