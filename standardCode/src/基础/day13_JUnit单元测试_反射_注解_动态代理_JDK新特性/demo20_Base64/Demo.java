package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo20_Base64;


import java.lang.reflect.Proxy;
import java.util.Base64;
import java.util.UUID;

/**
 * @author 彭智林
 * @date 2020/1/2 18:12
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
            Base64:
                概述:Base64是jdk8提出的一个新特性,可以用来进行按照一定规则编码和解码
                规则:
                    基本类型
                    URL类型
                    MIME类型
               Base64编码和解码:依赖的是Base64中的内部类 Encoder 编码器   Decoder解码器
               Base64中提供了方法来获取各种类型的编码器和解码器:
                static Base64.Decoder getDecoder() 基本型 base64 解码器。
                static Base64.Encoder getEncoder() 基本型 base64 编码器。

                static Base64.Decoder getMimeDecoder() Mime型 base64 解码器。
                static Base64.Encoder getMimeEncoder() Mime型 base64 编码器。

                static Base64.Decoder getUrlDecoder() Url型 base64 解码器。
                static Base64.Encoder getUrlEncoder() Url型 base64 编码器。

              Encoder编码器:  encodeToString(byte[] bys)编码
              Decoder解码器:  decode(String str) 解码
         */
       // 使用基本编码
        String base64encodedString = Base64.getEncoder().encodeToString("itheima?中国".getBytes("utf-8"));
        System.out.println("Base64 编码字符串 (基本) :" + base64encodedString); // 编码之后的 看不懂

        byte[] bys1 = Base64.getDecoder().decode(base64encodedString);
        System.out.println(new String(bys1,0,bys1.length,"utf8"));

        // URL
        base64encodedString = Base64.getUrlEncoder().encodeToString("itheima?中国".getBytes("utf-8"));
        System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
        byte[] bys2 = Base64.getUrlDecoder().decode(base64encodedString);
        System.out.println(new String(bys2,0,bys2.length,"utf8"));



        byte[] mimeBytes = "itheima?中国".getBytes("utf-8");
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);

        byte[] bys = Base64.getMimeDecoder().decode(mimeEncodedString);
        System.out.println(new String(bys,0,bys.length,"utf8"));




    }
}
