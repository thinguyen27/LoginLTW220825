package login;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // GET: mở form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }

    // POST: xử lý đăng nhập
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if ("trung".equals(user) && "123".equals(pass)) {
            Cookie cookie = new Cookie("username", user);
            cookie.setMaxAge(30); // 30s
            cookie.setPath(req.getContextPath().isEmpty() ? "/" : req.getContextPath());
            resp.addCookie(cookie);

            resp.sendRedirect(req.getContextPath() + "/hello");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }
}
