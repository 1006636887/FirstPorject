package cn.Servlet;

import cn.Dao.GoodDao;
import cn.Entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodDao gDao = new GoodDao();
        Goods goods =null;
        List<Goods> list = gDao.FindByGoods(goods);
        req.setAttribute("list",list);
        req.getRequestDispatcher("GoodsList.jsp").forward(req,resp);


    }
}
