package servlet_magasin;

import exo.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="AddProduitMagasinServlet", value = "/magasin/addproduct")
public class AddProduitMagasinServlet extends HttpServlet {
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
                "    <title>Ajout de produits au magasin</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action = \"" + req.getContextPath() + "/magasin/addproduct\" method=\"post\">\n" +
                "        <p>Magasin        : " + service.getIdMagasin() + "</p>\n" +
                "        <p>Nom du magasin : " + service.getNomMagasin() + "</p>\n" +
                "        <input type=\"\"number\" name=\"id\" placeholder=\"Id produit\"><br>\n" +
//                "        <input type=\"\"text\" name=\"nom\" placeholder=\"nom\"><br>\n" +
//                "        <input type=\"\"text\" name=\"rue\" placeholder=\"rue\"><br>\n" +
//                "        <input type=\"\"number\" name=\"numero\" placeholder=\"numero\"><br>\n" +
//                "        <input type=\"\"text\" name=\"codepostal\" placeholder=\"codepostal\"><br>\n" +
//                "        <input type=\"\"text\" name=\"ville\" placeholder=\"ville\"><br>\n" +
//                "        <input type=\"\"number\" name=\"superficie\" placeholder=\"superficie\"><br>\n" +
                "        <button type= \"submit\">Enregistrer</button>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        try{
            int idProduit = Integer.parseInt(req.getParameter("id"));
            int idMagasin = service.getIdMagasin();

            if (prodmagservice.insertproduct(idMagasin, idProduit)) {
                resp.setStatus(300);
                resp.sendRedirect(req.getContextPath()+"/magasin/detail");
            } else {
                resp.setStatus(400);
                out.print("id déjà pris");
            }

//            Magasin m = new Magasin(uniqueid, nom, rue, ville, codepostal, numero, superficie);
//            out.println("J'ai récupéré des infos.");

        } catch (NumberFormatException ex) {
            resp.setStatus(400);
            out.print("Id produit invalide ou en double !");
        }
    }
}
