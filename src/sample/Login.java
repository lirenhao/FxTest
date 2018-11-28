package sample;

import okhttp3.*;

import java.io.IOException;

public class Login {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        Request request = new Request.Builder()
                .url("http://cnydvip.net/mobile/denglu_check.aspx")
                .post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=GBK"),
                        "huiyuan_bianhao=18310809129&huiyuan_pass=li_renhao")).build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response resp) {
                System.out.println(resp.code());
                System.out.println(resp.headers().toString());
            }
        });
    }
}
