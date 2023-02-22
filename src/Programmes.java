public class Programmes {

    String channelCode;
    String fullTitle;
    String genre;
    Integer ageLimit;

    public Programmes(String line) {
        String[] data = line.split(";");
        this.channelCode = data[0];
        this.fullTitle = data[1];
        this.genre = data[2];
        this.ageLimit = data[3].equals("NULL")  ? 0 : Integer.parseInt(data[3]);
    }

    public String getChannelCode() {
        return channelCode;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    @Override
    public String toString() {
        return channelCode + "; " + fullTitle + "; " +  genre + "; " + ageLimit + "\n";
    }
}
