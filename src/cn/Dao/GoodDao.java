package cn.Dao;

import cn.Entity.Goods;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodDao {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/firstproject?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "root";

    //数据库连接
    public Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //数据库关闭
    public void allClose(Connection con, Statement sta, ResultSet rs) {
        try {
            if (con != null) {
                con.close();
            }
            if (sta != null) {
                sta.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //通过ID 模糊商品名称，价格区间 查询数据
    public List<Goods> FindByGoods(Goods goods) {
        Connection con = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        List<Goods> list = new ArrayList<>();
        try {
            con = this.getConnection();
            StringBuffer sf = new StringBuffer();
            List<Object> paramlist = new ArrayList<>();
            sf.append(" select * from goodsinfo where 1=1 ");
            if (goods != null) {
                if (goods.getId() != 0) {
                    sf.append(" and id = ? ");
                    paramlist.add(goods.getId());
                }
                if (goods.getGoodsInfoName() != null) {
                    sf.append(" and goodsInfo_name like ? ");
                    paramlist.add("%"+goods.getGoodsInfoName()+"%");
                }
                if (goods.getFirstPrice() > 0) {
                    sf.append(" and goodsInfo_price >=?");
                    paramlist.add(goods.getFirstPrice());
                }
                if (goods.getEndPrice() > 0) {
                    sf.append(" and goodsInfo_price <=? ");
                    paramlist.add(goods.getEndPrice());
                }
            }
            pra = con.prepareStatement(sf.toString());
            if (paramlist != null && paramlist.size() > 0) {
                for (int i = 0; i < paramlist.size(); i++) {
                    pra.setObject(i+1, paramlist.get(i));
                }
            }
            rs = pra.executeQuery();
            while (rs.next()) {
                Goods goods1 = new Goods();
                goods1.setId(rs.getInt("id"));
                goods1.setGoodsInfoName(rs.getString("goodsInfo_name"));
                goods1.setGoodsInfoPic(rs.getString("goodsInfo_pic"));
                goods1.setGoodsInfoPrice(rs.getInt("goodsInfo_price"));
                goods1.setGoodsInfoDescription(rs.getString("goodsInfo_description"));
                goods1.setGoodsStock(rs.getInt("goods_stock"));
                goods1.setGoodsInfoFlag(rs.getBoolean("flag"));

                list.add(goods1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.allClose(con, pra, rs);
        }
        return list;
    }

    //修改数据
    public int UpdateStudent(Goods goods) {
        Connection con = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try {
            con = this.getConnection();
           String sql = "UPDATE goodsinfo SET goodsInfo_name =?,goodsInfo_pic =?,goodsInfo_price =?,goodsInfo_description =?,goods_stock =?,flag =? WHERE id=?";
            List<Object> paramlist = new ArrayList<>();
            paramlist.add(goods.getGoodsInfoName());
            paramlist.add(goods.getGoodsInfoPic());
            paramlist.add(goods.getGoodsInfoPrice());
            paramlist.add(goods.getGoodsInfoDescription());
            paramlist.add(goods.getGoodsStock());
            paramlist.add(goods.getGoodsInfoFlag());
            paramlist.add(goods.getId());
            pra = con.prepareStatement(sql);
            for (int i = 0; i < paramlist.size(); i++) {
                pra.setObject(i+1,paramlist.get(i));
            }
            int rows = pra.executeUpdate();

            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.allClose(con,pra,rs);
        }
        return 0;
    }




    @Test
    public void test(){
        Goods goods =null ;

        GoodDao gdsDao = new GoodDao();
        List<Goods> list =gdsDao.FindByGoods(goods);
        for (Goods s:list){
            System.out.println(s);
        }

    }
}
