package MinTree;
import java.awt.*;
import java.util.*;

public class Prim {
	final static int MAX=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int i,j,n;
		String flag;
		System.out.print("�������������:");
		n=sc.nextInt();
		int [][]c=new int[n+1][n+1];
		for(i=1;i<n;i++){
			c[i][i]=MAX;
			for(j=i+1;j<=n;j++){
				System.out.print("��"+j+"������Ƿ�Ϊ"+"��"+i+"�������ڽӽ��,������y,������n:");
				flag=sc.next();
				if(flag.equals("y")){
					System.out.print("�������"+i+"����㵽��"+j+"�����(�ڽӽ��)��Ȩֵ:");
					c[i][j]=sc.nextInt();
				}
				else c[i][j]=MAX;
				c[j][i]=c[i][j];
			}
		}
		int []lowcost=new int[n+1];
		int []closet=new int[n+1];
		boolean []s=new boolean[n+1];
		
		s[1]=true;
		for(i=2;i<=n;i++){
			lowcost[i]=c[1][i];
			closet[i]=1;
			s[i]=false;
		}
		for(i=1;i<n;i++){
			int min=Integer.MAX_VALUE;
			j=1;
			for(int k=2;k<=n;k++){
				if((lowcost[k]<min)&&(!s[k])){
					min=lowcost[k];
					j=k;
				}
			}
			System.out.println("��"+j+"�����"+"���ڽӶ���Ϊ"+closet[j]+" "+"ȨֵΪ"+min);
			s[j]=true;
			for(int k=2;k<=n;k++){
				if((c[j][k]<lowcost[k])&&(!s[k])){
					lowcost[k]=c[j][k];
					closet[k]=j;
				}
			}
		}
	}
}
