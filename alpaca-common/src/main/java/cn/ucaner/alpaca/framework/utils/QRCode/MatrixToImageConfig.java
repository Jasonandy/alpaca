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
package cn.ucaner.alpaca.framework.utils.QRCode;

import java.awt.image.BufferedImage;

/**
* @Package：cn.ucaner.common.utils.QRCode   
* @ClassName：MatrixToImageConfig   
* @Description：   <p> MatrixToImageConfig</p>
* @Author： - Jason 
* @CreatTime：2017年10月26日 上午10:48:20   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public final class MatrixToImageConfig {

  public static final int BLACK = 0xFF000000;
  public static final int WHITE = 0xFFFFFFFF;
  
  private final int onColor;
  private final int offColor;

  /**
   * Creates a default config with on color {@link #BLACK} and off color {@link #WHITE}, generating normal
   * black-on-white barcodes.
   */
  public MatrixToImageConfig() {
    this(BLACK, WHITE);
  }

  /**
   * @param onColor pixel on color, specified as an ARGB value as an int
   * @param offColor pixel off color, specified as an ARGB value as an int
   */
  public MatrixToImageConfig(int onColor, int offColor) {
    this.onColor = onColor;
    this.offColor = offColor;
  }

  public int getPixelOnColor() {
    return onColor;
  }

  public int getPixelOffColor() {
    return offColor;
  }

  int getBufferedImageColorModel() {
    // Use faster BINARY if colors match default
//    return onColor == BLACK && offColor == WHITE ? BufferedImage.TYPE_BYTE_BINARY : BufferedImage.TYPE_INT_RGB;
	  return BufferedImage.TYPE_INT_ARGB;
  }

}