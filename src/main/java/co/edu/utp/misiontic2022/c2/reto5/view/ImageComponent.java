package co.edu.utp.misiontic2022.c2.reto5.view;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author faba6
 */
public class ImageComponent extends JPanel{
    private Image image;
    /**
     * Constructor del componente con imagen de fondo en base a un JPanel
     * @param fileNameImage URL imagen relativo a /src/resources
     */
    public ImageComponent(String fileNameImage){
        //Se intenta cargar la imagen definida con el URL de ubicación de la imagen
        try{
            this.image = new ImageIcon(ClassLoader.getSystemClassLoader().getResource(fileNameImage)).getImage();
        }catch(NullPointerException nullPointerException){
            System.err.println(nullPointerException);
            // Se carga una imagen de una equis para mostrar el error en pantalla
            this.image = new ImageIcon(ClassLoader.getSystemClassLoader().getResource(ImgApp.EQUIS.toString())).getImage();
        }
    }
    @Override
    public void paint(Graphics g){
        // Se dibuja la imagen con el tamaño del panel 
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);   //se quita la opacidad al botón
        super.paint(g);
    }
}
