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
package cn.ucaner.alpaca.framework.utils.tools.geo;

import java.io.Serializable;

import cn.ucaner.alpaca.framework.utils.tools.core.util.StrUtil;

/**
* @Package：cn.ucaner.tools.geo   
* @ClassName：Location   
* @Description：   <p> 坐标位置</p>
* @Author： -  
* @CreatTime：2017-11-3 上午11:56:51   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class Location implements Serializable {
	private static final long serialVersionUID = 7457963026513014856L;
	
	/** 纬度 */
	private final double latitude;
	/** 经度 */
	private final double longitude;

	/**
	 * 构造
	 * @param latitude 纬度
	 * @param longitude 经度
	 */
	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		if (Math.abs(latitude) > 90 || Math.abs(longitude) > 180) {
			throw new IllegalArgumentException("The supplied coordinates " + this + " are out of range.");
		}
	}

	/**
	 * 构造
	 * @param other {@link Location}
	 */
	public Location(Location other) {
		this(other.latitude, other.longitude);
	}

	/**
	 * 获得纬度
	 * @return 纬度
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * 获得经度
	 * @return 经度
	 */
	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return StrUtil.format("({}, {})", this.latitude, this.longitude);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Location) {
			Location other = (Location) obj;
			return Double.valueOf(latitude).equals(Double.valueOf(other.latitude)) 
					&& Double.valueOf(longitude).equals(Double.valueOf(other.longitude));
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = 42;
		long latBits = Double.doubleToLongBits(latitude);
		long lonBits = Double.doubleToLongBits(longitude);
		result = 31 * result + (int) (latBits ^ (latBits >>> 32));
		result = 31 * result + (int) (lonBits ^ (lonBits >>> 32));
		return result;
	}
}
