package login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        String name = "";

        // Nhận cookie
        Cookie[] cookie = req.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {
                if (c.getName().equals("username")) {
                    name = c.getValue();
                }
            }
        }

        if (name.equals("")) {
            // chuyển sang trang LoginServlet
            resp.sendRedirect("/HelloServlet/login");
            return; // dừng lại sau khi redirect
        }

        // hiển thị lên trang bằng PrintWriter
        printWriter.println("Xin chao " + name);
    }
}
