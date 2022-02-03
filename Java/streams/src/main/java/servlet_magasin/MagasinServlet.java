package servlet_magasin;

import exo.MagasinService;
import exo.MagasinServiceImpl;
import exo.models.Magasin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="MagasinServlet", value = "/magasin")
public class MagasinServlet extends HttpServlet{
    MagasinService service = MagasinServiceImpl.getinstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Magasin> listemagasin = service.getAllName();

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Liste magasins</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Liste des magasins</h1>\n" +
                "<ul>\n");

        listemagasin.forEach(magasin -> {
            out.print("<li>");
            out.print(magasin.getUniqueid() + " - " + magasin.getNom());
            out.println("</li>\n");
        });

        out.println("</ul>\n" +
                "<a href=\"" + req.getContextPath() + "/magasin/add\">Ajout magasin</a>   " +
                "<a href=\"" + req.getContextPath() + "/magasin/detail\">Détail magasin</a>    " +
                "<a href=\"" + req.getContextPath() + "\">Retour menu général</a>\n" +
                "</body>\n" +
                "</html>");
    }
}

