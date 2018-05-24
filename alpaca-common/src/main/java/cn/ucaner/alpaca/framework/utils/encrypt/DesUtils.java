/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.alpaca.framework.utils.encrypt;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import cn.ucaner.alpaca.framework.constant.GlobalConstant;
import cn.ucaner.alpaca.framework.utils.date.UT;

/**
* @Package：cn.ucaner.framework.utils   
* @ClassName：DesUtils   
* @Description：   <p> 解码工具</p>
* @Author： - J 
* @CreatTime：2017年8月30日 下午2:14:03   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class DesUtils {
	
	/** 默认key */
	protected final static String KEY = "ScAKC0XhadTHT3Al0QIDAQAB";

	// 64
	final byte IP[] = { 58,50,42, 34,26,18,10,2,60,52,44,36,28,20,12,4,62,54, 46,38,30,
	        22,
	        14,
	        6,
	        64,
	        56,
	        48,
	        40,
	        32,
	        24,
	        16,
	        8,
	        57,
	        49,
	        41,
	        33,
	        25,
	        17,
	        9,
	        1,
	        59,
	        51,
	        43,
	        35,
	        27,
	        19,
	        11,
	        3,
	        61,
	        53,
	        45,
	        37,
	        29,
	        21,
	        13,
	        5,
	        63,
	        55,
	        47,
	        39,
	        31,
	        23,
	        15,
	        7 };

	// 64
	final byte IvnIP[] = { 40,
	        8,
	        48,
	        16,
	        56,
	        24,
	        64,
	        32,
	        39,
	        7,
	        47,
	        15,
	        55,
	        23,
	        63,
	        31,
	        38,
	        6,
	        46,
	        14,
	        54,
	        22,
	        62,
	        30,
	        37,
	        5,
	        45,
	        13,
	        53,
	        21,
	        61,
	        29,
	        36,
	        4,
	        44,
	        12,
	        52,
	        20,
	        60,
	        28,
	        35,
	        3,
	        43,
	        11,
	        51,
	        19,
	        59,
	        27,
	        34,
	        2,
	        42,
	        10,
	        50,
	        18,
	        58,
	        26,
	        33,
	        1,
	        41,
	        9,
	        49,
	        17,
	        57,
	        25 };
	// 48
	final byte E[] = { 32,
	        1,
	        2,
	        3,
	        4,
	        5,
	        4,
	        5,
	        6,
	        7,
	        8,
	        9,
	        8,
	        9,
	        10,
	        11,
	        12,
	        13,
	        12,
	        13,
	        14,
	        15,
	        16,
	        17,
	        16,
	        17,
	        18,
	        19,
	        20,
	        21,
	        20,
	        21,
	        22,
	        23,
	        24,
	        25,
	        24,
	        25,
	        26,
	        27,
	        28,
	        29,
	        28,
	        29,
	        30,
	        31,
	        32,
	        1 };
	// 32
	final byte P[] = { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 };

	// 8/4/16
	final byte SBoxes[][][] = { { { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
	        { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
	        { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
	        { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } },
	        {

	        { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
	                { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
	                { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
	                { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } },
	        {

	        { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
	                { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
	                { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
	                { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } },
	        {

	        { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
	                { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
	                { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
	                { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } },
	        {

	        { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
	                { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
	                { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
	                { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } },
	        {

	        { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
	                { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
	                { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
	                { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } },
	        {

	        { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
	                { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
	                { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
	                { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } },
	        {

	        { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
	                { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
	                { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
	                { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } } };

	// 56
	final byte PC_1[] = { 57,
	        49,
	        41,
	        33,
	        25,
	        17,
	        9,
	        1,
	        58,
	        50,
	        42,
	        34,
	        26,
	        18,
	        10,
	        2,
	        59,
	        51,
	        43,
	        35,
	        27,
	        19,
	        11,
	        3,
	        60,
	        52,
	        44,
	        36,
	        63,
	        55,
	        47,
	        39,
	        31,
	        23,
	        15,
	        7,
	        62,
	        54,
	        46,
	        38,
	        30,
	        22,
	        14,
	        6,
	        61,
	        53,
	        45,
	        37,
	        29,
	        21,
	        13,
	        5,
	        28,
	        20,
	        12,
	        4 };

	// 48
	final byte PC_2[] = { 14,
	        17,
	        11,
	        24,
	        1,
	        5,
	        3,
	        28,
	        15,
	        6,
	        21,
	        10,
	        23,
	        19,
	        12,
	        4,
	        26,
	        8,
	        16,
	        7,
	        27,
	        20,
	        13,
	        2,
	        41,
	        52,
	        31,
	        37,
	        47,
	        55,
	        30,
	        40,
	        51,
	        45,
	        33,
	        48,
	        44,
	        49,
	        39,
	        56,
	        34,
	        53,
	        46,
	        42,
	        50,
	        36,
	        29,
	        32 };

	// 16
	final byte ShiftTable[] = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };

	// 9
	private byte FKey[] = new byte[8];
	private byte FInputstring[] = new byte[8];

	// 16,48
	private byte FRoundKeys[][] = new byte[16][48];

	// 28
	private byte FC[] = new byte[28];
	private byte FD[] = new byte[28];

	// 64
	private byte FInputValue[] = new byte[64];
	private byte FOutputValue[] = new byte[64];

	// 32,32,32
	private byte FL[] = new byte[32];
	private byte FR[] = new byte[32];
	private byte FFunctionResult[] = new byte[32];

	private DesUtils() {

	}

	private void F(byte[] FK) {
		int Temp1[] = new int[48];
		int Temp2[] = new int[32];

		int n, h, i, j, Row, Column;

		for (n = 0; n < 48; n++)
			Temp1[n] = FR[E[n] - 1] ^ FK[n];

		for (n = 0; n < 8; n++) {
			i = n * 6;
			Row = Temp1[i] * 2 + Temp1[i + 5];
			Column = Temp1[i + 1] * 8 + Temp1[i + 2] * 4 + Temp1[i + 3] * 2 + Temp1[i + 4];
			j = n * 4;
			for (h = 0; h < 4; h++) {
				switch (h) {
				case 0:
					Temp2[j + h] = ( SBoxes[n][Row][Column] & 8 ) / 8;
					break;
				case 1:
					Temp2[j + h] = ( SBoxes[n][Row][Column] & 4 ) / 4;
					break;
				case 2:
					Temp2[j + h] = ( SBoxes[n][Row][Column] & 2 ) / 2;
					break;
				case 3:
					Temp2[j + h] = ( SBoxes[n][Row][Column] & 1 );
					break;
				default:
					break;
				}
			}
		}

		for (n = 0; n < 32; n++)
			FFunctionResult[n] = new Integer(Temp2[P[n] - 1]).byteValue();

	}

	private void Shift(byte[] SubKeyPart) {
		byte n, b;

		b = SubKeyPart[0];
		for (n = 0; n < 27; n++)
			SubKeyPart[n] = SubKeyPart[n + 1];
		SubKeyPart[27] = b;

	}

	private void SubKey(byte Round, byte[] SubKey) {
		int n, b;

		for (n = 0; n < ShiftTable[Round]; n++) {
			Shift(FC);
			Shift(FD);
		}
		for (n = 0; n < 48; n++) {
			b = PC_2[n];
			if (b < 29)
				SubKey[n] = FC[b - 1];
			else
				SubKey[n] = FD[b - 29];
		}

	}

	private void SetKeys() {
		byte n;
		byte Key[] = new byte[8];
		byte OldKey[] = new byte[64];

		for (n = 0; n < 8; n++)
			Key[n] = FKey[n];

		for (n = 0; n < 64; n++)
			OldKey[n] = GetBit(Key, n);

		for (n = 0; n < 28; n++) {
			FC[n] = OldKey[PC_1[n] - 1];
			FD[n] = OldKey[PC_1[n + 28] - 1];
		}
		for (n = 0; n < 16; n++)
			SubKey(n, FRoundKeys[n]);
	}

	private byte GetBit(byte[] Data, byte Index) {
		if ( ( Data[Index / 8] & ( 128 >> ( Index % 8 ) ) ) != 0)
			return 1;
		else
			return 0;

	}

	private void SetInputValue() {
		byte n;
		byte Key[] = new byte[8];

		for (int i = 0; i < 8; i++) {
			Key[i] = FInputstring[i];
		}
		for (n = 0; n < 64; n++) {
			FInputValue[n] = GetBit(Key, n);
		}
	}

	private void EncipherBLOCK() {
		int n, b, Round;

		for (n = 0; n < 64; n++)
			if (n < 32)
				FL[n] = FInputValue[IP[n] - 1];
			else
				FR[n - 32] = FInputValue[IP[n] - 1];

		for (Round = 0; Round < 16; Round++) {
			F(FRoundKeys[Round]);

			for (n = 0; n < 32; n++) {
				FFunctionResult[n] = new Integer(FFunctionResult[n] ^ FL[n]).byteValue();
			}

			for (n = 0; n < 32; n++) {
				FL[n] = FR[n];
				FR[n] = FFunctionResult[n];
			}
		}

		for (n = 0; n < 64; n++) {
			b = IvnIP[n];
			if (b < 33)
				FOutputValue[n] = FR[b - 1];
			else
				FOutputValue[n] = FL[b - 33];
		}

	}

	private void DecipherBLOCK() {
		byte n, b, Round;

		for (n = 0; n < 64; n++)
			if (n < 32)
				FL[n] = FInputValue[IP[n] - 1];
			else
				FR[n - 32] = FInputValue[IP[n] - 1];

		for (Round = 0; Round < 16; Round++) {
			F(FRoundKeys[15 - Round]);

			for (n = 0; n < 32; n++)
				FFunctionResult[n] = new Integer(FFunctionResult[n] ^ FL[n]).byteValue();
			for (n = 0; n < 32; n++) {
				FL[n] = FR[n];
				FR[n] = FFunctionResult[n];
			}
		}

		for (n = 0; n < 64; n++) {
			b = IvnIP[n];
			if (b < 33)
				FOutputValue[n] = FR[b - 1];
			else
				FOutputValue[n] = FL[b - 33];
		}

	}

	private void BeginWithKey(byte[] ClearText, byte[] Key) {
		for (int i = 0; i < 8; i++)
			FInputstring[i] = ClearText[i];
		if (Key != null)
			for (int i = 0; i < 8; i++)
				FKey[i] = Key[i];
		else
			for (int i = 0; i < 8; i++)
				FKey[i] = '!';
		SetInputValue();
		SetKeys();
	}

	public byte[] Encrypt(byte[] inText, byte[] Key) {
		int i, j, tmp;
		byte str[] = new byte[8];

		BeginWithKey(inText, Key);
		EncipherBLOCK();
		for (j = 0; j < 8; j++) {
			i = j * 8;
			tmp =
			        ( FOutputValue[i] * 8 + FOutputValue[i + 1] * 4 + FOutputValue[i + 2] * 2 + FOutputValue[i + 3] ) * 16 + FOutputValue[i + 4] * 8
			                + FOutputValue[i + 5] * 4 + FOutputValue[i + 6] * 2 + FOutputValue[i + 7];
			str[j] = (byte) ( tmp );
		}

		return str;

	}

	public byte[] Descrypt(byte[] inText, byte[] Key) {
		int i, j, tmp;
		byte str[] = new byte[8];
		BeginWithKey(inText, Key);

		DecipherBLOCK();

		for (j = 0; j < 8; j++) {
			i = j * 8;
			tmp =
			        ( FOutputValue[i] * 8 + FOutputValue[i + 1] * 4 + FOutputValue[i + 2] * 2 + FOutputValue[i + 3] ) * 16 + FOutputValue[i + 4] * 8
			                + FOutputValue[i + 5] * 4 + FOutputValue[i + 6] * 2 + FOutputValue[i + 7];
			str[j] = (byte) ( tmp );
		}
		return str;
	}

	/**
	 * 加密字符串
	 * @param msg
	 * @param random 随机数
	 * @return
	 */
	public static String encryptor(String msg, Integer random) {
		String keyStr = GlobalConstant.DES_KEY_PATH.concat(random.toString());
		DesUtils des = new DesUtils();
		byte[] key = keyStr.getBytes();
		byte[] bytes = msg.getBytes();

		byte[] in = new byte[8];
		byte[] out = new byte[8];

		int len = bytes.length;
		int i = len / 8;
		int j = len % 8;

		String cryMsg = "";
		if (j != 0)
			i += 1;

		for (int k = 0; k < i * 8; k++) {
			if (k > len - 1)
				in[k % 8] = new Byte("32").byteValue();
			else
				in[k % 8] = bytes[k];

			if (k == 0)
				continue;
			if ( ( k % 8 ) == 7) {
				out = des.Encrypt(in, key);
				// cryMsg += new String(out,"ISO-8859-1");
				cryMsg += UT.HexBytesToStr(out);
			}
		}
		return cryMsg;
	}

	/**
	 * 解密字符串
	 * @param msg
	 * @param random 随机数
	 * @return
	 */
	public static String decryptor(String msg, Integer random) {
		String keyStr = GlobalConstant.DES_KEY_PATH.concat(random.toString());
		DesUtils des = new DesUtils();
		byte[] key = keyStr.getBytes();
		byte[] bytes = new byte[8];

		bytes = UT.hexToBytes(msg);

		byte[] in = new byte[8];
		byte[] out = new byte[8];

		int len = bytes.length;
		int i = len / 8;
		int j = len % 8;

		String cryMsg = "";
		if (j != 0)
			i += 1;

		for (int k = 0; k < i * 8; k++) {
			if (k > len - 1)
				in[k % 8] = new Byte(" ").byteValue();
			else
				in[k % 8] = bytes[k];

			if (k == 0)
				continue;
			if ( ( k % 8 ) == 7) {
				out = des.Descrypt(in, key);
				cryMsg += new String(out);
				// cryMsg += UT(out);
			}
		}
		return cryMsg.trim();
	}
	
	
	/**
	 * DES加密
	 * @param data 待加密字符串
	 * @param key   校验位
	 * @return
	 */
    @SuppressWarnings("restriction")
	protected static String encrypt(String data,String key) {  
        String encryptedData = null;  
        try {  
            // DES算法要求有一个可信任的随机数源  
            SecureRandom sr = new SecureRandom();  
            DESKeySpec deskey = new DESKeySpec(key.getBytes());  
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            SecretKey secretKey = keyFactory.generateSecret(deskey);  
            // 加密对象  
            Cipher cipher = Cipher.getInstance("DES");  
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, sr);  
            // 加密，并把字节数组编码成字符串  
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));  
        } catch (Exception e) {  
            throw new RuntimeException("加密错误，错误信息：", e);  
        }  
        return encryptedData;  
    }  
	
    /**
     * DES解密
     * @param cryptData 待解密密文
     * @param key  校验位
     * @return
     */
    @SuppressWarnings("restriction")
	protected static String decrypt(String cryptData,String key) {  
        String decryptedData = null;  
        try {  
            // DES算法要求有一个可信任的随机数源  
            SecureRandom sr = new SecureRandom();  
            DESKeySpec deskey = new DESKeySpec(key.getBytes());  
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            SecretKey secretKey = keyFactory.generateSecret(deskey);  
            // 解密对象  
            Cipher cipher = Cipher.getInstance("DES");  
            cipher.init(Cipher.DECRYPT_MODE, secretKey, sr);  
            // 把字符串解码为字节数组，并解密  
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));  
        } catch (Exception e) {  
            throw new RuntimeException("解密错误，错误信息：", e);  
        }  
        return decryptedData;  
    }  
    
    /**
     * For Test By Jason
     * @param args
     */
    public static void main(String[] args) {
    	String encrypt = encrypt("Jason", "jason");
    	System.out.println(encrypt);
	}

}