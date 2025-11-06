package com.example.frindr.backend.tests;

import com.example.frindr.backend.fruit.Complete_tree;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Complete_tree tree;
        try{
            tree = new Complete_tree();
        }catch(IOException e){
            System.out.println("invalid file bozo");
            System.out.println(e.getMessage());
            return;
        }

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
        } catch (IllegalAccessError e){System.out.println(e.getMessage());
        } catch(NullPointerException e){System.out.println("Null pointer occurred");
        } catch (IndexOutOfBoundsException e){System.out.println("why did this happen");}



        List<String> Fruits = tree.getFruitTypes();
        for(String fruit: Fruits){
            System.out.println("\n" + fruit);
            Complete_tree selectFruit = tree.getFruitStream(fruit);

            List<String> bioNames = selectFruit.getSpeciesAdvancedStream();
            for (String bion : bioNames) {
                System.out.println(bion);
            }

            List<String> normName = selectFruit.getSpeciesCommonStream();
            for (String norm : normName) {
                System.out.println("\t"+norm);
            }
        }

    }

    }






