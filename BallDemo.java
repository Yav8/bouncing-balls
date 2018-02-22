import java.awt.Color;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulación de bolas rebotando.
     * @param numeroDeBolas El número de bolas que el usuario
     * quiere que aparezca por pantalla.
     */
    public void bounce(int numeroDeBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        ArrayList<BouncingBall> listaDeBolas = new ArrayList<>();
        for(int contador = 0; contador < numeroDeBolas; contador++) {
            BouncingBall bola = new BouncingBall (50 + (20 * contador), 50, 16, Color.BLUE, ground, myCanvas);
            bola.draw();
            listaDeBolas.add(bola);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BouncingBall bola : listaDeBolas) {
                bola.move();
                // stop once ball has travelled a certain distance on x axis
                if(bola.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
