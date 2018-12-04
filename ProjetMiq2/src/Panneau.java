import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class Panneau extends JPanel { 
    public Panneau(){
        
    }
    @Override
  public void paintComponent(Graphics g){
    g.drawOval(400, 300, 100, 100);
  }               
}
