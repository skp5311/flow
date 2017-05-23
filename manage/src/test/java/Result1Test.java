import com.op.flow.manage.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 孟凡伟 on 2017/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring.xml")
public class Result1Test {

    @Resource
    private DemoService demoService;

    @Test
    public void testResult(){
        System.out.println(demoService.myBatisQueryCount());
    }
}
