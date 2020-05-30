package com.music.app;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ServiceLayerTests.class, ControllerLayerTests.class})
@SpringBootTest
public class MusicAppApplicationTests {


}
