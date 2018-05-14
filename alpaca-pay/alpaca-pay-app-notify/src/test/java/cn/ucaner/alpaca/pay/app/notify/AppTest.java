package cn.ucaner.alpaca.pay.app.notify;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
* @Package：cn.ucaner.alpaca.pay.app.notify   
* @ClassName：AppTest   
* @Description：   <p> AppTest   </p>
* @Author： -    
* @CreatTime：2018年5月12日 下午1:49:50   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class AppTest extends TestCase {

	
	public AppTest( String testName ) {
        super( testName );
    }

    public static Test suite(){
        return new TestSuite( AppTest.class );
    }

    public void testApp(){
        assertTrue( true );
    }
}
