package com.tao.test;

import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
//@TransactionConfiguration(transactionManager="txManager", defaultRollback=false)
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BaseTestTemplate {
	
}
