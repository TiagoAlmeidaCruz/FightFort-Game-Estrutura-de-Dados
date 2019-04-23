package GAME;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    private Clip clip;
    public Sound(String fileName) {
        // especifica o som para tocar
        // (assumindo que o som pode ser jogado pelo sistema de áudio)
        // a partir de um arquivo wave
        try {
            File file = new File(fileName);
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
             // carregar o som na memória (a Clip)
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            else {
                throw new RuntimeException("Som: arquivo não encontrado: " + fileName);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Som: URL mal formada: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Som: Não há suporte para arquivo de áudio: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Som: Erro de entrada / saída: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Som: Linha Indisponível erro de exceção: " + e);
        }

    // play, stop, loop o sound clip
    }
    public void play(){
        clip.setFramePosition(0);  // Deve sempre voltar!!
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
            clip.stop();
        }
    }