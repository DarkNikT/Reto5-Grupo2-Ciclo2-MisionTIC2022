package co.edu.utp.misiontic2022.c2.reto5.view;

import java.awt.Color;

/**
 * Enum para definir los colores del proyecto
 */
public enum ColorAPP {
    FONDO(0,57, 128),       // Color del fondo
    TITULO(255,250,250);    // Color del texto
    private Color color;
    private ColorAPP(int r, int g ,int b) {
        this.color = new Color(r, g, b);
    }
    // Método para retornar el Color
    public Color getColor(){
        return this.color;
    }
}
