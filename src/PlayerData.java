public class PlayerData {
    private String name;
    private int id;
    private int tokens;
    private boolean playing;

    public PlayerData(int id, int tokens) {
        this.name = "Player " + id;
        this.tokens = tokens;
        this.playing = true;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getTokens() {
        return tokens;
    }

    public int getId() {
        return id;
    }

    public boolean getPlayingStatus() {
        return playing;
    }

    public void gimel(int potAmount) {
        tokens += potAmount;
    }

    public void hei(int potAmount) {
        tokens += Math.ceil((double) potAmount * 0.5);
    }

    public void shin() {
        if (tokens > 0) {
            tokens -= 1;
        } else {
            playing = false;
        }
    }
}
