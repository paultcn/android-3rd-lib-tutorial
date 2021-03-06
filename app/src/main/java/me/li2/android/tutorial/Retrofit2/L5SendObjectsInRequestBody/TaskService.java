package me.li2.android.tutorial.Retrofit2.L5SendObjectsInRequestBody;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * How to define and send data within HTTP requests body with Retrofit ?
 * RequestBin 是一个非常棒的免费网站，可以用来测试 POST 请求。使用方法也很简单，
 * 进入网站 http://requestb.in/，点击 「+Create a RequestBin」得到一个 url （一串乱序数字），用来接收 POST 请求；
 * 然后在浏览器通过这个 url 观察 post 的数据。
 *
 * httpbin: HTTP Request & Response Service, and RequestBin is fantastic for testing POST requests.
 *
 * Details refer to :
 *
 * HTTP Test server that accepts GET/Post calls
 * http://stackoverflow.com/a/9770981/2722270
 * http://httpbin.org/
 *
 * RequestBin gives you a URL that will collect requests made to it and let you inspect them in a human-friendly way.
 * PAY ATTENTION:
 * This bin will keep the last 20 requests made to it and remain available for 48 hours after it was created.
 * However, data might be cleared at any time, so treat bins as highly ephemeral.
 * http://requestb.in/
 *
 * Created by weiyi on 27/03/2017.
 * https://github.com/li2
 */

public interface TaskService {
    /*
    java.lang.IllegalStateException: Expected BEGIN_ARRAY but was STRING at line 1 column 1 path $
    change Call<Task> to Call<Void> will avoid this exception.
    DON'T KNOW WHY :(

    Answer from FutureStudio: http://disq.us/p/1hdcx4v
    The type in the Call<> describes the server response type. Your first option says the server should
    respond with a JSON object. http://requestb.in/10hf7r31 responds with a string, so Retrofit and Gson
    can't map that to a Java object. The second option with Call<void> ignores the server response and
    doesn't do any mapping. That's why you won't run into an issue.

    On the other hand, the method's return type is critical. You have to define what kind of data you
    expect from the server. If you don't care at all what the server responds, you can use Void. In all those cases,
    you'll have to wrap it into a typed Retrofit Call<> class.
    https://futurestud.io/tutorials/retrofit-2-basics-of-api-description

    After i change the return type to Call<String>, i can get string "ok" from response.body().
     */
    @POST("http://requestb.in/10hf7r31")
    Call<String> createTasks(@Body List<Task> tasks);
}
