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

@WebServlet(name= "AddProduitServlet",value = "/produit/add")
public class AddProduitServlet extends HttpServlet {

    private final ProduitService service = ProduitServiceImpl.getinstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Ajout de produit</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action = \"" + req.getContextPath() + "/produit/add\" method=\"post\">\n" +
                "        <input type=\"\"text\" name=\"id\" placeholder=\"id\"><br>\n" +
                "        <input type=\"\"text\" name=\"nom\" placeholder=\"nom\"><br>\n" +
                "        <input type=\"\"text\" name=\"marque\" placeholder=\"marque\"><br>\n" +
                "        <input type=\"\"number\" name=\"prix\" placeholder=\"prix\"><br>\n" +
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
            String marque = req.getParameter("marque");
            double prix = Double.parseDouble(req.getParameter("prix"));

            if(nom==null || nom.isBlank() ||marque == null || marque.isBlank()){
                resp.setStatus(400);
                out.print("Marque ou nom non défini !");
            } else {
                Produit p = new Produit(id, nom, marque, prix);
                if (service.insert(p)) {
                    resp.setStatus(300);
                    resp.sendRedirect(req.getContextPath()+"/produit");
                } else {
                    resp.setStatus(400);
                    out.print("id déjà pris");
                }
            }

            Produit p = new Produit(id,nom, marque, prix);
            out.println("J'ai récupéré des infos.");

        } catch (NumberFormatException ex) {
            resp.setStatus(400);
            out.print("Id ou prix invalide !");
        }
    }
}

