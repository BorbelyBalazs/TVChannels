import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Contoller {

    public void chosenChannel(List<Channels> channels, Consumers cons, List<Programmes> programmes, String chn) {

        for (var i: channels) {
            if (chn.equals(i.getChannelName())) {
                if (!i.isFree()) {
                    if (cons.isHasSub()) {
                        inChannel(i, cons, programmes);
                        View.choseDifChannel();
                        break;
                    } else {
                        System.out.println("Sajnos erre a csatornára nincs előfizetésed! Válassz mást!\n");
                        break;
                    }
                }
                inChannel(i, cons, programmes);
                View.choseDifChannel();
                break;
            }
        }
    }

    private void inChannel(Channels chn, Consumers cons, List<Programmes> programmes) {
        System.out.println("A(z) " + chn.getChannelName() + " csatornára kapcsoltál");
        for (Map.Entry<LocalTime, String> i : chn.getTimedCodes().entrySet()) {
            if (LocalTime.now().isAfter(i.getKey())) {
                for (Programmes p: programmes) {
                    if (i.getValue().equals(p.getChannelCode())) {
                        if (p.getAgeLimit() > cons.getAge()) {
                            System.out.println("Sajnos a \"" + p.getFullTitle() + "\" című műsorhoz túl fiatal vagy. Kérlek válassz másik csatornát!");
                            break;
                        } else {
                            System.out.println("Jelenleg a \"" + p.getFullTitle() + "\" című műsort nézed");
                            break;
                        }
                    }
                }
                break;
            }
        }
    }

}
