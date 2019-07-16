package cn.Servlet;

import cn.Dao.GoodDao;
import cn.Entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodsUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rows =0;
        String errMsg="";
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String goodsInfoName = req.getParameter("goodsInfoName");
            String goodsInfoPic = req.getParameter("goodsInfoPic");
            int goodsInfoPrice = Integer.parseInt(req.getParameter("goodsInfoPrice"));
            String goodsInfoDescription = req.getParameter("goodsInfoDescription");
            int goodsStock = Integer.parseInt(req.getParameter("goodsStock"));
            boolean goodsInfoFlag = Boolean.parseBoolean(req.getParameter("goodsInfoFlag"));

            Goods goods =new Goods(id,goodsInfoName,goodsInfoPic,goodsInfoPrice,goodsInfoDescription,goodsStock,goodsInfoFlag);
            GoodDao gDao = new GoodDao();
            rows = gDao.UpdateStudent(goods);

        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }

        PrintWriter out = resp.getWriter();
        if(rows>0){
            // 表示修改成功
            out.println("<script type='text/javascript'>alert('修改成功');location.href='goodsShowServlet';</script>");
        }else{
            // 修改失败
            out.println("<script type='text/javascript'>alert('修改失败："+errMsg+"');history.back();</script>");
        }

    }
}
