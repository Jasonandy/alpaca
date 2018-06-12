package cn.ucaner.alpaca.pay.permission.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.alibaba.fastjson.JSON;

import cn.ucaner.alpaca.pay.permission.entity.PmsOperator;

/**
* @Package：cn.ucner.alpaca.pay.permission.utils   
* @ClassName：PasswordHelper   
* @Description：   <p> 生成密码工具类</p>
* @Author： -    
* @CreatTime：2018年5月12日 下午12:33:07   
* @Modify By：   
* @ModifyTime：  2018年5月12日
* @Modify marker：   
* @version    V1.0
 */
public class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private static String algorithmName = "md5";

	private static String hashIteration = "2";

	private static int hashIterations = Integer.valueOf(hashIteration);

	public static void encryptPassword(PmsOperator pmsOperator) {

		pmsOperator.setsalt(randomNumberGenerator.nextBytes().toHex());

		String newPassword = new SimpleHash(algorithmName, pmsOperator.getLoginPwd(), ByteSource.Util.bytes(pmsOperator.getCredentialsSalt()), hashIterations).toHex();

		pmsOperator.setLoginPwd(newPassword);
	}

	/**
	 * 加密密码
	 * @param loginPwd
	 *            明文密码
	 * @param salt
	 * @return
	 */
	public static String getPwd(String loginPwd, String salt) {
		String newPassword = new SimpleHash(algorithmName, loginPwd, ByteSource.Util.bytes(salt), hashIterations).toHex();
		return newPassword;
	}
	
	/**
	 * @Description: Just for test 
	 * @Autor: Jason - jasonandy@hotail.com
	 */
	public static void main(String[] args) {
	/*	System.out.println(getPwd("admin", "8D78869F470951332959580424D4BF4F"));
		for (int i = 0; i < 2; i++) {
			System.out.println(getPwd("Jason", "123"));
		}*/
		
		PmsOperator pmsOperator = new  PmsOperator();
		pmsOperator.setLoginName("alpaca");
		pmsOperator.setLoginPwd("123456");
		encryptPassword(pmsOperator);
		System.out.println(pmsOperator.getsalt());
		System.out.println(JSON.toJSONString(pmsOperator));
		System.out.println(getPwd("f042d4512ff186992378fcc886255e6a", "3d34510388a7f5bf27065a373039c234"));
		
	}

}
//Outputs
//304ad365aa87bece81fc42edcff97a45

//812f4606bc59723fb4700340733827cf
//812f4606bc59723fb4700340733827cf
//812f4606bc59723fb4700340733827cf
