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

@WebServlet(name="AddMagasinServlet", value = "/magasin/add")
public class AddMagasinServlet extends HttpServlet {
    private final MagasinService service = MagasinServiceImpl.getinstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Ajout de magasin</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Formulaire d'ajout d'un magasin</h1>\n" +
                "    <form action = \"" + req.getContextPath() + "/magasin/add\" method=\"post\">\n" +
                "        <input type=\"\"number\" name=\"id\" placeholder=\"id\"><br>\n" +
                "        <input type=\"\"text\" name=\"nom\" placeholder=\"nom\"><br>\n" +
                "        <input type=\"\"text\" name=\"rue\" placeholder=\"rue\"><br>\n" +
                "        <input type=\"\"number\" name=\"numero\" placeholder=\"numero\"><br>\n" +
                "        <input type=\"\"text\" name=\"codepostal\" placeholder=\"codepostal\"><br>\n" +
                "        <input type=\"\"text\" name=\"ville\" placeholder=\"ville\"><br>\n" +
                "        <input type=\"\"number\" name=\"superficie\" placeholder=\"superficie\"><br>\n" +
                "        <button type= \"submit\">Envoyer</button>\n" +
                "    </form>\n" +
                "<a href=\"" + req.getContextPath() + "/magasin\">Retour menu magasin</a>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        try{
            int uniqueid = Integer.parseInt(req.getParameter("id"));
            String nom = req.getParameter("nom");
            String rue = req.getParameter("rue");
            String ville = req.getParameter("ville");
            String codepostal = req.getParameter("codepostal");
            int numero = Integer.parseInt(req.getParameter("numero"));
            double superficie = Double.parseDouble(req.getParameter("superficie"));

            if(nom==null || nom.isBlank()){
                resp.setStatus(400);
                out.print("Nom non défini !");
            } else {
                Magasin m = new Magasin(uniqueid, nom, rue, ville, codepostal, numero, superficie);
                if (service.insert(m)) {
                    resp.setStatus(300);
                    resp.sendRedirect(req.getContextPath()+"/magasin");
                } else {
                    resp.setStatus(400);
                    out.print("id déjà pris");
                }
            }

            Magasin m = new Magasin(uniqueid, nom, rue, ville, codepostal, numero, superficie);
            out.println("J'ai récupéré des infos.");

        } catch (NumberFormatException ex) {
            resp.setStatus(400);
            out.print("Id, numéro ou superficie invalide !");
        }
    }
}
