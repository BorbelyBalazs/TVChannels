import java.util.List;
import java.util.Scanner;

public class View {
    Scanner s = new Scanner(System.in);
    Contoller cont = new Contoller();

    public void run(List<Consumers> consumers, List<Channels> channels, List<Programmes> programmes) {
        System.out.println("Szia, hogy hívnak?");
        String name = s.nextLine();
        Consumers cons = new Consumers();

        boolean b;
        do {
            b = false;
            for (var i : consumers) {
                if (name.equals(i.getName())) {
                    b = true;
                    System.out.println("Üdvözöllek " + i.getName() + "\n");
                    cons = i;
                    break;
                }
            }
            if (!b) {
                System.out.println("Ilyen név nincs az adatbázisban. Adj meg másik nevet, vagy lépj ki (exit)");
                name = s.nextLine();
                if (name.equals("exit")) {
                    System.out.println("Viszlát!");
                    break;
                }
            } else {
                channelChoice(channels, cons, programmes);
            }
        } while (!b);

    }

    public void channelChoice(List<Channels> channels, Consumers cons, List<Programmes> programmes) {

        boolean b = true;
        do {
            menu(channels);
            int choice = s.nextInt();
            switch (choice) {
                case 1 -> cont.chosenChannel(channels, cons, programmes, channels.get(0).getChannelName());
                case 2 -> cont.chosenChannel(channels, cons, programmes, channels.get(1).getChannelName());
                case 3 -> cont.chosenChannel(channels, cons, programmes, channels.get(2).getChannelName());
                case 4 -> cont.chosenChannel(channels, cons, programmes, channels.get(3).getChannelName());
                case 5 -> cont.chosenChannel(channels, cons, programmes, channels.get(4).getChannelName());
                case 6 -> cont.chosenChannel(channels, cons, programmes, channels.get(5).getChannelName());
                case 7 -> cont.chosenChannel(channels, cons, programmes, channels.get(6).getChannelName());
                case 8 -> cont.chosenChannel(channels, cons, programmes, channels.get(7).getChannelName());
                case 9 -> cont.chosenChannel(channels, cons, programmes, channels.get(8).getChannelName());
                case 10 -> cont.chosenChannel(channels, cons, programmes, channels.get(9).getChannelName());
                case 11 -> cont.chosenChannel(channels, cons, programmes, channels.get(10).getChannelName());
                case 12 -> cont.chosenChannel(channels, cons, programmes, channels.get(11).getChannelName());
                case 13 -> cont.chosenChannel(channels, cons, programmes, channels.get(12).getChannelName());
                case 14 -> cont.chosenChannel(channels, cons, programmes, channels.get(13).getChannelName());
                case 15 -> cont.chosenChannel(channels, cons, programmes, channels.get(14).getChannelName());
                case 16 -> cont.chosenChannel(channels, cons, programmes, channels.get(15).getChannelName());
                case 0 -> {
                    System.out.println("Viszlát!");
                    b = false;
                }
                default -> System.out.println("Kérlek a megadott opciók közül válassz!");
            }
        } while (b);

    }

    private static void menu(List<Channels> channels) {
        System.out.println("Válassz az alábbi csatornák közül!");
        int num = 1;

        for (var i : channels) {
            System.out.println(num + ". " + i.getChannelName());
            num++;
        }
        System.out.println(0 + ". Kilépés");
    }

    public static void choseDifChannel() {
        Scanner s = new Scanner(System.in);
        System.out.println("Mit szeretnél tenni?");
        System.out.println("1. Másik csatornát választok.");
        System.out.println("2. Kikapcsolom a TV-t");

        int choseNum;
        do {
            choseNum = s.nextInt();
            if (choseNum == 2) {
                System.out.println("Viszlát!");
                System.exit(0);
            } else if (choseNum != 1) {
                System.out.println("Kérlek a fentiek közül válassz!");
            }
        } while (choseNum != 1);
        }
}
