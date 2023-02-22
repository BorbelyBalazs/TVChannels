import java.time.LocalTime;
import java.util.*;

public class Channels {

    private String channelName;
    private boolean isFree;
    private String[] channelCodes;
    private Map<LocalTime, String> timedCodes;

    public Channels(String line) {
        String[] data = line.split(";");
        this.channelName = data[0];
        this.isFree = Boolean.parseBoolean(data[1]);
        String[] codes = data[2].split(",");
        this.channelCodes = codes;
        int timer = 1440 / codes.length;
        int time = 0;
        Map<LocalTime, String> map = new TreeMap<>(Collections.reverseOrder());
        for (var i: codes) {
            map.put(LocalTime.parse("00:00").plusMinutes(time), i);
            time += timer;
        }
        map.put(LocalTime.parse("23:59:59"), "Adásszünet");
        this.timedCodes = map;
        }

    public String getChannelName() {
        return channelName;
    }

    public boolean isFree() {
        return isFree;
    }

    public String[] getChannelCodes() {
        return channelCodes;
    }

    @Override
    public String toString() {
        return channelName + "; " + isFree + "; " + Arrays.toString(channelCodes) + timedCodes + "\n";

    }

    public Map<LocalTime, String> getTimedCodes() {
        return timedCodes;
    }
}

