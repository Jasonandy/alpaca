package cn.ucaner.alpaca.pay.reconciliation.utils.https;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

import javax.net.ssl.HttpsURLConnection;

/**
* @Package：cn.ucaner.alpaca.pay.reconciliation.utils.https   
* @ClassName：HttpResponse   
* @Description：   <p> HttpResponse </p>
* @Author： -    
* @CreatTime：2018年5月11日 上午10:25:59   
* @Modify By：   
* @ModifyTime：  2018年5月11日
* @Modify marker：   
* @version    V1.0
 */
public class HttpResponse implements Closeable {

    private InputStream inputStream;
    private HttpsURLConnection connection;

    public HttpResponse(HttpsURLConnection connection) throws IOException {
        this.connection = connection;
        this.inputStream = connection.getInputStream();
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public HttpsURLConnection getConnection() {
        return connection;
    }

    @Override
    public void close() throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
        if (connection != null) {
            connection.disconnect();
        }
    }

}