package bai9.code;

interface AudioPlayable {
    void playAudio(String file);
}

interface VideoPlayable {
    void playVideo(String file);
}

class AudioPlayer implements AudioPlayable {
    public void playAudio(String file) {
        System.out.println("AudioPlay: " + file);
    }
}

class VideoPlayer implements VideoPlayable {
    public void playVideo(String file) {
        System.out.println("VideoPlay: " + file);
    }
}

class MediaPlayer {
    private AudioPlayable audioPlayer;
    private VideoPlayable videoPlayer;

    public MediaPlayer(AudioPlayable audioPlayer, VideoPlayable videoPlayer) {
        this.audioPlayer = audioPlayer;
        this.videoPlayer = videoPlayer;
    }

    public void playAudio(String file) {
        audioPlayer.playAudio(file);
    }

    public void playVideo(String file) {
        videoPlayer.playVideo(file);
    }
}

public class Main {
    public static void main(String[] args) {
        AudioPlayable audioPlayer = new AudioPlayer();
        VideoPlayable videoPlayer = new VideoPlayer();

        MediaPlayer player = new MediaPlayer(audioPlayer, videoPlayer);
        player.playAudio("bai_hat_hay.mp3");
    }
}
