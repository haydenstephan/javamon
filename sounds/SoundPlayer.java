package sounds;


import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 



public class SoundPlayer 
{

  static Clip music;

    public static synchronized void playSound(final String url) {
    new Thread(new Runnable() { // the wrapper thread is unnecessary, unless it blocks on the Clip finishing, see comments
      public void run() {
        try {
          Clip clip = AudioSystem.getClip();
          AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(url));
          clip.open(inputStream);     
       
          clip.start(); 
        } catch (Exception e) {
          System.err.println(e.getMessage());
        }
      }
    }).start();
  }

  public static void startMusic(){
    new Thread(new Runnable() { // the wrapper thread is unnecessary, unless it blocks on the Clip finishing, see comments
      public void run() {
        try {
          music = AudioSystem.getClip();
          AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("sounds/music.wav"));
          music.open(inputStream);     
       
          music.start(); 
          music.loop(Clip.LOOP_CONTINUOUSLY); 
        } catch (Exception e) {
          System.err.println(e.getMessage());
        }
      }
    }).start();
  }


    

    
}
