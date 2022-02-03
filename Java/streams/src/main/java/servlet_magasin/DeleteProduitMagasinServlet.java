package servlet_magasin;

import exo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="DeleteProduitMagasinServlet", value = "/magasin/deleteproduct")
public class DeleteProduitMagasinServlet extends HttpServlet {
    private final MagasinService service = MagasinServiceImpl.getinstance();
    private final ProduitService prodservice = ProduitServiceImpl.getinstance();
    private final ProduitMagasinService prodmagservice = ProduitMagasinServiceImpl.getinstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Suppression de produits au magasin</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Formulaire de suppression d'un produit d'un magasin</h1>\n" +
                "    <form action = \"" + req.getContextPath() + "/magasin/addproduct\" method=\"post\">\n" +
                "        <p>Magasin        : " + service.getIdMagasin() + " - " + service.getNomMagasin() + "</p>\n" +
                "        <p>Introduisez l'Id du produit à supprimer</p>\n" +
                "        <input type=\"\"number\" name=\"id\" placeholder=\"Id produit\"><br>\n" +
                "        <button type= \"submit\">Supprimer</button>\n" +
                "    </form>\n" +
                "<a href=\"" + req.getContextPath() + "/magasin\">Retour menu magasin</a>    " +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        try{
            int idProduit = Integer.parseInt(req.getParameter("id"));
            int idMagasin = service.getIdMagasin();

            if (prodmagservice.deleteproduct(idMagasin, idProduit)) {
                resp.setStatus(300);
                resp.sendRedirect(req.getContextPath()+"/magasin/detail");
            } else {
                resp.setStatus(400);
                out.print("Erreur");
            }
        } catch (NumberFormatException ex) {
            resp.setStatus(400);
            out.print("Id produit invalide !");
        }
    }
}
