import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dante.biz.jms.service.IQueueSenderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-common.xml", "classpath:spring/spring-jms.xml" })
public class ProducerConsumerTest {

	@Autowired
	private IQueueSenderService queueSenderService;

	@Test
	public void testSend() {
		for (int i = 0; i < 2; i++) {
			queueSenderService.send("test.queue", "你好，生产者！这是消息：" + (i + 1));
		}
	}

}