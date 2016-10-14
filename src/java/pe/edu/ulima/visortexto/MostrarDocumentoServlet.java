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

        if (tipo.equals("pdf")) {

            resp.setContentType("application/pdf");
            ModoVisualizadorAdapter adapter= new PDFAdapter();
            
            ByteArrayOutputStream baos= adapter.renderizar(titulo, contenido);
            baos.writeTo(resp.getOutputStream());
            
            resp.getOutputStream().flush();
        } else if (tipo.equals("html")) {
            String htmlData="";
            htmlData+="<html>";
            htmlData+="<head>";
            htmlData+="<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"/>";
            htmlData+="</head>";
            htmlData+="<body class='container'>";
            htmlData+="<h1>" + titulo + "</h1>";
            htmlData+="<div class=\"panel panel-default\">";
            htmlData+="<div class=\"panel-body\">" + contenido + "</div>";
            htmlData+="</div?";
            htmlData+="</body>";
            htmlData+="</html>";
            /*
            PrintWriter out = resp.getWriter();
            out.print("<html>");
            out.print("<head>");
            out.print("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"/>");
            out.print("</head>");
            out.print("<body class='container'>");
            out.print("<h1>" + titulo + "</h1>");
            out.print("<div class=\"panel panel-default\">");
            out.print("<div class=\"panel-body\">" + contenido + "</div>");
            out.print("</div?");
            out.print("</body>");
            out.print("</html>");*/
            ByteArrayOutputStream baos= new ByteArrayOutputStream();
            baos.write(htmlData.getBytes());
            baos.writeTo(resp.getOutputStream());
            resp.getOutputStream().flush();
        }

    }

   

}
