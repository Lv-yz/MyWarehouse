package test;

import com.lv.dao.ProviderMap;
import com.lv.pojo.Provider;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderMapTest {
    @Test
    public void providerTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        ProviderMap bean = (ProviderMap) context.getBean("providerMap");
//        插入供应商
        System.out.println("插入供应商信息!");
        bean.insertProvider(new Provider("1101","卫龙食品","中国天津","17493029532"));
        bean.insertProvider(new Provider("1102","卫龙食品","中国天津","17493029532"));
//        查询所有供应商信息
        Provider[] providers = bean.selectAllProvider();
        System.out.println("获取所有供应商信息!");
        for (int i = 0; i < providers.length; i++) {
            System.out.println(providers[i]);
        }
//        查询指定id的供应商
        Provider provider = bean.selectProviderById("1101");
        System.out.println("查询指定id的供应商");
        System.out.println(provider);

//        更新供应商
        bean.updateProvider(new Provider("1101","飞旺集团","中国天津","17493029532"));
        provider = bean.selectProviderById("1101");
        System.out.println("更新供应商!");
        System.out.println(provider);

//        删除供应商
        bean.deleteProviderById("1101");
        providers = bean.selectAllProvider();
        System.out.println("删除供应商!");
        for (int i = 0; i < providers.length; i++) {
            System.out.println(providers[i]);
        }
    }
}
