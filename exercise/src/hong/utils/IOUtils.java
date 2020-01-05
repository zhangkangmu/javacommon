package hong.utils;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * Created by zhangyuhong
 * Date:2017/12/30
 */
public class IOUtils {

    private static PrintStream printStream;

    /**
     * 打印的log
     * @param str  输出的log信息
     */
    public static void printLog(String str) {
        try {
            printStream = new PrintStream(new File("exercise\\src\\hong\\练习的包\\source_test\\log.txt"));
            printStream.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            closeStream(null,printStream);
        }
    }

    //输入
    private static FileInputStream fileInputStream;
    private static InputStreamReader inputStreamReader;
    //输出
    private static OutputStreamWriter outputStreamWriter;
    private static FileOutputStream fileOutputStream;

    /**
     * gbk编码转成utf-8
     *
     * @param path 转换的文件路径
     */
    public static void gbk2utf8(String path) {
        try {
            File file = new File(path);
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
            int len;
            char[] chars = new char[1024];
            //存储文本
            StringBuilder builder = new StringBuilder();
            while ((len = inputStreamReader.read(chars)) != -1) {
                builder.append(new String(chars, 0, len));
            }
            closeWriteAndReader(inputStreamReader,null);
            //输出文本
            File repalceFile = new File(path);
            fileOutputStream = new FileOutputStream(repalceFile);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf8");
            outputStreamWriter.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeWriteAndReader(inputStreamReader, outputStreamWriter);
        }
    }

    /**
     * utf-8编码转成gbk
     *
     * @param path 转换的文件路径
     */
    public static void utf82gbk(String path) {
        try {
            File file = new File(path);
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, "utf8");
            int len;
            char[] chars = new char[1024];
            //存储文本
            StringBuilder builder = new StringBuilder();
            while ((len = inputStreamReader.read(chars)) != -1) {
                builder.append(new String(chars, 0, len));
            }
            closeWriteAndReader(inputStreamReader,null);
            //输出文本
            File repalceFile = new File(path);
            fileOutputStream = new FileOutputStream(repalceFile);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");
            outputStreamWriter.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeWriteAndReader(inputStreamReader, outputStreamWriter);
        }
    }

    public static void closeAll(Reader reader, Writer writer, InputStream inputStream, OutputStream outputStream) {
        closeWriteAndReader(reader, writer);
        closeStream(inputStream, outputStream);
    }

    public static void closeWriteAndReader(Reader reader, Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void closeStream(InputStream inputStream, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
