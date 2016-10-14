package pe.edu.ulima.visortexto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;

public interface ModoVisualizadorAdapter {

    public ByteArrayOutputStream renderizar(String titulo, String contenido) throws IOException ;
}
