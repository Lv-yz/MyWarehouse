package test;

import com.lv.dao.GoodsInMap;
import com.lv.pojo.StackInOrder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

public class GoodsInMapTest {
    @Test
    public void goodsInTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        GoodsInMap goodsInMap = (GoodsInMap) context.getBean("goodsInMap");

////        添加入库单
//        StackInOrder stackInOrder = new StackInOrder("1405","1301","飞旺辣条","垃圾食品","1101","飞旺集团",1,1000,"包",new Date());
//        StackInOrder stackInOrder1 = new StackInOrder("1406","1301","飞旺辣条","垃圾食品","1101","飞旺集团",1,1000,"包",new Date());
//        goodsInMap.insertGoodsIn(stackInOrder);
//        goodsInMap.insertGoodsIn(stackInOrder1);
//
////        获取所有入库单
//        StackInOrder[] stackInOrders = goodsInMap.selectAllStackInOrder();
//        System.out.println("获取所有的入库单!");
//        for (int i = 0; i < stackInOrders.length; i++) {
//            System.out.println(stackInOrders[i]);
//        }
////        获取所有指定货物的入库单
//        StackInOrder[] stackInOrders1 = goodsInMap.selectStackInOrderByGoodId("1301");
//        System.out.println("获取指定货物的入库单!");
//        System.out.println(Arrays.toString(stackInOrders1));
////        获取所有指定供应商的入库单
//        StackInOrder[] stackInOrders2 = goodsInMap.selectStackInOrderByProviderId("1101");
//        System.out.println("获取指定供应商的入库单!");
//        System.out.println(Arrays.toString(stackInOrders2));
//
//        System.out.println("通过指定入库id获取入库单!");
        StackInOrder stackInOrder2 = goodsInMap.selectStackInOrderByGoodInId("1417");
        System.out.println(stackInOrder2);
    }
}
