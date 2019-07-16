package cn.Servlet;

import cn.Dao.GoodDao;
import cn.Entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GoodsLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String errMsg ="";
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            if (id == 0 || "".equals(id)){
                throw new RuntimeException("商品编号不能为空"); }
            GoodDao goodDao = new GoodDao();
            Goods querygoods = new Goods(id);
            List<Goods> list = goodDao.FindByGoods(querygoods);
            if (list ==null || list.size()<1){
                throw  new RuntimeException("该商品编号找不到");
            }
            req.setAttribute("goods",list.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }
        if("".equals(errMsg)){
            // 表示取到数据
            req.getRequestDispatcher("GoodsUpdate.jsp").forward(req, resp);
        }else{
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('数据加载失败：'"+errMsg+");history.back();</script>");
        }
    }
}
