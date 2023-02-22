import java.util.*;

public class Feladatok {

    public static List<String> mostChannels(List<Channels> channels) {
        List<String> mostChList = new ArrayList<>();
        int count = 0;
        String mostCh = "";

        for (Channels i : channels) {
            if (i.getChannelCodes().length > count) {
                count = i.getChannelCodes().length;
                mostCh = i.getChannelName();
            }
        }
        mostChList.add(mostCh);
        for (Channels i : channels) {
            if (i.getChannelCodes().length == count && !i.getChannelName().equals(mostCh)) {
                mostChList.add(i.getChannelName());
            }
        }
        return mostChList;
    }

    public static List<String> leastChannels(List<Channels> channels) {
        List<String> leastChList = new ArrayList<>();
        int count = Integer.MAX_VALUE;
        String leastCh = "";

        for (Channels i : channels) {
            if (i.getChannelCodes().length < count) {
                count = i.getChannelCodes().length;
                leastCh = i.getChannelName();
            }
        }
        leastChList.add(leastCh);
        for (Channels i : channels) {
            if (i.getChannelCodes().length == count && !i.getChannelName().equals(leastCh)) {
                leastChList.add(i.getChannelName());
            }
        }
        return leastChList;
    }

    public static List<String> mostCommonProgrammes(List<Channels> channels, List<Programmes> programmes, Map<String, Integer> progNums) {

        List<String> mostProgrammes = new ArrayList<>();
        int count = 0;
        String mostPr = "";
        for (Map.Entry<String, Integer> i : progNums.entrySet()) {
            if (i.getValue() > count) {
                count = i.getValue();
                mostPr = i.getKey();
            }
        }
        mostProgrammes.add(mostPr);
        for (Map.Entry<String, Integer> i : progNums.entrySet()) {
            if (i.getValue() == count && !i.getKey().equals(mostPr)) {
                mostProgrammes.add(i.getKey());
            }
        }
        return mostProgrammes;
    }

    public static List<String> leastCommonProgrammes(List<Channels> channels, List<Programmes> programmes, Map<String, Integer> progNums) {

        List<String> leastProgrammes = new ArrayList<>();
        int count = Integer.MAX_VALUE;
        String mostPr = "";
        for (Map.Entry<String, Integer> i : progNums.entrySet()) {
            if (i.getValue() < count) {
                count = i.getValue();
                mostPr = i.getKey();
            }
        }
        leastProgrammes.add(mostPr);
        for (Map.Entry<String, Integer> i : progNums.entrySet()) {
            if (i.getValue() == count && !i.getKey().equals(mostPr)) {
                leastProgrammes.add(i.getKey());
            }
        }
        return leastProgrammes;
    }

    public static Map<String, Integer> programsHowMany(List<Channels> channels, List<Programmes> programmes) {
        Map<String, Integer> progNums = new HashMap<>();
        for (Programmes p : programmes) {
            for (Channels c : channels) {
                for (String s : c.getChannelCodes()) {
                    if (p.getChannelCode().equals(s)) {
                        progNums.put(p.getFullTitle(), progNums.getOrDefault(p.getFullTitle(), 0) + 1);
                    }
                }
            }
        }
        return progNums;
    }

    public static List<String> onlyOneChannel(Map<String, Integer> progNums) {
        List<String> onlyOne = new ArrayList<>();
        for (Map.Entry<String, Integer> i : progNums.entrySet()) {
            if (i.getValue() == 1) {
                onlyOne.add(i.getKey());
            }
        }

        return onlyOne;
    }

    public static double averageProgs(List<Channels> channels) {
        double chs = 0;
        for (Channels i : channels) {
            chs += i.getChannelCodes().length;
        }
        return chs / channels.size();
    }

    public static Map<String, Integer> howManyGenres(List<Channels> channels, List<Programmes> programmes) {
        Map<String, Integer> howManyG = new HashMap<>();
        Set<String> genres;
        for (Channels c : channels) {
            genres = new HashSet<>();
            for (String s : c.getChannelCodes()) {
                for (Programmes p : programmes) {
                    if (s.equals(p.channelCode)) {
                        genres.add(p.getGenre());
                    }
                }
            }
            howManyG.put(c.getChannelName(), genres.size());
        }

        return howManyG;
    }

