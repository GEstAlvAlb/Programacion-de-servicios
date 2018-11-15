package Trenes;

import javax.swing.JApplet;
import java.awt.*;

// Draw a centered circle.
// Get the height and width from the web page.
// Base the radius on the smallest of the two.
public class prueba extends JApplet
{

  public void paint ( Graphics gr )
  { 
    int width  = getWidth();
    int height = getHeight();
    int radius;
    
    if ( width<height )
      radius = 2*width/5;
    else
      radius = 2*height/5;
    
    gr.setColor( Color.red );
    gr.fillRect( 0, 0, width, height );
    gr.setColor( Color.black );

    gr.drawOval( (width/2 - radius), (height/2 - radius), radius*2, radius*2 );
   }
}