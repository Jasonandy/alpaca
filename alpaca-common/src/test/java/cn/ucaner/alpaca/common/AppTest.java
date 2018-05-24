package cn.ucaner.alpaca.common;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
* @Package：cn.ucaner.alpaca.common   
* @ClassName：AppTest   
* @Description：   <p> Just for Test</p>
* @Author： -    
* @CreatTime：2018年5月24日 下午2:42:20   
* @Modify By：   
* @ModifyTime：  2018年5月24日
* @Modify marker：   
* @version    V1.0
 */
public class AppTest  extends TestCase{
  
	
    public AppTest( String testName ){
        super( testName );
    }

    public static Test suite(){
        return new TestSuite( AppTest.class );
    }

    public void testApp(){
        assertTrue( true );
    }
}
