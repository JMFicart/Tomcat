package servlet_magasin;

import exo.MagasinService;
import exo.MagasinServiceImpl;
import exo.ProduitMagasinService;
import exo.ProduitMagasinServiceImpl;
import exo.models.Magasin;
import exo.models.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="DetailMagasinServlet", value = "/magasin/detail")
public class DetailMagasinServlet extends HttpServlet {
    private final MagasinService service = MagasinServiceImpl.getinstance();
    private final ProduitMagasinService pms = ProduitMagasinServiceImpl.getinstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Détail d'un magasin</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action = \"" + req.getContextPath() + "/magasin/detail\" method=\"post\">\n" +
                "        <input type=\"\"number\" name=\"id\" placeholder=\"id\"><br>\n" +
                "        <button type= \"submit\">Envoyer</button>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        int uniqueid = Integer.parseInt(req.getParameter("id"));
        Magasin magasin = service.getOne(uniqueid);

        if (magasin != null) {
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Détail d'un magasin</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>Détail magasin</h1>\n" +
                    "\n");

            out.print("<p>Id          : " + magasin.getUniqueid() + "</p>\n" +
                        "<p>Nom         : " + magasin.getNom() + "</p>\n" +
                        "<p>Rue         : " + magasin.getRue() + "</p>\n" +
                        "<p>Numéro      : " + magasin.getNumero() + "</p>\n" +
                        "<p>Code postal : " + magasin.getCodepostal() + "</p>\n" +
                        "<p>Ville       : " + magasin.getVille() + "</p>\n" +
                        "<p>Superficie  : " + magasin.getSuperficie() + "</p>\n");

            List<Produit> lstproduit = pms.getAllbyMagasin(uniqueid);
            if (lstproduit != null) {
                out.print("\n");
                for (Produit produit : lstproduit) {
                    out.print("<p>" + produit.getId() + "   " +
                            produit.getNom() + "   " +
                            produit.getMarque() + "   " +
                            produit.getPrix() + "</p>\n");
                }
            }

            out.println("\n" +
                    "<a href=\"" + req.getContextPath() + "/magasin\">Retour magasin</a>    " +
                    "<a href=\"" + req.getContextPath() + "/magasin/addproduct\">Ajouter produit</a>    " +
                    "</body>\n" +
                    "</html>");
        }
    }
}
