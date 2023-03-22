package COMMON.DifferentLanuage;

import java.awt.Font;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 利用属性文件实现程序的多语言版本
 * 开发国际化程序通常需要处理各种语言版本的应用程序，使用扩展名为  properties的
 * 属性文件可以保存 不同语言版本的文本信息，利用Java自带的ResourceBundle类可以很方便的
 * 对多语言版本进行管理和维护，本范例重点注意resourcebundle类的使用
 * 
 * */
public class MainClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序开始");
		Demo demo = new Demo("你好啊");
		demo.setVisible(true);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setBounds(0, 0, 400, 400);
	}

}
class Demo extends JFrame{
	JPanel jp = new JPanel();
	JLabel jl = new JLabel("",JLabel.CENTER);
	Demo(String title){
		super(title);
		jl.setFont(new Font("黑体",Font.BOLD,32));
		
		this.add(jp);
		this.add(jl);
		
		//设置语言函数
		
		this.initialzeLocal(Locale.CHINA);
		/*Locale类
		 *  Locale实例对象代表一个特定的地理、政治、文化区域。 一个
		 * Locale对象本身不会验证它代表的语言和国家地区信息是否正确，只是向本地敏感的类提供国家地区信息，
		 * 与国际化相关的格式化和解析任务由本地敏感的类去完成。(若JDK中的某个类在运行时需要根据Locale对象来调整其功能，
		 * 这个类就称为本地敏感类)
		 */
	}
	private void initialzeLocal(Locale locale){	//?
		try{
			//加载指定国别的属性文件
			ResourceBundle resourcebundle = ResourceBundle.getBundle("InfoResources",locale);		
			// 读取属性文件中的字段信息
			String stitle = resourcebundle.getString("title");
			System.out.println(stitle);
			String sinfo = resourcebundle.getString("information");
			System.out.println(sinfo);
			
			//设置窗体文字信息
//			setTitle(new String(stitle.getBytes("ISO8859-1")));		//?
//			jl.setToolTipText(new String(sinfo.getBytes("ISO8859_1")));
//			jl.setText(new String(sinfo.getBytes("ISO8859_1")));
			setTitle(new String(stitle.getBytes("UTF-8")));		//?
			jl.setToolTipText(new String(sinfo.getBytes("ISO8859_1")));
			jl.setText(new String(sinfo.getBytes("ISO8859_1")));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

//Can't find bundle for base name InvfoResources, locale zh_CN
//https://blog.csdn.net/qzjn123456789/article/details/17051379

/*
 * -----------------国际化:

1.问题:什么是国际化，国际化作用?

        软件的国际化：软件开发时，要使它能同时应对世界不同地区和国家的访问，并针对不同地区和国家的访问，提供相应的、符合来访者阅读习惯的页面或数据。

        国际化又称为 i18n：internationalization

        对于程序中固定使用的文本元素，例如菜单栏、导航条等中使用的文本元素、或错误提示信息，状态信息等，需要根据来访者的地区和国家，选择不同语言的文本为之服务。对于程序动态产生的数据，例如(日期，货币等)，软件应能根据当前所在的国家或地区的文化习惯进行显示。

        可以提供更友好的访问习惯。

2.问题:怎样实现国际化?

        针对于不同的国家与地区要显示的信息，都配置到配置文件中，根据当前访问者的国家或语言来从不同的配置文件中获取信息，展示在页面上。

3.问题:关于配置文件?

        所谓的配置文件就是一组properties文件，它们叫做资源包。

        相关的概念:

        对于软件中的菜单栏、导航条、错误提示信息，状态信息等这些固定不变的文本信息，可以把它们写在一个properties文件中，并根据不同的国家编写不同的properties文件。这一组properties文件称之为一个资源包。ResourceBundler，它是用于从资源包中获取数据的。

        关于资源文件(properties)命名:

                基名_语言_国家.properties

                message_zh_CN.properties

                message_en_US.properteis
---------------------------------------------*/
/*
 * ---MessageFormat类：
MessageFormat类，也是重要的国际化信息的类。它与ResourceBundle的区别是：
        ResourceBundle类只可以使用静态文本，即在编译时已经确定的文本。
        而MessageFormat可以使用动态文本。如String str = MessageFormat.format(“Hello {0}”,”Jack”);
        System.err.println(str);
MessageFormat类，不能读取资源文件，它只能借助于ResourceBundle已经读取的信息再进行格式化输出。
示例：资源文件中的信息为greeting=Hello {0}
        ResourceBundle b = ResourceBundle.getBundle(“message”);
        String greeting = b.getString(“greeting”);
        greeting = MessageFormat.format(greeting,”北京”);
        System.err.println(greeting);
JSTL的国际化标签：
< fmt:setLocale/> - 设置Locale关将它保存在某个范围内，默认为page范围。
        如：< fmt:setLocale value=“zh_CN” scope=“session”/>它的作用相当于：
        Locale locale = new Locale(“zh”,”CN”);
        Session.setAttribute(“javax.servlet.jsp.jstl.fmt.locale.session”,locale);
< fmt:setBundle/>
       用于设置要使用的资源文件。如：
       < fmt:setBundle basename=“message” var=“变量名” scope=“session”/>
< fmt:message/>
       读取资源文件中key所对应的值。 
---------------------*/

