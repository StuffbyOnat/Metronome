import javax.sound.sampled.*;
import javax.swing.*;
import com.sun.jna.Library;
import com.sun.jna.Native;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Mechanism {

    private Timer timer;
    private int bpm;
    private Metronome toGive;
    private Clip clip;
    boolean increase;
     int count = 0;

    Mechanism(Metronome form_java_file,boolean increase){

        toGive = form_java_file;
        loadAudio();
        this.increase=increase;
    }


    public void start(){

        int delay= 60000/toGive.slider1.getValue();

        timer = new Timer(delay, e -> {
            // Her vuruşta yapılacak işlem
            bpm = toGive.slider1.getValue();
            timer.setDelay(60000/toGive.slider1.getValue());
            playTick();
            System.out.println("Tick"); // Ses, animasyon, ikon vs.
            if (increase){
                if (count > 0 && count % 4 == 0){
                    toGive.slider1.setValue(bpm + toGive.increaseValue);
                }
                count++;
            }
            else
                count++;
        });
        timer.start();
    }
public void stop(){

        if (timer !=null)
            timer.stop();

}
    public void playTick() {
        try {
            java.net.URL soundURL = getClass().getResource("/metronome_click.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void loadAudio(){

        try {
            java.net.URL soundURL = getClass().getResource("/empty.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }

    }



}
