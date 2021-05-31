package test;

import com.lv.dao.GoodsOutMap;
import com.lv.pojo.OutboundOrder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

public class GoodsOutMapTest {
    @Test
    public void goodsOutTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        GoodsOutMap goodsOutMap = (GoodsOutMap) context.getBean("goodsOutMap");


        OutboundOrder outboundOrder = new OutboundOrder("1507","1301","飞旺辣条","垃圾食品","1201","金蓝",100,1,"包",new Date());
        OutboundOrder outboundOrder2 = new OutboundOrder("1508","1301","飞旺辣条","垃圾食品","1201","金蓝",100,1,"包",new Date());
        goodsOutMap.insertGoodsOut(outboundOrder);
        goodsOutMap.insertGoodsOut(outboundOrder2);

//        获取所有出库单信息
        OutboundOrder[] outboundOrders = goodsOutMap.selectAllOutboundOrder();
        for (int i = 0; i < outboundOrders.length; i++) {
            System.out.println(outboundOrders[i].toString());
        }

        OutboundOrder[] stackInOrders = goodsOutMap.selectOutboundOrderByCustomerId("1301");
        System.out.println(Arrays.toString(stackInOrders));

        System.out.println("通过id获取");
        OutboundOrder outboundOrder1 = goodsOutMap.selectOutboundOrderByGoodOutId("1501");
        System.out.println(outboundOrder1);
    }
}
