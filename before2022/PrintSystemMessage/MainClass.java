package COMMON.PrintSystemMessage;
//���Java ������Ϣ
/*
 * �� 	���ֵ������
java.version 	Java ����ʱ�����汾
java.vendor 	Java ����ʱ������Ӧ��
java.vendor.url 	Java ��Ӧ�̵� URL
java.home 	Java ��װĿ¼
java.vm.specification.version 	Java ������淶�汾
java.vm.specification.vendor 	Java ������淶��Ӧ��
java.vm.specification.name 	Java ������淶����
java.vm.version 	Java �����ʵ�ְ汾
java.vm.vendor 	Java �����ʵ�ֹ�Ӧ��
java.vm.name 	Java �����ʵ������
java.specification.version 	Java ����ʱ�����淶�汾
java.specification.vendor 	Java ����ʱ�����淶��Ӧ��
java.specification.name 	Java ����ʱ�����淶����
java.class.version 	Java ���ʽ�汾��
java.class.path 	Java ��·��
java.library.path 	���ؿ�ʱ������·���б�
java.io.tmpdir 	Ĭ�ϵ���ʱ�ļ�·��
java.compiler 	Ҫʹ�õ� JIT ������������
java.ext.dirs 	һ��������չĿ¼��·��
os.name 	����ϵͳ������
os.arch 	����ϵͳ�ļܹ�
os.version 	����ϵͳ�İ汾
file.separator 	�ļ��ָ������� UNIX ϵͳ���ǡ�/����
path.separator 	·���ָ������� UNIX ϵͳ���ǡ�:����
line.separator 	�зָ������� UNIX ϵͳ���ǡ�/n����
user.name 	�û����˻�����
user.home 	�û�����Ŀ¼
user.dir 	�û��ĵ�ǰ����Ŀ¼*/
public class MainClass {
	public static void main(String[] args){
		System.out.println("����ʼ");
		java.util.Properties pop = System.getProperties();
		java.util.Enumeration e = pop.propertyNames();
		while(e.hasMoreElements()){
			String popName = (String)e.nextElement();
			String popValue = (String)pop.get(popName);
			System.out.println(popName+"    ======   "+popValue);
			
		}
	}
}
/*
 * ����ʼ
java.runtime.name    ======   Java(TM) SE Runtime Environment
sun.boot.library.path    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\bin
java.vm.version    ======   25.112-b15
java.vm.vendor    ======   Oracle Corporation
java.vendor.url    ======   http://java.oracle.com/
path.separator    ======   ;
java.vm.name    ======   Java HotSpot(TM) 64-Bit Server VM
file.encoding.pkg    ======   sun.io
user.script    ======   
user.country    ======   CN
sun.java.launcher    ======   SUN_STANDARD
sun.os.patch.level    ======   
java.vm.specification.name    ======   Java Virtual Machine Specification
user.dir    ======   E:\Myeclipseworkplace\COMMONProject
java.runtime.version    ======   1.8.0_112-b15
java.awt.graphicsenv    ======   sun.awt.Win32GraphicsEnvironment
java.endorsed.dirs    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\endorsed
os.arch    ======   amd64
java.io.tmpdir    ======   C:\Users\DELL\AppData\Local\Temp\
line.separator    ======   

java.vm.specification.vendor    ======   Oracle Corporation
user.variant    ======   
os.name    ======   Windows 10
sun.jnu.encoding    ======   GBK
java.library.path    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;C:\Program Files (x86)\Common Files\Oracle\Java\javapath;C:\ProgramData\Oracle\Java\javapath;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\iCLS\;C:\Program Files\Intel\Intel(R) Management Engine Components\iCLS\;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Windows\System32\OpenSSH\;C:\Program Files (x86)\NVIDIA Corporation\PhysX\Common;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;D:\swiftforelement\Elements\bin;C:\Program Files\NVIDIA Corporation\NVIDIA NvDLISR;C:\Program Files\Git\cmd;D:\JDK\jre\bin;D:\JDK\bin;C:\Program Files\Intel\WiFi\bin\;C:\Program Files\Common Files\Intel\WirelessCommon\;C:\Users\DELL\AppData\Local\Microsoft\WindowsApps;D:\Visual Studio Code\Microsoft VS Code\bin;C:\Users\DELL\AppData\Local\GitHubDesktop\bin;D:\Docker\Docker Toolbox;.
java.specification.name    ======   Java Platform API Specification
java.class.version    ======   52.0
sun.management.compiler    ======   HotSpot 64-Bit Tiered Compilers
os.version    ======   10.0
user.home    ======   C:\Users\DELL
user.timezone    ======   
java.awt.printerjob    ======   sun.awt.windows.WPrinterJob
file.encoding    ======   GBK
java.specification.version    ======   1.8
user.name    ======   DELL
java.class.path    ======   E:\Myeclipseworkplace\COMMONProject\bin;D:\JDK\jre\lib\rt.jar;E:\Myeclipseworkplace\COMMONProject\napkinlafjar\napkinlaf.jar;E:\Myeclipseworkplace\COMMONProject\src\abc
java.vm.specification.version    ======   1.8
sun.arch.data.model    ======   64
java.home    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre
sun.java.command    ======   COMMON.PrintSystemMessage.MainClass
java.specification.vendor    ======   Oracle Corporation
user.language    ======   zh
awt.toolkit    ======   sun.awt.windows.WToolkit
java.vm.info    ======   mixed mode
java.version    ======   1.8.0_112
java.ext.dirs    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\ext;C:\Windows\Sun\Java\lib\ext
sun.boot.class.path    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\resources.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\rt.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\sunrsasign.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\jsse.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\jce.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\charsets.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\jfr.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\classes
java.vendor    ======   Oracle Corporation
file.separator    ======   \
java.vendor.url.bug    ======   http://bugreport.sun.com/bugreport/
sun.cpu.endian    ======   little
sun.io.unicode.encoding    ======   UnicodeLittle
sun.desktop    ======   windows
sun.cpu.isalist    ======   amd64
 * */
 