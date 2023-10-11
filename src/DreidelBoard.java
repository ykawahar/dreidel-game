import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DreidelBoard {

    private Random random;
    public int playerCount = 2;
    public int pot = 0;
    public List<PlayerData> players = new ArrayList<>();
    public int totalTokens;
    public int round = 0, turn = 1;

    private Dreidel dreidel;
    private MusicPlayer music;
    private MP3Player music2;

    public DreidelBoard() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        dreidel = new Dreidel();
//        music = new MusicPlayer();
        music2 = new MP3Player();
    }

    public static void main(String[] args) throws Exception {
        DreidelBoard game = new DreidelBoard();
        game.run();
    }

    public void run() throws Exception {
//        music.playSevivon();

        initializeGame();
        System.out.println("LET'S SPIN THE DREIDEL!!!");
        round();
    }

    private void initializeGame(){
        createPlayerData();
        totalTokens = playerCount * 10;
    }

    public void createPlayerData() {
        for (int i = 1; i <= playerCount; i++) {
            players.add(new PlayerData(i, 10));
        }
    }

    private void round(){
        pause(2000);
        if (!checkWin()){
            round += 1;
            System.out.println("\n");
            System.out.println("--------------------");
            System.out.println("Round " + round + ": BEGIN!");
            System.out.println("Each player puts one token to pot.");
            for (PlayerData player : players) {
                player.shin();
                pot += 1;
            }
            displayScore();
            pause(500);
            turn();
        } else {
            win();
        }
    }

    private void turn(){
        PlayerData currentPlayer = players.get(turn - 1);
        if (currentPlayer.getPlayingStatus()) {
            System.out.println("Player " + turn + "'s turn!");
            System.out.println("Type SPIN to Spin the Dreidel!");
            String face = spinDreidel();
            pause(500);
            System.out.println("You spun " + face + "!");
            updateData(currentPlayer, face);
        }
        pause(500);
        updateStatus(currentPlayer);
        if (!checkWin()) {
            displayScore();
            nextTurnCounter();
        } else {
            win();
        }
    }

    /* Decides who's turn it is next */
    private void nextTurnCounter() {
        if (turn == playerCount) {
            turn = 1;
            round();
        } else {
            turn += 1;
            turn();
        }
    }

    private String spinDreidel() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("SPIN")){
            input = scan.nextLine();
        }
        System.out.println("Spinning Dreidel...");
        pause(100);
        return dreidel.spinDreidel();
    }

    private void updateData(PlayerData player, String face){
        switch (face) {
            case "Nun":
                System.out.println("Nothing happens.");
                break;
            case "Gimel":
                player.gimel(pot);
                pot = 0;
                System.out.println(player.getName() + " takes all tokens in the pot!");
                break;
            case "Hei":
                player.hei(pot);
                pot = pot / 2;
                System.out.println(player.getName() + " takes half of the tokens in the pot!");
                break;
            case "Shin":
                player.shin();
                pot += 1;
                System.out.println(player.getName() + " puts one token in the pot!");
                break;
        }
    }

    public void updateStatus(PlayerData player){
        boolean status = player.getPlayingStatus();
        if (!status) {
            System.out.println(player.getName() + " is out of the game!");
            players.remove(player);
        }
    }
    private void displayScore(){
        System.out.println("------{Current Token Counts}------");
        System.out.println("Pot: " + pot + " tokens");
        for (PlayerData player : players) {
            if (player.getPlayingStatus()) {
                System.out.println(player.getName() + ": " + player.getTokens() + " tokens");
            }
        }
        System.out.println("----------------------------------");
    }

    private boolean checkWin() {
        return players.size() == 1;
    }

    private void win(){
        System.out.println("\n");
        System.out.println("Congrats! " + players.get(0).getName() + " has won!");
        System.out.println("Rounds: " + round);
    }



    /**
     * Pauses the program for the given time in milliseconds.
     */
    public static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            /* Empty */
        }
    }


}
