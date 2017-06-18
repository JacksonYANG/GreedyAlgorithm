package PureKnapsack;
import java.util.*;

import JacksonTools.Sort;

import static JacksonTools.Sort.*;
import java.awt.*;

public class knapsack {
	
	public static class Element implements Comparable{
		float w;
		float v;
		int i;
		
		public Element(float ww,float vv,int ii){
			w=ww;
			v=vv;
			i=ii;
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			float comparew=((Element) o).w;
			if(w<comparew) return -1;
			if(w==comparew) return 0;
			return 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n,c,i;
		System.out.print("��������Ʒ�ܸ���:");
		n=sc.nextInt();
		System.out.println();
		System.out.println("�����뱳��������:");
		c=sc.nextInt();
		System.out.println();
		float []w=new float[n];
		float []v=new float[n];
		float []x=new float[n];
		Element []d=new Element[n];
		for(i=0;i<n;i++){
			System.out.print("�������"+(i+1)+"����Ʒ������:");
			w[i]=sc.nextInt();
			System.out.println();
			System.out.println("�������"+(i+1)+"����Ʒ�ļ�ֵ");
			v[i]=sc.nextInt();
		}
		for(i=0;i<n;i++){
			d[i]=new Element(w[i],v[i],i);
		}
		Sort.MergeSort(d);
		float result=0;
		for(i=0;i<n;i++){
			x[i]=0;
		}
		for(i=0;i<n;i++){
			if(d[i].w>c) break;
			x[d[i].i]=1;
			result+=d[i].v;
			c-=d[i].w;
		}
		if(i<n){
			x[d[i].i]=c/d[i].w;
			result+=x[d[i].i]*d[i].v;
		}
		System.out.println("��������ֵΪ"+result);
		System.out.print("��ѡ�����ƷΪ");
		for(i=0;i<n;i++){
			if(x[i]>0){
				System.out.print(x[d[i].i]+"��"+(i+1)+" ");
			}
		}
		System.out.println();
	}
}
