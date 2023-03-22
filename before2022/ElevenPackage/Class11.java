package COMMON.ElevenPackage;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

//���Ϸ�ҳ
/*
 * ���ö�ҳ�������޵Ŀռ��ڶ�̬��ʾȫ���ļ���Ԫ��
 * 
 * */
public class Class11 {
	public static void main(String[] args){
		System.out.println("����ʼ");
		//���ɺ���20�������ļ���
		List lists = new ArrayList();
		for(int i = 0;i<20;i++){
			lists.add(new Integer(i));
		}
		
		//����page��Լ��Ϸ�ҳ
		Page page = new Page(lists,5);
		//��ʾ����ҳ������м�¼
		page.first();
		for(int i = 0;i<page.getTotalPage();i++){
			//�õ���ǰҳ���¼
			List list  = page.getPageContents();
			Iterator it = list.iterator();
			while(it.hasNext()){
				Integer integer = (Integer)it.next();
				System.out.print(integer+"\t");
				
			}
			
			System.out.println();
			page.next();
		}
	}
}


//��ҳ��
class Page{
	//ÿҳ��¼��
	private int recordsInPage;
	//��ǰҳ��
	private int currentPage=1;
	//��ҳ��
	private int totalPage=0;
	//��Ҫ��ҳ�ļ���
	private List list;
	
	//�Լ��ϣ�ÿҳ��¼�����г�ʼ�����õ���ҳ��
	public Page(List list,int recordsInPage){
		this.list  =list;
		this.recordsInPage = recordsInPage;
		
		this.totalPage= (list.size()-1)/recordsInPage+1;
		
	}
	
	//��λ����һҳ
	public void first(){
		currentPage = 1;
	}
	
	//��λ����һҳ
	public void next(){
		currentPage = currentPage+1;
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
	}
	
	//��λ����һҳ
	public void previous(){
		currentPage  = currentPage-1;
		if (currentPage < 0){
			currentPage = 1;
		}
	}
	
	//��λ�����һҳ
	public void last(){
		currentPage = totalPage;
		
	}
	
	//��λ������ҳ
	public void absolute(int page){
		if(page >= 0 && page <= totalPage){
			currentPage = page;
		}
	}
	
	//��ȡ��ǰҳ���м�¼
	public List getPageContents(){
		//��ǰҳ����ʵ��¼��
		int pageStartRow;
		//��ǰҳ���еĽ�����¼��
		int pageEndRow;
		
		//���ֵ�ǰҳ�Ƿ�Ϊ���һҳ
		if(currentPage*recordsInPage < list.size()){
			pageEndRow = currentPage*recordsInPage;
			pageStartRow = pageEndRow - recordsInPage;
			
		}else{
			pageEndRow = list.size();
			pageStartRow = recordsInPage*(totalPage - 1);
		}
		//���浱ǰҳ��ķ��ؼ���
		List listInPage = new ArrayList();
		
		//���浱ǰҳ������м�¼
		int counter = 0;
		for(int i = pageStartRow;i<pageEndRow;i++){
			Object object = list.get(i);
			listInPage.add(counter,object);
			counter++;
			
		}
		return listInPage;
	}
	
	public int getTotalPage(){
		return totalPage;
	}
	
}