package servlet;

import exo.models.Produit;
import exo.ProduitService;
import exo.ProduitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet (name="ProdServlet", value = "/produit")
public class ProdServlet extends HttpServlet {
    ProduitService service = ProduitServiceImpl.getinstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produit> liste = service.getAll();

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Liste produits</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Liste des produits</h1>\n" +
                "<ul>\n");

        liste.forEach(produit -> {
                    out.print("<li>");
                    out.print(produit.getId());
                    out.print("  ");
                    out.print(produit.getNom());
                    out.print("  ");
                    out.print(produit.getMarque());
                    out.print("  ");
                    out.print(produit.getPrix());
                    out.println("</li>\n");
                });

        out.println("</ul>\n" +
                "<a href=\"" + req.getContextPath() + "/produit/add\">Ajout</a>\n" +
                "<a href=\"" + req.getContextPath() + "/produit/update\">Update</a>\n" +
                "<a href=\"" + req.getContextPath() + "\">Retour menu général</a>\n" +
                "</body>\n" +
                "</html>");
    }
}

