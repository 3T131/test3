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

public class ProviderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out= resp.getWriter();
        BillBiz billImpl=new BillBizImpl();
        ProviderBiz providerBiz=new ProviderBizImpl();
        String method = req.getParameter("method");
        if(method.equals("query")){
            Provider provider = new Provider();
            if(req.getParameter("queryProCode")!=null&&req.getParameter("queryProCode")!=""){
                provider.setProCode(req.getParameter("queryProCode"));
            }
            if(req.getParameter("queryProName")!=null&&req.getParameter("queryProName")!=""){
                provider.setProName(req.getParameter("queryProName"));
            }
            List<Provider> providerList = providerBiz.listByParam(provider);
            req.setAttribute("providerList",providerList);
            req.getRequestDispatcher("jsp/providerlist.jsp").forward(req,resp);
        }else if(method.equals("toModify")){
            Integer id=Integer.parseInt(req.getParameter("id"));
            Provider provider = providerBiz.getProviderById(id);
            req.setAttribute("provider",provider);
            req.getRequestDispatcher("jsp/providermodify.jsp").forward(req,resp);
        }else if(method.equals("doMethod")){
            String id= req.getParameter("id");
            Provider provider = providerBiz.getProviderById(Integer.parseInt(id));
//            User user= (User)req.getSession().getAttribute("User");
//            provider.setModifyBy(user.getId());
            if(req.getParameter("proCode")!=null&&req.getParameter("proCode")!=""){
                provider.setProCode(req.getParameter("proCode"));
            }
            if(req.getParameter("proName")!=null&&req.getParameter("proName")!=""){
                provider.setProName(req.getParameter("proName"));
            }
            if(req.getParameter("proContact")!=null&&req.getParameter("proContact")!=""){
                provider.setProContact(req.getParameter("proContact"));
            }
            if(req.getParameter("proPhone")!=null&&req.getParameter("proPhone")!=""){
                provider.setProPhone(req.getParameter("proPhone"));
            }
            if(req.getParameter("proAddress")!=null&&req.getParameter("proAddress")!=""){
                provider.setProAddress(req.getParameter("proAddress"));
            }
            if(req.getParameter("proFax")!=null&&req.getParameter("proFax")!=""){
                provider.setProFax(req.getParameter("proFax"));
            }
            if(req.getParameter("proDesc")!=null&&req.getParameter("proDesc")!=""){
                provider.setProDesc(req.getParameter("proDesc"));
            }
            if(providerBiz.modify(provider)){
                resp.sendRedirect(req.getContextPath()+"/ProviderServlet?method=query");
            }else{
                req.getRequestDispatcher("/ProviderServlet?method=toModify&id="+id).forward(req,resp);
            }
        }else if (method.equals("delprovider")){
                Integer id = Integer.parseInt(req.getParameter("proid"));
            Bill bill= new Bill();
            bill.setProviderId(id);
            List<Bill> billList = billImpl.listByParam(bill);
            if(billList!=null&&billList.size()>0){
                out.print("{delResult:"+billList.size()+"}");
            }else{
                if(providerBiz.del(id)){
                    out.print("{delResult:true}");
                }else{
                    out.print("{delResult:false}");
                }
            }
        }

    }
}
