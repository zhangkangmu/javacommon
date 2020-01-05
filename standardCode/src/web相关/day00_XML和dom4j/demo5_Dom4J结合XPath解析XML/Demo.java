package web相关.day00_XML和dom4j.demo5_Dom4J结合XPath解析XML;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author 彭智林
 * @date 2020/1/3 12:14
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
            Dom4J结合XPath解析XML:
                1.使用步骤:
                    1.0 导入dom4j的jar包和jaxen-1.1-beta-6.jar包到classpath路径中
                    1.1 创建解析器
                    1.2 使用解析器解析xml文档,得到Document对象
                    1.3 使用Document对象获取xml文件中的元素或者属性
                2.Document常用的api
                    - Document.selectSingleNode("xpath语法");   获得一个节点(标签,元素)
                    - Document.selectNodes("xpath语法");      获得多个节点(标签,元素)

         */
        // 解析books.xml文件:
        // 1.1 创建解析器
        SAXReader saxReader = new SAXReader();

        // 1.2 使用解析器解析xml文档,得到Document对象
        FileInputStream fis = new FileInputStream("standardCode\\src\\web相关\\day00_XML和dom4j\\books.xml");
        Document document = saxReader.read(fis);

        // 1.3 使用Document对象获取xml文件中的元素或者属性
        // 获得根元素
        Element rootElement = (Element) document.selectSingleNode("/books");
        System.out.println("根元素的名称是:"+rootElement.getName());// books
        System.out.println("根元素下面的子元素个数:"+rootElement.elements().size());// 2

        // 获得根元素下的所有子元素
        List<Element> list = document.selectNodes("/books/book");
        System.out.println("book元素的个数:"+list.size());// 2

        // 获取所有的name元素标签
        List<Element> list1 = document.selectNodes("//name");
        for (Element e : list1) {
            System.out.println(e.getName()+"元素标签中的文本:"+e.getText());
        }

        // 获取根元素下的第二个book
        Element bookE = (Element)document.selectSingleNode("/books/book[2]");
        System.out.println(bookE.attributeValue("id"));// 0002

        // 根据book的id属性值获取根元素下的第二个:
        Element bookE2 = (Element)document.selectSingleNode("//book[@id='0002']");
        System.out.println(bookE2.attributeValue("id"));// 0002

        //找到任意标签下的id=0002的元素
        Element nodeBook = (Element) document.selectSingleNode("//*[@id='0002']");
        System.out.println(nodeBook.element("name").getText());

        fis.close();
    }
}
