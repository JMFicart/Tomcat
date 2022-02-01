package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RequestServlet", value = "/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        PrintWriter out = resp.getWriter();

        String method = req.getMethod();
        String uri = req.getRequestURI();
        String protocol = req.getProtocol();

        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headernames = req.getHeaderNames();

        while(headernames.hasMoreElements()){
            String header = headernames.nextElement();
            headers.put(header, req.getHeader(header));
        }

        String body = req.getReader()
                .lines()
                .reduce("",(acc, line) -> acc + line);

        out.print(method);
        out.print(' ');
        out.print(uri);
        out.print(' ');
        out.println(protocol);

        headers.forEach((key,value) -> out.println(key + " : " + value));
        out.println();

        out.print(body);
    }
}
