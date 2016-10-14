package pe.edu.ulima.visortexto;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MostrarDocumentoServlet", urlPatterns = {"/mostrar"})
public class MostrarDocumentoServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {

        String titulo = req.getParameter("titulo");
        String contenido = req.getParameter("contenido");
        String tipo = req.getParameter("tipo");

       GestionRenderizado gestor= GestionRenderizado.getInstance();
            ByteArrayOutputStream baos=  gestor.renderizar(titulo, contenido, tipo);
            baos.writeTo(resp.getOutputStream());
            resp.getOutputStream().flush();
        }

    }

   

}
