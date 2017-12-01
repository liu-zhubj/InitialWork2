package com.xiaozl.initialwork1;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

/**
 * @author xiaozl
 * @date 2017/11/20
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring*.xml"})
public abstract class AbstractTestCase extends TestCase {
}
