package main;

public class Main {

    public static void main(String[] args) {
        String str = "-0--1551075783329-";
        str = ":::1551075783329";
        String[] split = str.split(":");
        System.out.println("length is " + split.length);
        for (String item : split) {
            System.out.println("item: " + item);
        }
    }

}
