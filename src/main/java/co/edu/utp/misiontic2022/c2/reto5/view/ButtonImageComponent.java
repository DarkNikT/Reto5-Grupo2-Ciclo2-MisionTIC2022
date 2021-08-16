package co.edu.utp.misiontic2022.c2.reto5.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JButton;



/**
 *
 * Clase creada para personalizar el botón por defecto
 * para agregarle una imagen de fondo, y una interacción con el hover.
 */
public class ButtonImageComponent extends JButton{
    private ImageIcon imageIcon;    
    private Image image;
    private ImageObserver imageObserver;
    
    private float alpha = 1f;   //Valor de transparencia min 0.0 - max 1.0
    private String textoBtn;    //Texto cuando ocurre el hover
    private String textoBtnTitle;   //texto botón normal
    /**
     * Constructor del boton personalizado
     * Parametros:
     * @param title Texto botón normal
     * @param text Texto botón con evento hover
     * @param fileNameImage Url de la imagen a definir como ImageIcon, relativo al directorio src/resources/
     */
    public ButtonImageComponent(String title, String text, String fileNameImage){        
        setFocusPainted(false);         // No se pinta el botón cuando se enfoca
        setBorderPainted(false);        // No pintar border
        setContentAreaFilled(false);    // No rellenar, boton transparente
        
        textoBtn = text;
        textoBtnTitle = title;
        setText(textoBtnTitle);
        setForeground(Color.WHITE);     //Color de texto Blanco
        setFont(new Font("Arial", Font.BOLD, 20));  //texto arial, negrita, tamaño 20
        
        //Se trata de crear un ImageIcon por medio de la URL de la imagen ingresada en el constructor.
        try{
            this.imageIcon = new ImageIcon(ClassLoader.getSystemClassLoader().getResource(fileNameImage));
        }catch(NullPointerException nullPointerException){
            System.err.println(nullPointerException);
            //Se carga una imagen de una equis, para visualizar el error en la pantalla
            this.imageIcon = new ImageIcon(ClassLoader.getSystemClassLoader().getResource(ImgApp.EQUIS.toString()));
        }
        this.image = imageIcon.getImage();      // Se obtiene la imagen desde el ImageIcon
        this.imageObserver = this.imageIcon.getImageObserver(); //Se obtiene un observador de la imagen
        
        // Darle funcionalidad del evento de Hover, dependiendo de la acción del mouse
        this.addMouseListener(new MouseAdapter() {
            // Cuando el mouse entra al área del botón
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setAlpha(0.4f);     //transparencia al botón
                setText(textoBtn);  //se muestra texto de descripción
            }
            // Cuando el mouse sale del área del botón
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setAlpha(1f);           // Se quita la transparencia la botón
                setText(textoBtnTitle); // Se coloca el texto de titulo del botón
            }
        });
    }
    // Función para colocarle transparencia al botón
    public void setAlpha(float alpha){
        this.alpha = alpha;
        repaint();
    }
    // Método para pintar la imagen en boton
    public void paint( Graphics g ) {
        super.paint( g );
        // se uda Graphipcs 2D para poder gestionar la transparencia
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.drawImage(image,  -(int)image.getWidth(imageObserver)/2 + (int)getWidth()/2, 50, image.getWidth(imageObserver) , image.getHeight(imageObserver) , imageObserver);
        super.paintComponent(g2);
    }
}