    public static Map<String, List<String>> programsInChannels(List<Channels> channels, List<Programmes> programmes) {
        Map<String, List<String>> prCh = new HashMap<>();
        List<String> prog;
        for (Channels c : channels) {
            prog = new ArrayList<>();
            for (String s : c.getChannelCodes()) {
                for (Programmes p : programmes) {
                    if (s.equals(p.getChannelCode())) {
                        prog.add("\n" + p.getFullTitle() + "; " + p.getGenre() + "; " + p.getAgeLimit());
                        break;
                    }
                }
            }
            prCh.put(c.getChannelName(), prog);
        }
        return prCh;
    }

    public static Map<String, List<String>> programsInWhichChannels(List<Channels> channels, List<Programmes> programmes) {
        Map<String, List<String>> prCh = new HashMap<>();
        List<String> ch;

        for (Programmes p : programmes) {
            ch = new ArrayList<>();
            for (Channels c : channels) {
                for (String s : c.getChannelCodes()) {
                    if (p.getChannelCode().equals(s)) {
                        ch.add(c.getChannelName());
                    }
                }
            }
            prCh.put(p.getFullTitle(), ch);
        }
        return prCh;
    }

    public static int adultPrograms(List<Programmes> programmes) {
        int counter = 0;
        for (var p : programmes) {
            if (p.getAgeLimit() == 18) {
                counter++;
            }
        }
        return counter;
    }

    public static Map<String, Double> freePayingRate(List<Channels> channels) {
        Map<String, Double> rate = new HashMap<>();
        double countFree = 0;
        double countPaying = 0;

        for (Channels c : channels) {
            if (c.isFree()) {
                countFree++;
            } else {
                countPaying++;
            }
        }
        rate.put("Ingyenes ", countFree * 100 / channels.size());
        rate.put("Fizetős ", countPaying * 100 / channels.size());
        return rate;
    }

    public static String isAgeRestrict(List<Channels> channels, List<Programmes> programmes, int ageLimit) {
        boolean b;
        for (Channels c : channels) {
            b = true;
            for (String s : c.getChannelCodes()) {
                for (Programmes p : programmes) {
                    if (s.equals(p.getChannelCode())) {
                        if (p.getAgeLimit() != ageLimit) {
                            b = false;
                        }
                        if (b) {
                            return "Van: " + c.getChannelName();
                        }
                    }

                }
            }
        }
        return "Nincs";
    }

    public static int howManyGenresAll(List<Programmes> programmes) {
        int counter = 0;
        String str = "";

        for (var i : programmes) {
            if (!str.contains(i.getGenre())) {
                str += i.getGenre() + " ";
                counter++;
            }
        }
//        System.out.println(str);
        return counter;
    }

    public static Map<String, Integer> programmesPerGenres(List<Programmes> programmes) {
        Map<String, Integer> genreMap = new HashMap<>();

        for (var i : programmes) {
            genreMap.put(i.getGenre(), genreMap.getOrDefault(i.getGenre(), 0) + 1);
        }
        return genreMap;
    }

    public static String mostProgrammesperGenre(Map<String, Integer> genreMap) {
        int counter = 0;
        String str = "";

        for (Map.Entry<String, Integer> i : genreMap.entrySet()) {
            if (i.getValue() > counter) {
                counter = i.getValue();
                str = i.getKey();
            }
        }
        return str + ": " + counter;
    }

    public static String mostSharedProgs(List<Channels> channels) {
        int counter;
        String str = "";
        int counterFinal = 0;

        for (int i = 0; i < channels.size() - 1; i++) {
            for (int j = i + 1; j < channels.size(); j++) {
                counter = 0;
                for (String s : channels.get(i).getChannelCodes()) {
                    for (String ss : channels.get(j).getChannelCodes()) {
                        if (s.equals(ss)) {
                            counter++;
                        }
                    }
                }
                if (counter > counterFinal) {
                    counterFinal = counter;
                    str = channels.get(i).getChannelName() + " és " + channels.get(j).getChannelName();
                }
            }
        }
        return str + " számszerint: " + counterFinal;
    }
}
