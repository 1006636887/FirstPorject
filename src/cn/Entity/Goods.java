package cn.Entity;

public class Goods {
    private int id;  //商品编号
    private String goodsInfoName; //商品名字
    private String goodsInfoPic; //商品图片
    private int goodsInfoPrice; //商品价格
    private String goodsInfoDescription; //商品简介
    private int goodsStock; //商品库存
    private Boolean goodsInfoFlag; //状态值

    private int firstPrice;
    private int endPrice;

    public Goods() {
    }

    public Goods(int id) {
        this.id = id;
    }

    public Goods(int firstPrice, int endPrice) {
        this.firstPrice = firstPrice;
        this.endPrice = endPrice;
    }

    public Goods(int id, String goodsInfoName, String goodsInfoPic, int goodsInfoPrice, String goodsInfoDescription, int goodsStock, boolean goodsInfoFlag) {
        this.id = id;
        this.goodsInfoName = goodsInfoName;
        this.goodsInfoPic = goodsInfoPic;
        this.goodsInfoPrice = goodsInfoPrice;
        this.goodsInfoDescription = goodsInfoDescription;
        this.goodsStock = goodsStock;
        this.goodsInfoFlag = goodsInfoFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsInfoName() {
        return goodsInfoName;
    }

    public void setGoodsInfoName(String goodsInfoName) {
        this.goodsInfoName = goodsInfoName;
    }

    public String getGoodsInfoPic() {
        return goodsInfoPic;
    }

    public void setGoodsInfoPic(String goodsInfoPic) {
        this.goodsInfoPic = goodsInfoPic;
    }

    public int getGoodsInfoPrice() {
        return goodsInfoPrice;
    }

    public void setGoodsInfoPrice(int goodsInfoPrice) {
        this.goodsInfoPrice = goodsInfoPrice;
    }

    public String getGoodsInfoDescription() {
        return goodsInfoDescription;
    }

    public void setGoodsInfoDescription(String goodsInfoDescription) {
        this.goodsInfoDescription = goodsInfoDescription;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public boolean getGoodsInfoFlag() {
        return goodsInfoFlag;
    }

    public void setGoodsInfoFlag(boolean goodsInfoFlag) {
        this.goodsInfoFlag = goodsInfoFlag;
    }

    public int getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(int firstPrice) {
        this.firstPrice = firstPrice;
    }

    public int getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(int endPrice) {
        this.endPrice = endPrice;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsInfoName='" + goodsInfoName + '\'' +
                ", goodsInfoPic='" + goodsInfoPic + '\'' +
                ", goodsInfoPrice=" + goodsInfoPrice +
                ", goodsInfoDescription='" + goodsInfoDescription + '\'' +
                ", goodsStock=" + goodsStock +
                ", goodsInfoFlag='" + goodsInfoFlag + '\'' +
                '}';
    }
}
