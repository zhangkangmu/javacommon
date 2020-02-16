package day05_三层架构和JSP练习_email.demo05_email_SMTP;

/**
 * @author liuyp
 * @date 2020/02/13
 */
public class MailTest {
    /**
     * email的发送以及imtp,mstp,POP3协议
     *
     *  SMTP：Simple Mail Transfer Protocol，简单邮件传输协议。发件协议(smtp收件服务器)
     *  IMAP：Internet Mail Access Protocol，网络邮件访问协议。收件协议，功能更强，
     *       双向协议：在客户端软件里，对邮件的操作，会同步在服务器里也操作
     *  POP3：Post Office Protocol - Version 3，邮局协议v3。收件协议
     *       单向协议：在客户端软件里，对邮件的操作，不会同步在服务器里也操作
     *
     * Java发送邮件的使用场景：帐号激活
     *      有人注册了一个帐号，需要激活
     *          服务端会给这个人的邮件发送激活邮件，邮件里有激活链接
     *
     *      用户登录自己的邮箱，收取激活邮件
     *          点击其中的激活链接，可以激活帐号
     *
     */
    public static void main(String[] args) throws Exception {
        //给289590351@qq.com发送邮件
        MailUtils.sendMail("kangmu0412@163.com", "hello，老弟");
    }
}
