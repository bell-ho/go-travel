package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTxServiceTest {
	@Setter(onMethod_=@Autowired)
	private SampleTxService service;
	
	@Test
	public void testLong() {
		String str="starry\r\n"
				+"Starry night\r\n"
				+"paint tour palette blue and grey\r\n"
				+"Look out on a summer's day";
		log.info(str.getBytes().length);
		service.addDate(str);
	}
}
