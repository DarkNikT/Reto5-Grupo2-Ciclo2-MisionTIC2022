package co.edu.utp.misiontic2022.c2.reto5.view;

/**
 * Enum con el texto de descripción que se muestra en el botón, usando el formato html.
 */
public enum TextoBotones {
    REQUERIMIENTO1("<html><center>"+"Requerimiento 1"+"<br>"+"<br>"+"Obtener el nombre de la constructora, la fecha de inicio y la clasificación para la ciudad de 'Pereira'"+"</center></html>"),
    REQUERIMIENTO2("<html><center>"+"Requerimiento 2"+"<br>"+"<br>"+"Sumar las cantidades de la tabla Compra que se le han comprado al proveedor “Homecenter”."+"</center></html>"),
    REQUERIMIENTO3("<html><center>"+"Requerimiento 3"+"<br>"+"<br>"+"Mostrar de la tabla Líder el nombre, el primer apellido y segundo apellido en una sola columna \n" +
"separado por espacios en blanco, utilice el alias \"Nombre Líder\" de los que tengan como ciudad de \n" +
"residencia \"Londres”."+"</center></html>");;
    
    private String texto;

    private TextoBotones(String texto) {
        this.texto = texto;
    }
    // Método para retornar el texto de descripción
    public String getTexto(){
        return texto;
    }
    
}
