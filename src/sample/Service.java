package sample;

import javafx.scene.control.TextArea;
import okhttp3.*;
import sample.model.GpBuy;
import sample.model.GpSell;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

class Service {

    private OkHttpClient client;

    private void init(int timeout) {
        if (client == null || client.dispatcher().executorService().isShutdown()) {
            client = new OkHttpClient.Builder()
                    .writeTimeout(timeout, TimeUnit.SECONDS)
                    .readTimeout(timeout, TimeUnit.SECONDS)
                    .connectTimeout(timeout, TimeUnit.SECONDS).build();
        }
    }

    void close() {
        if (client != null) {
            client.dispatcher().executorService().shutdown();
        }
    }

    void start(TextArea logs, String host, String id, GpBuy buy, GpSell sell, String sleepTime, int timeout) {
        init(timeout);

        boolean buyResult = false;
        boolean shellResult = false;
        while (!client.dispatcher().executorService().isShutdown() && (!buyResult || !shellResult)) {
            if (buyResult) {
                shellResult = sell(logs, host, id, sell);
            } else {
                buyResult = buy(logs, host, id, buy);
            }
            try {
                Thread.sleep(Integer.parseInt(sleepTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // "189954"
    private boolean buy(TextArea logs, String host, String id, GpBuy buy) {
        boolean result = false;
        Headers headers = new Headers.Builder().add("Cookie", String.format("huiyuan%%5Fid=%s", id)).build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=GBK");

        Request request = new Request.Builder()
                .headers(headers)
                .url(String.format("http://%s/shop/gp_cart.aspx", host))
                .post(RequestBody.create(mediaType, buy.toString())).build();
        if (!client.dispatcher().executorService().isShutdown()) {
            synchronized (logs) {
                try {
                    Response resp = client.newCall(request).execute();
                    logs.appendText(String.format("秒杀商品[%s]", buy.toString()) + System.lineSeparator());
                    String body = new String(resp.body().bytes(), "GBK");
                    if (body.contains("成功")) {
                        result = true;
                        logs.appendText(String.format("--------秒杀商品[%s]成功--------", buy.toString()) + System.lineSeparator());
                    }
                    logs.appendText(body + System.lineSeparator());
                } catch (IOException e) {
                    logs.appendText(String.format("秒杀商品[%s],异常[%s]", buy.toString(), e.getMessage()) + System.lineSeparator());
                }
            }
        }
        return result;
    }

    private boolean sell(TextArea logs, String host, String id, GpSell sell) {
        boolean result = false;
        Headers headers = new Headers.Builder().add("Cookie", String.format("huiyuan%%5Fid=%s", id)).build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=GBK");

        Request request = new Request.Builder()
                .headers(headers)
                .url(String.format("http://%s/member/gp/jiaoyi_sell.aspx", host))
                .post(RequestBody.create(mediaType, sell.toString())).build();
        if (!client.dispatcher().executorService().isShutdown()) {
            synchronized (logs) {
                try {
                    Response resp = client.newCall(request).execute();
                    logs.appendText(String.format("出售商品信息[%s]", sell.toString()) + System.lineSeparator());
                    String body = new String(resp.body().bytes(), "GBK");
                    if (body.contains("成功")) {
                        result = true;
                        logs.appendText(String.format("--------出售商品[%s]成功--------", sell.toString()) + System.lineSeparator());
                    }
                    logs.appendText(body + System.lineSeparator());
                } catch (IOException e) {
                    logs.appendText(String.format("出售商品[%s],异常[%s]", sell.toString(), e.getMessage()) + System.lineSeparator());
                }
            }
        }
        return result;
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
