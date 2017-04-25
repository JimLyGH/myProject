package com.jimly.kayak.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Junit.class, Junit001.class })

/**
 * 用TestSuite来统一管理测试类
 * */
public class TestSuite {
	
}
