package cn.ucaner.alpaca.pay.app.order.polling;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
* @Package：cn.ucaner.alpaca.pay.app.order.polling   
* @ClassName：AppTest   
* @Description：   <p> Unit test for simple App.</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午2:02:17   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class AppTest extends TestCase {
	
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
