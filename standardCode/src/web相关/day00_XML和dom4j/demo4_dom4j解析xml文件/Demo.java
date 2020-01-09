package web相关.day00_XML和dom4j.demo4_dom4j解析xml文件;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author 彭智林
 * @date 2018/1/3 11:54
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            DOM解析原理:
                XML DOM 将整个XML文档加载到内存，生成一个DOM树，并获得一个Document对象，通过Document对象就可以对DOM进行操作
            dom4j解析xml文件:
                1.使用步骤:
                    1.0 导入dom4j的jar包到classpath路径中
                    1.1 创建解析器
                    1.2 使用解析器解析xml文档,得到Document对象
                    1.3 使用Document对象获取xml文件中的元素或者属性
                        1.3.1 使用Document对象获取xml文件中的根元素
                        1.3.2 使用根元素获取子元素或者属性或者文本

            dom4j解析xml文件相关的Api:
                SaxReader类: 表示解析器对象
                    public SaxReader() 创建解析器对象
                    Document  read(InputStream input)  解析器解析xml文档,得到Document对象
                Document类:表示DOM树
                    Element getRootElement(); 获取根元素
                Element类: 表示元素
                    - List elements();获取所有的子元素
                    - String attributeValue(String var1); 获取指定属性名的值
                    - String getText();获取标签中的文本
                    - String getName();获取元素名称
         */
        // 解析xml文档:
        // 1.创建解析器
        SAXReader saxReader = new SAXReader();

        // 2.使用解析器解析xml文档,得到Document对象
        FileInputStream fis = new FileInputStream("day14\\src\\books.xml");
        Document document = saxReader.read(fis);

        // 3.使用Document对象获取根元素
        Element rootElement = document.getRootElement();
        System.out.println("根元素名称为:" + rootElement.getName());// 根元素名称为:books

        // 4.通过根元素获取根元素下面的子元素
        List<Element> list = rootElement.elements();

        // 5.遍历根元素的所有子元素:
        for (Element e : list) {
            // 6.在循环中,根据子元素获取子元素的id属性
            String idValue = e.attributeValue("id");
            System.out.println(e.getName()+"元素的id属性值为:" + idValue);
            // 7.在循环中,使用子元素获取该子元素的所有孙元素
            List<Element> list1 = e.elements();
            for (Element e1 : list1) {
                // 8.在循环中,遍历所有的孙元素,根据孙元素获取文本
                System.out.println(e1.getName()+"元素中的文本是:"+e1.getText());
            }
        }

        fis.close();

    }
}
