import java.time.LocalTime;
import java.util.*;

public class Main2 {
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

        View view = new View();
        view.run(consumers, channels, programmes);

//        LocalTime t = LocalTime.now();
//        System.out.println(t.isBefore(LocalTime.of(12,00)));

    }
}
