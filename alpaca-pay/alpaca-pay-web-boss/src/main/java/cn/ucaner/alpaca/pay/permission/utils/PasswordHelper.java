package cn.ucaner.alpaca.pay.permission.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

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
		System.out.println(getPwd("Jason", "123"));
		for (int i = 0; i < 2; i++) {
			System.out.println(getPwd("Jason", "123"));
		}
	}

}
//Outputs
//812f4606bc59723fb4700340733827cf

//812f4606bc59723fb4700340733827cf
//812f4606bc59723fb4700340733827cf
//812f4606bc59723fb4700340733827cf
