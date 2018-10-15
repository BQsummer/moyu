package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.intellij.ide.plugins.PluginManager;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    /**
     * 请求api，并反序列成对应的类的list
     *
     * @param url   url
     * @param param 参数
     * @param type  对应的类
     * @param <T>   泛型
     * @return list<T>
     */
    public static <T> List<T> httpGetList(String url, Map<String, String> param, Class<T> type) {
        String result = httpRequest(url, param);
        // convert json to object
        if(StringUtils.isNotBlank(result)) {
            return JSON.parseObject(result, new TypeReference<List<T>>(type) {});
        } else {
            return null;
        }
    }

    /**
     * 请求api，并反序列成对应类
     *
     * @param url   url
     * @param param url的参数
     * @param type  对应的类
     * @param <T>   泛型
     * @return T
     */
    public static <T> T httpGet(String url, Map<String, String> param, Class<T> type) {
        String result = httpRequest(url, param);
        // convert json to object
        if (StringUtils.isNotBlank(result)) {
            return JSON.parseObject(result, new TypeReference<T>(type) {
            });
        } else {
            return null;
        }
    }

    /**
     * http请求
     *
     * @param url   url
     * @param param 参数
     * @return
     */
    public static String httpRequest(String url, Map<String, String> param) {
        String result = "";
        BufferedReader in = null;
        StringBuilder builder = new StringBuilder(url);
        try {
            // append params
            if (param != null && param.size() > 0) {
                builder.append("?");
                for (String key : param.keySet()) {
                    builder.append(key).append("=").append(param.get(key)).append("&");
                }
                builder.substring(0, builder.length() - 1);
            }
            // request
            URL realUrl = new URL(builder.toString());
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            PluginManager.getLogger().error(e);
        }
        // close stream
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                PluginManager.getLogger().error(e2);
            }
        }
        return result;
    }

    public static <T> List<T> page(String url, Map<String, String> param, Class<T> type, PageHelper pageHelper) {
        final List<T> allList = HttpUtil.httpGetList(url, param, type);
        return pageHelper.query(allList);
    }
}
