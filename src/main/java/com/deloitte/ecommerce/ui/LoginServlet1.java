package com.deloitte.ecommerce.ui;
import com.deloitte.ecommerce.dao.CustomerDaoImp;
import com.deloitte.ecommerce.service.CustomerService;
import com.deloitte.ecommerce.service.CustomerServiceImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/first")
public class LoginServlet1 extends HttpServlet {

    private CustomerService service=new CustomerServiceImp(new CustomerDaoImp());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String mobile = req.getParameter("mobile");
        String password = req.getParameter("password");
        boolean correct=service.credentialsCorrect(mobile,password);
        System.out.println(correct);
        if (correct) {
            HttpSession session=req.getSession();
            session.setAttribute("mobile",mobile);
            resp.sendRedirect("/second");
        }else {
            resp.sendRedirect("html/form.html");
        }
    }


}
