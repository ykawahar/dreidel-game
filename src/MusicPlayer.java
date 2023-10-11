import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class MusicPlayer {

//    public static void main(String[] argv) throws Exception {
//        // From file
//        Sequence sequence = MidiSystem.getSequence(new File("dreidel/res/Sevivon_sov_sov_sov.mid"));
//
//        // Create a sequencer for the sequence
//        Sequencer sequencer = MidiSystem.getSequencer();
//        sequencer.open();
//        sequencer.setSequence(sequence);
//
//        // Start playing
//        sequencer.start();
//    }

    public void playSevivon() throws Exception{

         // From file
        Sequence sequence = MidiSystem.getSequence(new File("dreidel/res/Sevivon_sov_sov_sov.mid"));

        // Create a sequencer for the sequence
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(sequence);

        // Start playing
        for (int i = 0; i < 200; i++) {
            long duration = sequence.getMicrosecondLength();
            sequencer.start();
        }
    }
}

