
import javax.swing.JFrame;

public class GameFrame extends JFrame {

	GameFrame(){
		
		this.add(new GamePanel());		//	GamePanel panel = new GamePanel();
		this.setTitle("Snake");			//	this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	//	this.setLocation(null);
		
		
		
	}
	

}
