package COMMON.SixthPackage;

public class RandomArray {
	//���������������
	private int[][] array;
	//��������ά�ȵĴ�С
	private int size;
	//����Ķ�ȡ����
	public int[][] getArray(){
		return array;
	}
	//�ù��캯���������ά�ȴ�С���г�ʼ�����������������
	public RandomArray(int size){
		setSize(size);
		array = new int[size][size];
		generateRandomArray();
	}
	//�����С�����ú���
	public void setSize(int size){
		this.size = size;
	}
	//���ɾ��в��ظ������������
	private void generateRandomArray(){
		//��ʱ���������
		int randomNumber;
		//�ж��Ƿ��ظ��ı�Ǳ���
		boolean isRepeated;
		//ѭ����������Ԫ��
		for(int i = 0;i < size;i++){
			for(int j = 0;j<size;j++){
				//����1��size*size֮���һ�������
				randomNumber = (int)(Math.random()*size*size)+1;
				//����������Ƿ��ظ�
				isRepeated = false;
				for(int x = 0;x<size;x++ ){
					for(int y=0;y<size;y++){
						if(randomNumber == array[x][y]){
							isRepeated = true;
							break;
							
						}
					}
				}
				
				//���û���ظ��������Ӧ������Ԫ�ظ�ֵ,�������õ�ǰ����Ԫ���±꣬�������´�ѭ���ڴ����������
				if(!isRepeated){
					array[i][j] = randomNumber;
					
				}else{
					j--;
				}
			}
		}
	}
	
}
