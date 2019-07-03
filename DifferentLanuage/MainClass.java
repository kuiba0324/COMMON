package COMMON.DifferentLanuage;

import java.awt.Font;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * ���������ļ�ʵ�ֳ���Ķ����԰汾
 * �������ʻ�����ͨ����Ҫ����������԰汾��Ӧ�ó���ʹ����չ��Ϊ  properties��
 * �����ļ����Ա��� ��ͬ���԰汾���ı���Ϣ������Java�Դ���ResourceBundle����Ժܷ����
 * �Զ����԰汾���й����ά�����������ص�ע��resourcebundle���ʹ��
 * 
 * */
public class MainClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����ʼ");
		Demo demo = new Demo("��ð�");
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
		jl.setFont(new Font("����",Font.BOLD,32));
		
		this.add(jp);
		this.add(jl);
		
		//�������Ժ���
		
		this.initialzeLocal(Locale.CHINA);
		/*Locale��
		 *  Localeʵ���������һ���ض��ĵ������Ρ��Ļ����� һ��
		 * Locale����������֤����������Ժ͹��ҵ�����Ϣ�Ƿ���ȷ��ֻ���򱾵����е����ṩ���ҵ�����Ϣ��
		 * ����ʻ���صĸ�ʽ���ͽ��������ɱ������е���ȥ��ɡ�(��JDK�е�ĳ����������ʱ��Ҫ����Locale�����������书�ܣ�
		 * �����ͳ�Ϊ����������)
		 */
	}
	private void initialzeLocal(Locale locale){	//?
		try{
			//����ָ������������ļ�
			ResourceBundle resourcebundle = ResourceBundle.getBundle("InfoResources",locale);		
			// ��ȡ�����ļ��е��ֶ���Ϣ
			String stitle = resourcebundle.getString("title");
			System.out.println(stitle);
			String sinfo = resourcebundle.getString("information");
			System.out.println(sinfo);
			
			//���ô���������Ϣ
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
 * -----------------���ʻ�:

1.����:ʲô�ǹ��ʻ������ʻ�����?

        ����Ĺ��ʻ����������ʱ��Ҫʹ����ͬʱӦ�����粻ͬ�����͹��ҵķ��ʣ�����Բ�ͬ�����͹��ҵķ��ʣ��ṩ��Ӧ�ġ������������Ķ�ϰ�ߵ�ҳ������ݡ�

        ���ʻ��ֳ�Ϊ i18n��internationalization

        ���ڳ����й̶�ʹ�õ��ı�Ԫ�أ�����˵���������������ʹ�õ��ı�Ԫ�ء��������ʾ��Ϣ��״̬��Ϣ�ȣ���Ҫ���������ߵĵ����͹��ң�ѡ��ͬ���Ե��ı�Ϊ֮���񡣶��ڳ���̬���������ݣ�����(���ڣ����ҵ�)�����Ӧ�ܸ��ݵ�ǰ���ڵĹ��һ�������Ļ�ϰ�߽�����ʾ��

        �����ṩ���Ѻõķ���ϰ�ߡ�

2.����:����ʵ�ֹ��ʻ�?

        ����ڲ�ͬ�Ĺ��������Ҫ��ʾ����Ϣ�������õ������ļ��У����ݵ�ǰ�����ߵĹ��һ��������Ӳ�ͬ�������ļ��л�ȡ��Ϣ��չʾ��ҳ���ϡ�

3.����:���������ļ�?

        ��ν�������ļ�����һ��properties�ļ������ǽ�����Դ����

        ��صĸ���:

        ��������еĲ˵�������������������ʾ��Ϣ��״̬��Ϣ����Щ�̶�������ı���Ϣ�����԰�����д��һ��properties�ļ��У������ݲ�ͬ�Ĺ��ұ�д��ͬ��properties�ļ�����һ��properties�ļ���֮Ϊһ����Դ����ResourceBundler���������ڴ���Դ���л�ȡ���ݵġ�

        ������Դ�ļ�(properties)����:

                ����_����_����.properties

                message_zh_CN.properties

                message_en_US.properteis
---------------------------------------------*/
/*
 * ---MessageFormat�ࣺ
MessageFormat�࣬Ҳ����Ҫ�Ĺ��ʻ���Ϣ���ࡣ����ResourceBundle�������ǣ�
        ResourceBundle��ֻ����ʹ�þ�̬�ı������ڱ���ʱ�Ѿ�ȷ�����ı���
        ��MessageFormat����ʹ�ö�̬�ı�����String str = MessageFormat.format(��Hello {0}��,��Jack��);
        System.err.println(str);
MessageFormat�࣬���ܶ�ȡ��Դ�ļ�����ֻ�ܽ�����ResourceBundle�Ѿ���ȡ����Ϣ�ٽ��и�ʽ�������
ʾ������Դ�ļ��е���ϢΪgreeting=Hello {0}
        ResourceBundle b = ResourceBundle.getBundle(��message��);
        String greeting = b.getString(��greeting��);
        greeting = MessageFormat.format(greeting,��������);
        System.err.println(greeting);
JSTL�Ĺ��ʻ���ǩ��
< fmt:setLocale/> - ����Locale�ؽ���������ĳ����Χ�ڣ�Ĭ��Ϊpage��Χ��
        �磺< fmt:setLocale value=��zh_CN�� scope=��session��/>���������൱�ڣ�
        Locale locale = new Locale(��zh��,��CN��);
        Session.setAttribute(��javax.servlet.jsp.jstl.fmt.locale.session��,locale);
< fmt:setBundle/>
       ��������Ҫʹ�õ���Դ�ļ����磺
       < fmt:setBundle basename=��message�� var=���������� scope=��session��/>
< fmt:message/>
       ��ȡ��Դ�ļ���key����Ӧ��ֵ�� 
---------------------*/

