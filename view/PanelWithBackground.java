package view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class PanelWithBackground extends JPanel 
{

  private Image image;

  public PanelWithBackground(Image image) {
    this.image = image;
  }

  
  public void setImage(Image image) {
    this.image = image;
  }

  @Override
  public void paintComponent(Graphics g) {
    g.drawImage(image, 0, 0, null);
  }
}