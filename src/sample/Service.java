package sample;

import javafx.scene.control.TextArea;
import okhttp3.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

class Service {

    private OkHttpClient client;

    void close() {
        if (client != null) {
            client.dispatcher().executorService().shutdown();
        }
    }

    void start(TextArea logs, String id, String pwd, Map<String, String> ids) {
        client = new OkHttpClient.Builder().build();

        Headers headers = new Headers.Builder().add("Cookie", String.format("huiyuan%%5Fid=%s", id)).build();
        Request request = new Request.Builder()
                .headers(headers)
                .url("http://cnydvip.net/shop/gpf.aspx").build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                logs.appendText(String.format("获取商品ID请求异常[%s]", e.getMessage()) + System.lineSeparator());
            }

            @Override
            public void onResponse(Call call, Response resp) throws IOException {
                String html = new String(resp.body().bytes(), "GBK");
                String[] pfIds = between(html, "gp_show.aspx?gp_id=", "'");
                logs.appendText("获取的批发商品ID" + Arrays.toString(pfIds) + System.lineSeparator());
                for (String zkId : ids.keySet()) {
                    for (String pfId : pfIds) {
                        if (client.dispatcher().executorService().isShutdown()) {
                            break;
                        } else {
                            buy(logs, id, pwd, pfId, zkId, ids.get(zkId));
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    // "189954"
    private void buy(TextArea logs, String id, String pwd, String pfId, String zkId, String num) {
        Headers headers = new Headers.Builder().add("Cookie", String.format("huiyuan%%5Fid=%s", id)).build();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=GBK");
        String requestBody = String.format("huiyuan_pass_two=%s&id=%s&zhekou=%s&shuliang=%s", pwd, pfId, zkId, num);

        Request request = new Request.Builder()
                .headers(headers)
                .url("http://cnydvip.net/shop/gp_cart.aspx")
                .post(RequestBody.create(mediaType, requestBody)).build();
        if (!client.dispatcher().executorService().isShutdown()) {
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    logs.appendText(String.format("秒杀商品%s,折扣%s,数量%s异常[%s]", pfId, zkId, num, e.getMessage()) + System.lineSeparator());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    logs.appendText(String.format("秒杀商品%s,折扣%s,数量%s", pfId, zkId, num) + System.lineSeparator());
                    String body = new String(response.body().bytes(), "GBK");
                    logs.appendText(body + System.lineSeparator());
                }
            });
        }
    }


    private String[] between(String value, String start, String end) {
        String[] parts = value.split(end);
        return Arrays.stream(parts)
                .filter(subPart -> subPart.contains(start))
                .map(subPart -> subPart.substring(subPart.indexOf(start) + start.length()))
                .toArray(String[]::new);
    }
}
