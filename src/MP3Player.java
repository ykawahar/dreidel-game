import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MP3Player {

    private static AudioInputStream musicFile;
    private static Clip clip;

    public MP3Player() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        musicFile = AudioSystem.getAudioInputStream(new File("dreidel/res/Sevivon_sov_sov_sov.mid"));

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(musicFile);

        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

//    public static void main(String[] args) {
//        musicFile.loop(Clip.LOOP_CONTINUOUSLY);
//    }

//    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
//            LineUnavailableException
//    {
//        musicFile = AudioSystem.getAudioInputStream(
//                new File("dreidel/res/Sevivon_sov_sov_sov.mp3").getAbsoluteFile());
//        musicFile.open(audioInputStream);
//        clip.loop(Clip.LOOP_CONTINUOUSLY);
//    }
}
