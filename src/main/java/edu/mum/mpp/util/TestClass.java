package edu.mum.mpp.util;

public class TestClass {

    public static void main(String[] args) {
        String phraseUpper = "The quick brown fox";
        String colorUpper = "BrOwn";
        System.out.println("First test Upper: " + phraseUpper.contains(colorUpper));
        System.out.println("Second test Upper: " + phraseUpper.toUpperCase().contains(colorUpper.toUpperCase()));

        //
        String phrase = "The quick brown fox";
        String color = "BrOwn";
        System.out.println("First test Lower: " + phrase.contains(color));
        System.out.println("Second test Lower: " + phrase.toLowerCase().contains(color.toLowerCase()));
    }

}
