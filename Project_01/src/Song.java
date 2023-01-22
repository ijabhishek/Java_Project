/* This is a code where you can play a song with some features 
 * You can change your song by changing song file
 * ---- If you have any suggestion please let me know ------
 * --------------I would like that -------------------------
 * ---------------   Thank you!-----------------------------
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Song {
		
	@SuppressWarnings("resource")
	Song()throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Scanner scanner = new Scanner(System.in);
		File file = new File("music.wav"); // song file name
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
	
		String response = "";
	
		while (true) {
		    System.out.println("P = Play, S = Stop, R = Reset Q = Quit");
		    System.out.print("Enter your Choice: ");
	
		    response = scanner.next();
		    response = response.toUpperCase();
	
		    switch (response) {
		        case ("P"):
		            clip.start();
		            break;
		        case ("S"):
		            clip.stop();
		            break;
		        case ("R"):
		            clip.setMicrosecondPosition(2);
		            break;
		        case ("Q"):
		            clip.stop();
		            String answer = "";
		            while (!answer.equals("YES") && !answer.equals("NO")) {
		                System.out.println("Do you want to play again? yes or no");
		                answer = scanner.next();
		                answer = answer.toUpperCase();
		            }
		            if (answer.equals("YES")) {
		                continue;
		            } else if (answer.equals("NO")) {
		                System.out.println("No worries Thank you dear\n See you soon!");
		                break;
		            } else {
		                System.out.println("Please valid input dear!");
		                break;
		            }
		        default:
		            System.out.println("Not a valid response");
		    }
		    
		}
	}

}

// Have a good day!
