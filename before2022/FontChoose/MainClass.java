package COMMON.FontChoose;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//����ѡ����

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����ʼ");
		DemoWindow demo = new DemoWindow("demo");
		demo.setVisible(true);
		demo.setBounds(100,100,600,400);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class DemoWindow extends JFrame implements ItemListener{
	//��ʾ��ǩ
	JLabel TYPEFACE = new JLabel("����");
	JLabel SIZE = new JLabel("��С");
	JLabel TYPE = new JLabel("��ʽ");
	//����������Ͽ�
	JComboBox jcb1 = null;		//JComboBox
	//�����С��Ͽ�
	JComboBox jcb2 = null;
	//������ʽ��Ͽ�
	JComboBox jcb3 = null;
	
	JPanel jp = new JPanel();
	
	//��ʾ����Ч�������
	FontPanel fp = new FontPanel();
	//��������
	String fontName = null;
	//�����С
	int fontSize = 10;
	//������ʽ
	int fontStyle = 0;
	
	public DemoWindow(String title){
		super(title);
		//��ȡϵͳ��������
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();			//GraphicsEnvironment
		String[] sysFonts = ge.getAvailableFontFamilyNames();
		//��������������Ͽ�
		jcb1 = new JComboBox(sysFonts);		
		//����Ĭ��ѡ�����������
		fontName = sysFonts[0];
		
		//���������С�ַ�������
		String[] fontSizes = new String[10];
		for(int i=0;i<fontSizes.length;i++){
			fontSizes[i] = String.valueOf(10+i*10);
			
		}
		//���������С��Ͽ�
		jcb2 = new JComboBox(fontSizes);
		
		//����������ʽ��Ͽ�
		jcb3 = new JComboBox(new String[]{
				"PLAIN","BOLD","ITALIC","BOLD&ITALIC"
		});
		
		jp.setLayout(new FlowLayout());
		jp.add(TYPEFACE);
		jp.add(jcb1);
		jp.add(SIZE);
		jp.add(jcb3);
		jp.add(TYPE);
		jp.add(jcb2);
		
		this.add(jp,BorderLayout.NORTH);
		add(fp,BorderLayout.CENTER);
		jcb1.addItemListener(this);
		jcb2.addItemListener(this);
		jcb3.addItemListener(this);
		
		//������ѳߴ�
		this.setPreferredSize(new Dimension(600,200));		//??
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {			//itemStateChanged
		// TODO Auto-generated method stub 
		System.out.println("itemStateChanged��������");
		if(e.getStateChange() == ItemEvent.SELECTED){
			Object list = e.getSource();
			//����ѡ�����������
			if(list == jcb1){
				fontName = (String)jcb1.getSelectedItem();
			}
			//����ѡ�������С
			else if(list == jcb2){
				String sizeString = (String)jcb2.getSelectedItem();
				fontSize = Integer.parseInt(sizeString);
				
			}
			//����ѡ���������ʽ
			else{
				fontStyle = jcb3.getSelectedIndex();
				
			}
			//�����µ�����
			fp.setFont(fontName,fontStyle,fontSize);
			
		}
	}
	
}

class FontPanel extends JPanel{
	//��ʾ�ı�
	String demoString = "java";
	//����
	Font font = new Font("Arial",Font.PLAIN,40);
	//��������ú���
	public void setFont(String f,int st,int size){
		font = new Font(f,st,size);
		repaint();
		
	}
	//�����ȡ����
	public Font getFont(){
		return this.font;
	}
	
	//���ػ�ͼ����
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//��ȡ��ǰ���Ŀ�Ⱥ͸߶�
		int width = this.getWidth();
		int height = this.getHeight();
		//������ɫ
		this.setBackground(Color.blue);
		g.setColor(Color.darkGray);
		//���û�ͼ����
		g.setFont(font);
		//���л�����ʾ�ı�
		FontMetrics metrics = g.getFontMetrics();   		//FontMetrics �ඨ����������󣬸ö����װ�����ض���Ļ�ϳ����ض�������й���Ϣ
		int wid = metrics.stringWidth(demoString);
		int hei = metrics.getAscent();		//�ڻ�ȡ�߶ȵ�ʱ�򲻽���ʹ��metrics.getHeight����������ָ�����ı����ֻ���֮��ľ��룬ͨ�������ַ������ĸ߶�
		g.drawString(demoString, width/2-wid/2, height/2+hei/2);
		
	}
}