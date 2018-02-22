import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

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
        Random aleatorio = new Random();
        for(int contador = 0; contador < numeroDeBolas; contador++) {
            int numeroAleatorioDelDiametroDeLaBola = aleatorio.nextInt(36);
            
            int numeroAleatorioParaElColorRojo = aleatorio.nextInt(256);
            int numeroAleatorioParaElColorVerde = aleatorio.nextInt(256);
            int numeroAleatorioParaElColorAzul = aleatorio.nextInt(256);
            
            Color color = new Color(numeroAleatorioParaElColorRojo, numeroAleatorioParaElColorVerde, numeroAleatorioParaElColorAzul);
            
            BouncingBall bola = new BouncingBall (50 + (20 * contador), 50, numeroAleatorioDelDiametroDeLaBola + 5, color, ground, myCanvas);
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
