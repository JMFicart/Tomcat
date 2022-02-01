package servlet;

import exo.Exceptions.ProduitNotFoundException;
import exo.ProduitService;
import exo.ProduitServiceImpl;
import exo.models.Produit;
import exo.models.ProduitForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "UpdProduitServlet",value = "/produit/update")
public class UpdateProduitServlet extends HttpServlet {

    private final ProduitService service = ProduitServiceImpl.getinstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Mise à jour de produit</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action = \"" + req.getContextPath() + "/produit/update\" method=\"post\">\n" +
                "        <input type=\"\"text\" name=\"id\" placeholder=\"id\"><br>\n" +
                "        <input type=\"\"text\" name=\"nom\" placeholder=\"nom\"><br>\n" +
                "        <input type=\"\"text\" name=\"prix\" placeholder=\"prix\"><br>\n" +
                "        <button type= \"submit\">Envoyer</button>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        try{
            int id = Integer.parseInt(req.getParameter("id"));
            String nom = req.getParameter("nom");
            double prix = Double.parseDouble(req.getParameter("prix"));

            service.update(id, new ProduitForm(nom, prix));
            resp.setStatus(300);
            resp.sendRedirect(req.getContextPath()+"/produit");
        } catch (NumberFormatException ex) {
            resp.setStatus(400);
            out.print("Id ou prix invalide !");
        } catch (ProduitNotFoundException ex) {
            resp.setStatus(404);
        }
    }
}
