package ru.kfu.itis;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by mg on 27.12.14.
 */
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter pw = resp.getWriter();

        pw.write("<b>EqwRROR!</b>");
        try {
            WorkWithDB.initializeConnection("user", "password");
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/Hell.jsp");
//            System.out.println("!!!");
            rd.forward(req,resp);
//            System.out.println("!!!!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            pw.write("<b>ERROR!</b>");

        } catch (SQLException e) {
            e.printStackTrace();
            pw.write("<b>ERROR!</b>");
        }finally{
            pw.close();
        }

    }
}
