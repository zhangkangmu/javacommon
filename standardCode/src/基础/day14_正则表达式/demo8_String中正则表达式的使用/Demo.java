package 基础.day14_正则表达式.demo8_String中正则表达式的使用;

/**
 * @author 彭智林
 * @date 2020/1/3 16:14
 */
public class Demo {
    public static void main(String[] args) {
        /*
            String中正则表达式的使用:
                - String的split方法中使用正则表达式:
                    public String[] split(String regex) 可以将当前字符串中匹配regex正则表达式的符号作为"分隔符"来切割字符串。
                                    参数regex就是一个正则表达式。

                - String类的replaceAll方法中使用正则表达式
                    public String replaceAll(String regex,String newStr) 可以将当前字符串中匹配regex正则表达式的字符串替换为newStr。
                                             参数regex就是一个正则表达式。
         */
        // String类的replaceAll方法中使用正则表达式:
        // 传入的regex参数不是一个正则表达式字符串:
//        String str1 = "java heima java itcast";
//        // 需求:str1中的所有java替换为深圳
//        String newStr = str1.replaceAll("java", "深圳");
//        System.out.println("newStr:"+newStr);// 深圳 heima 深圳 itcast
//        System.out.println("str1:"+str1);// java heima java itcast
//
//        // 传入的regex参数是一个正则表达式字符串:
//        String str2 = "jfdk432jfdk2jk24354j47jk5l31324";
//        // 需求:将str2字符串中的"数字"替换为"*"
//        String newStr2 = str2.replaceAll("\\d+", "*");
//        System.out.println("newStr2:"+newStr2);// jfdk*jfdk*jk*j*jk*l*
//        System.out.println("str2:"+str2);// jfdk432jfdk2jk24354j47jk5l31324
//    }
//
//    /**
//     * String类的replaceAll方法中使用正则表达式
//     */
//    private static void method01() {
//        //  String的split方法中使用正则表达式:
//        // 传入的参数不是一个正则表达式字符串:
//        String str1 = "java heima php itcast";
//        String[] arr1 = str1.split(" ");
//        System.out.println(arr1.length);// 4
//        for (String e : arr1) {
//            System.out.println(e);
//        }
//
//        // 传入的参数是正则表达:
//        String str2 = "18  4 567       99     56";
//        String[] arr2 = str2.split(" +");
//        System.out.println(arr2.length);// 5
//        for (String s : arr2) {
//            System.out.println(s);
//        }
        String str=" zhang";
        System.out.println(str.matches("[^\\s|\\s$][a-z|A-Z]*"));
    }

}
