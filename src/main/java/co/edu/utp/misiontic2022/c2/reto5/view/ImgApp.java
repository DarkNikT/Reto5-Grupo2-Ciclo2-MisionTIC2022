package co.edu.utp.misiontic2022.c2.reto5.view;

/**
 * Enum para definir la ubicacion de las imagenes requeridas en el proyecto.
 */
public enum ImgApp {
    LOGO_UTP("\\imagenes\\Logo_UTP.png"),
    EQUIS("\\imagenes\\equis.png"),
    LOGO_MISIONTIC("\\imagenes\\Logo_misiontic.png"),
    IMG_REQ_1("\\imagenes\\casco.jpg"),
    IMG_REQ_2("\\imagenes\\SumaCompras.jpg"),
    IMG_REQ_3("\\imagenes\\LiderConstruccion.jpg");
        
    private String fileNameString;

    private ImgApp(String file) {
        this.fileNameString = file;
    }
    // Devolver el valor del Path de la imagen
    @Override
    public String toString() {
        return this.fileNameString;
    }
    
    
}
