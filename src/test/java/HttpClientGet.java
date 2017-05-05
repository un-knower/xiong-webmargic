import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * HttpClient使用GET方式通过代理服务器读取页面的例子。
 *
 * @author JAVA世纪网(java2000.NET, laozizhu.com)
 */
public class HttpClientGet {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例
        HttpGet httpGet = new HttpGet("http://www.taobao.com"); // 创建httpget实例
        HttpHost proxy = new HttpHost("171.38.189.245", 8123);
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        httpGet.setConfig(requestConfig);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        CloseableHttpResponse response = httpClient.execute(httpGet); // 执行http get请求
        HttpEntity entity = response.getEntity(); // 获取返回实体
        System.out.println("网页内容：" + EntityUtils.toString(entity, "utf-8")); // 获取网页内容
        response.close(); // response关闭
        httpClient.close(); // httpClient关闭
    }
}