package sample;

import javafx.scene.control.TextArea;
import okhttp3.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Service {

    private OkHttpClient client;
    private boolean status;

    private void init(int timeout) {
        if (client == null || client.dispatcher().executorService().isShutdown()) {
            client = new OkHttpClient.Builder().connectTimeout(timeout, TimeUnit.SECONDS).build();
        }
        status = true;
    }

    void close() {
        if (client != null) {
            client.dispatcher().executorService().shutdown();
        }
        status = false;
    }

    String getGps(TextArea logs, String id, int timeout) {
        init(timeout);

        Headers headers = new Headers.Builder().add("Cookie", String.format("huiyuan%%5Fid=%s", id)).build();
        Request request = new Request.Builder()
                .headers(headers)
                .url("http://cnydvip.net/shop/gpf.aspx").build();

        try {
            Response resp = client.newCall(request).execute();
            if (resp.isSuccessful()) {
                String html = new String(resp.body().bytes(), "GBK");
                String[] gpIds = handleHtml(html);
                String[] allGpIds = handleHtml2(html);
                logs.appendText("未售罄商品ID" + Arrays.toString(gpIds) + ",所有商品ID" + Arrays.toString(allGpIds) + System.lineSeparator());
                return Arrays.stream(gpIds).reduce("0-0",
                        (a, b) -> Integer.parseInt(a.split("-")[1]) >=
                                Integer.parseInt(b.split("-")[1]) ? a : b).split("-")[0];
            } else {
                logs.appendText(String.format("商品ID获取错误[%s]", new String(resp.body().bytes(), "GBK")) + System.lineSeparator());
            }
        } catch (IOException e) {
            logs.appendText(String.format("商品ID获取异常[%s]", e.getMessage()) + System.lineSeparator());
        }
        return "";
    }

    void start(TextArea logs, String id, String pwd, String gpId, Map<String, String> zkIds, String sleepTime, int timeout) {
        init(timeout);

        ExecutorService threadService = Executors.newFixedThreadPool(zkIds.size());
        for (String zkId : zkIds.keySet()) {
            if (client.dispatcher().executorService().isShutdown()) {
                break;
            } else {
                threadService.submit(() -> {
                    while (status && !client.dispatcher().executorService().isShutdown()) {
                        buy(logs, id, pwd, gpId, zkId, zkIds.get(zkId));
                        try {
                            Thread.sleep(Integer.parseInt(sleepTime));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
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
            synchronized (logs) {
                try {
                    Response resp = client.newCall(request).execute();
                    logs.appendText(String.format("秒杀商品%s,折扣%s,数量%s", pfId, zkId, num) + System.lineSeparator());
                    String body = new String(resp.body().bytes(), "GBK");
                    logs.appendText(body + System.lineSeparator());
                } catch (IOException e) {
                    logs.appendText(String.format("秒杀商品%s,折扣%s,数量%s异常[%s]", pfId, zkId, num, e.getMessage()) + System.lineSeparator());
                }
            }
            /*
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
            */
        }
    }


    private String[] handleHtml(String html) {
        String[] parts = html.split("gp_show.aspx\\?");
        return Arrays.stream(parts)
                .filter(subPart -> subPart.contains("gp_id="))
                .filter(subPart -> !subPart.contains("售罄"))
                .map(subPart -> subPart.split("\\.00</td>")[0])
                .map(subPart -> between(subPart, "gp_id=", "'")[0]
                        + subPart.substring(subPart.indexOf(".00-") + 3).replace(",", ""))
                .toArray(String[]::new);
    }

    private String[] handleHtml2(String html) {
        String[] parts = html.split("gp_show.aspx\\?");
        return Arrays.stream(parts)
                .filter(subPart -> subPart.contains("gp_id="))
                .map(subPart -> subPart.split("\\.00</td>")[0])
                .map(subPart -> between(subPart, "gp_id=", "'")[0]
                        + subPart.substring(subPart.indexOf(".00-") + 3).replace(",", ""))
                .toArray(String[]::new);
    }

    private String[] between(String value, String start, String end) {
        String[] parts = value.split(end);
        return Arrays.stream(parts)
                .filter(subPart -> subPart.contains(start))
                .map(subPart -> subPart.substring(subPart.indexOf(start) + start.length()))
                .toArray(String[]::new);
    }
}
