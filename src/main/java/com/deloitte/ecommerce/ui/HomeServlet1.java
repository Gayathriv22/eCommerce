package com.deloitte.ecommerce.ui;

import com.deloitte.ecommerce.dao.CustomerDaoImp;
import com.deloitte.ecommerce.entities.Customer;
import com.deloitte.ecommerce.service.CustomerService;
import com.deloitte.ecommerce.service.CustomerServiceImp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/second")
public class HomeServlet1 extends HttpServlet {

    private CustomerService service = new CustomerServiceImp(new CustomerDaoImp());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String signedOutVal = req.getParameter("signout");
        boolean sessionDestroyed = false;
        if (signedOutVal != null && signedOutVal.equals("true")) {
            session.invalidate();
            sessionDestroyed = true;
        }
        Object mobileObj = null;
        if (!sessionDestroyed) {
            mobileObj = session.getAttribute("mobile");
        }

        if (mobileObj == null || mobileObj.toString().isEmpty()) {
            resp.getWriter().println("you are not signed in yet");
            String signInLink = "<a href='/html/form.html'>Sign In </a> ";
            writer.println(signInLink);
            return;
        }
        String mob = mobileObj.toString();
        Customer customer = service.findCustomerByMobile(mob);
        String name = customer.getName();
        double balance = customer.getBalance();
        writer.println("welcome" + name);
        writer.println("your balance "+balance);
        String signOutLink = "<a href='/second?signOut=true'>Sign Out </a> ";
        writer.println(signOutLink);

    }


}
