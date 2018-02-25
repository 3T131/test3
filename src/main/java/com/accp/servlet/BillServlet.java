package com.accp.servlet;

import com.accp.biz.BillBiz;
import com.accp.biz.ProviderBiz;
import com.accp.biz.impl.BillBizImpl;
import com.accp.biz.impl.ProviderBizImpl;
import com.accp.entity.Bill;
import com.accp.entity.Provider;
import com.accp.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out= resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        BillBiz billImpl=new BillBizImpl();
        ProviderBiz providerBiz=new ProviderBizImpl();
        String method = req.getParameter("method");
         if(method.equals("query")){
            List<Provider> providerList = providerBiz.listByParam(new Provider());
            req.getSession().setAttribute("providerList",providerList);
            Bill bill=new Bill();
            if(req.getParameter("queryProductName")!=null&&req.getParameter("queryProductName")!=""){
                bill.setProductName(req.getParameter("queryProductName"));
            }
            if(req.getParameter("queryProviderId")!=null&&req.getParameter("queryProviderId")!=""){
                bill.setProviderId(Integer.parseInt(req.getParameter("queryProviderId")));
            }
            if(req.getParameter("queryIsPayment")!=null&&req.getParameter("queryIsPayment")!=""){
                bill.setIsPayment(Integer.parseInt(req.getParameter("queryIsPayment")));
            }
            List<Bill> billList = billImpl.listByParam(bill);
            req.setAttribute("billList",billList);
            req.getRequestDispatcher(req.getContextPath()+"jsp/billlist.jsp").forward(req,resp);
        }else if(method.equals("toModify")){
             Integer id=Integer.parseInt(req.getParameter("id"));
             Bill bill = billImpl.getById(id);
             req.setAttribute("bill",bill);
             req.getRequestDispatcher("jsp/billmodify.jsp").forward(req,resp);
         }else if(method.equals("doModify")){
             String id= req.getParameter("id");
             Bill bill = billImpl.getById(Integer.parseInt(id));
//             User user= (User)req.getSession().getAttribute("User");
//             bill.setModifyBy(user.getId());
             if(req.getParameter("billCode")!=null&&req.getParameter("billCode")!=""){
                 bill.setBillCode(req.getParameter("billCode"));
             }
             if(req.getParameter("productName")!=null&&req.getParameter("productName")!=""){
                 bill.setProductName(req.getParameter("productName"));
             }
             if(req.getParameter("productUnit")!=null&&req.getParameter("productUnit")!=""){
                 bill.setProductUnit(req.getParameter("productUnit"));
             }
             if(req.getParameter("productCount")!=null&&req.getParameter("productCount")!=""){
                 bill.setProductCount(Double.parseDouble(req.getParameter("productCount")));
             }
             if(req.getParameter("totalPrice")!=null&&req.getParameter("totalPrice")!=""){
                 bill.setTotalPrice(Double.parseDouble(req.getParameter("totalPrice")));
             }
             if(req.getParameter("pid")!=null&&req.getParameter("pid")!=""){
                 bill.setProviderId(Integer.parseInt(req.getParameter("pid")));
             }
             if(req.getParameter("isPayment")!=null&&req.getParameter("isPayment")!=""){
                 bill.setIsPayment(Integer.parseInt(req.getParameter("isPayment")));
             }
             if(req.getParameter("providerId")!=null&&req.getParameter("providerId")!=""){
                 bill.setProviderId(Integer.parseInt(req.getParameter("providerId")));
             }
             if(billImpl.modify(bill)){
                 resp.sendRedirect(req.getContextPath()+"/BillServlet?method=query");
             }else{
                 req.getRequestDispatcher("/BillServlet?method=toModify&id="+id).forward(req,resp);
             }
         }else if(method.equals("delbill")){
             Integer billid = Integer.parseInt(req.getParameter("billid"));
             if(billImpl.del(billid)){
                 out.print("{delResult:true}");
             }else{
                 out.print("{delResult:false}");
             }
         }

    }
}
