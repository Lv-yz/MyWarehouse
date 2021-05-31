package test;

import com.lv.dao.GoodsMap;
import com.lv.pojo.Goods;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GoodsMapTest {
    @Test
    public void goodsTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");

        GoodsMap goodsMap = (GoodsMap) context.getBean("goodsMap");

//        插入方法
        goodsMap.insertGoods(new Goods("1303","飞旺辣条","垃圾食品",0,"包"));
        goodsMap.insertGoods(new Goods("1304","飞旺辣条","垃圾食品",0,"包"));
//        搜索所有的货物
        Goods[] goods = goodsMap.selectAllGoods();
        System.out.println("搜索所有货物!");
        for (int i = 0; i < goods.length; i++) {
            System.out.println(goods[i]);
        }
//        搜索指定id的货物
        Goods goods1 = goodsMap.selectGoodsById("1303");
        System.out.println("搜索指定id的货物!");
        System.out.println(goods1);
//        更新货物
        goodsMap.updateGoods(new Goods("1304","卫龙辣条","垃圾食品",0,"包"));
        goods = goodsMap.selectAllGoods();
        System.out.println("更新货物!");
        for (int i = 0; i < goods.length; i++) {
            System.out.println(goods[i]);
        }
//        删除货物
        goodsMap.deleteGoodsById("1302");
        goods = goodsMap.selectAllGoods();
        System.out.println("删除货物!");
        for (int i = 0; i < goods.length; i++) {
            System.out.println(goods[i]);
        }

    }
}
