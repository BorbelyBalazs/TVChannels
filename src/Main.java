import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> ch = TextFileReader.getLinesOfTextFile("C:\\Progmatic\\Projectek\\TVChannels\\channels.txt");
        List<Channels> channels = new ArrayList<>();
        List<String> pr = TextFileReader.getLinesOfTextFile("C:\\Progmatic\\Projectek\\TVChannels\\programmes.txt");
        List<Programmes> programmes = new ArrayList<>();
        List<String> cons = TextFileReader.getLinesOfTextFile("C:\\Progmatic\\Projectek\\TVChannels\\consumers.txt");
        List<Consumers> consumers = new ArrayList<>();


        for (String i : ch) {
            channels.add(new Channels(i));
        }
        for (String i : pr) {
            programmes.add(new Programmes(i));
        }
        for (String i: cons) {
            consumers.add(new Consumers(i));
        }
        System.out.println(consumers);

        Map<String, Integer> progNums = Feladatok.programsHowMany(channels, programmes);

        System.out.println("A legtöbb műsort a köv. csatornák adják: " + Feladatok.mostChannels(channels));
        System.out.println("A legkevesebb műsort a köv. csatornák adják: " + Feladatok.leastChannels(channels) + "\n");

        System.out.println("A legtöbb csatornán a köv. műsor(ok) szerepel(nek): " +
                Feladatok.mostCommonProgrammes(channels, programmes, progNums));
        System.out.println("A legkevesebb csatornán a köv. műsor(ok) szerepel(nek): " +
                Feladatok.leastCommonProgrammes(channels, programmes, progNums) + "\n");

        System.out.println("Van olyan műsor, amit csak egy csatorna sugároz? " +
                Feladatok.onlyOneChannel(progNums) == null ? "Nincs" : "Van, a " + Feladatok.onlyOneChannel(progNums) + "\n");

        System.out.println("Átlagosan ennyi műsor jut egy csatornára: " + Feladatok.averageProgs(channels) + "\n");

        System.out.println("Egy-egy csatornán hány különböző műfaj található?\n" + Feladatok.howManyGenres(channels, programmes) + "\n");

//        System.out.println("A csatornák programjai: " + Feladatok.programsInChannels(channels, programmes));

//        for (Map.Entry<String, List<String>> i : Feladatok.programsInChannels(channels, programmes).entrySet()) {
//            System.out.println(i + "\n\n");
//        }

//        System.out.println(Feladatok.programsInWhichChannels(channels, programmes));

//        for (Map.Entry<String, List<String>> i : Feladatok.programsInWhichChannels(channels, programmes).entrySet()) {
//            System.out.println(i);
//        }
        System.out.println();

        System.out.println("Összesen ennyi 18 karikás műsor van: " + Feladatok.adultPrograms(programmes) + "\n");

        System.out.println("A fizetős és ingyenes csatornák aránya: " + Feladatok.freePayingRate(channels) + "\n");

        System.out.println("Van olyan csatorna, amely csak “18-as karikás” műsorokat ad? " + Feladatok.isAgeRestrict(channels, programmes, 18));
        System.out.println("Van olyan csatorna, amely csak korhatár nélküli műsorokat ad? " + Feladatok.isAgeRestrict(channels, programmes, 0) + "\n");

        System.out.println(Feladatok.howManyGenresAll(programmes) + " különböző műfaj van.");
        System.out.println(Feladatok.programmesPerGenres(programmes));
        System.out.println("Melyik műfajhoz tartozik a legtöbb műsor? "  +
                Feladatok.mostProgrammesperGenre(Feladatok.programmesPerGenres(programmes)) + "\n");

        System.out.println("Melyik két csatorna között van a legnagyobb “műsor-átfedés”?: " +
                Feladatok.mostSharedProgs(channels));

        }


}