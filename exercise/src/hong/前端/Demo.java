package hong.前端;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhangyuhong
 * Date:2017/12/17
 * 详细看笔记
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        File file = new File(
                "H:\\javaProject\\Javaeeknowledge\\day04\\src\\com\\hong\\前端\\contact_read.xml");
//        roadXML(file);   //封装xml文件
//        findAllElement(file);  //打印所有标签
//        File writeFile = new File(
//                "H:\\javaProject\\Javaeeknowledge\\day04\\src\\com\\hong\\前端\\contact_write.xml");
//        copyElement(writeFile);  //复制标签或者属性
//        deleteElement(writeFile);  //删除标签或者属性

        xpathAbout(file);

    }

    private static void xpathAbout(File file) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(file);
        String xpath = "";
        xpath = "//Contact[@id='01']/name[1]/text()";//选择第一个name标签的文本
        xpath = "//Contact[@id='1']/UID";
        xpath = "//name[text()='张宇洪']";
        List<Node> list = read.selectNodes(xpath);
        for (Node node : list) {
            System.out.println(node.getName()+"--"+node.getText());
        }

    }

    private static void copyElement(File file) throws Exception {
        SAXReader saxReader = new SAXReader();
        //原先的xml
        Document readDocument = saxReader.read(new File(
                "H:\\javaProject\\Javaeeknowledge\\day04\\src\\com\\hong\\前端\\contact_read.xml"));
        //复制到的xml
        FileOutputStream deleteOut = new FileOutputStream(file);

        XMLWriter xmlWriter = new XMLWriter(deleteOut);
        xmlWriter.write(readDocument);
        xmlWriter.close();

    }

    private static void deleteElement(File file) throws Exception {
        SAXReader saxReader = new SAXReader();
        //删除标签
            Document read = saxReader.read(file);
            Element rootElement = read.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element e : elements) {
                if (e.attributeValue("id").equals("3")) {
                    e.detach();
                }
            }
        FileOutputStream out = new FileOutputStream(file);
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter1 = new XMLWriter(out, prettyPrint);
        xmlWriter1.write(read);
        xmlWriter1.close();
    }

    private static void roadXML(File file) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        ArrayList<Contact> arrayList = new ArrayList<>();

        for (Element element : elements) {
            Contact contact = new Contact();
            contact.setUID(element.elementText("UID"));
            contact.setId(element.attributeValue("id"));
            contact.setName(element.elementText("name"));
            contact.setAge(element.elementText("age"));
            arrayList.add(contact);
        }
        //4)输出
        System.out.println(arrayList);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        Calendar.getInstance();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.MONDAY, 13);
        System.out.println(gregorianCalendar.get(Calendar.MONDAY));
    }


    private static void findAllElement(File file) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        System.out.println(document);
        Element rootElement = document.getRootElement();
        System.out.println("跟标签名字：" + rootElement.getName());
        List<Element> list;
        List<Element> elements = rootElement.elements();
        for (Element e : elements) {
            list = e.elements();
            for (Element element : list) {
                System.out.print(element.getName() + "：" + element.getText() + "----");
            }
            System.out.println(e.getName());
        }
    }
}
