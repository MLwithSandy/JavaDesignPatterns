// SRP - Single Responsibility Principle: One class has one responsibility and there is a segregation of responsibilities among the classes
// Journal class is concerned about responsibilties related to journal and its entries. It is not responsible for persis-
// ence
// Persistence class takes care of Persistence layer
package com.skr.jdp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

class Journal{
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text){
        entries.add(" " + (++count) + ". " + text);
    }
    public void removeEntry(int index){
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

public class SingleResponsibility {
    public static void main(String[] args) throws FileNotFoundException {
        Journal journal = new Journal();
        journal.addEntry("I am OK");
        journal.addEntry("I am NOK");
        System.out.println("List of Journal entries: ");
        System.out.println(journal);
        journal.removeEntry(0);
        System.out.println("List of Journal after removal  : ");

        System.out.println(journal);

        Persistence persistence = new Persistence();
        persistence.saveToFile(journal, "/Users/sandeepkumar/Projects/IdeaProjects/javaDesignPatternUdemy/srp.txt", true);

    }


}
