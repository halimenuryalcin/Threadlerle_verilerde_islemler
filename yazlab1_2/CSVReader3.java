package yazlab1_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public  class CSVReader3 {
	static String file="C:\\\\Users\\\\nurre\\\\PycharmProjects\\\\yazlab1_2\\\\DATA\\";
	static String [][] data=ReadFileIntoArray(file,6);
	static String[][] row=new String[100000][3];
	static List<String[]> rowlist = new ArrayList<String[]>();
	static int x=0;
	public static void main(String[] args) throws FileNotFoundException{
		
		ArrayList <String> records=new ArrayList<>();
		ArrayList<String>list=new ArrayList<>();
		//similarity("Product",(float)12.50);
		//senaryo3("Issue",(double)70.0);//senaryo2
		//senaryo2("3238275",12.5,"Issue");//senaryo3
	}
	
	
	public static void senaryo2(String id,double o,String column)
	{
		int ss=0;
		if(column.equals("Product"))
			ss=0;
		else if(column.equals("Issue"))
			ss=1;
		if(column.equals("ZIP code"))
			ss=5;
		if(column.equals("Company"))
			ss=2;
		if(column.equals("State"))
			ss=3;
		if(column.equals("Complaint ID"))
			ss=4;
		String l="",l2="";
		int payda,pay2; double boran;
		Collection<String> pay;
		for(int i=0;i<1000;i++)
		{	l=data[i][ss];
			for(int j=i+1;j<1000;j++)
			{	l2=data[j][ss];
				String temp=l;
				if(data[i][4].equals(id))
				{	
		    		//System.out.println(l+"--"+l2);
			  	  	if(l.length()<l2.length())//uzun kayıt alındı
			  	  		temp=l2;
			  	  	
			  	  	payda=kelimeSayisi(temp);
			  	  	pay=ortakkelime(l,l2);
			  	    pay2=pay.size();
			  	    boran=(float)pay2/payda*100;

			  	  	if(boran>=o)
			  	  	{//System.out.println(l+"--"+l2+"="+pay+":"+boran);

			  	  		senaryo1(l,l2,boran);
			  	  		listele();
			  	  	}
				}
			}
		}
	}
	
	
	public static void senaryo3(String column,double oran)
	{
		int ss=0;
		if(column.equals("Product"))
			ss=0;
		else if(column.equals("Issue"))
			ss=1;
		if(column.equals("ZIP code"))
			ss=5;
		if(column.equals("Company"))
			ss=2;
		if(column.equals("State"))
			ss=3;
		if(column.equals("Complaint ID"))
			ss=4;
		String l="",l2="";
		int payda,pay2; double boran;
		Collection<String> pay;
		for(int i=0;i<1000;i++)
		{	l=data[i][ss];
			for(int j=i+1;j<1000;j++)
			{	l2=data[j][ss];
				String temp=l;
				if(data[i][0].equals(data[j][0]))
				{
		    		//System.out.println(l+"--"+l2);
			  	  	if(l.length()<l2.length())//uzun kayıt alındı
			  	  		temp=l2;
			  	  	
			  	  	payda=kelimeSayisi(temp);
			  	  	pay=ortakkelime(l,l2);
			  	    pay2=pay.size();
			  	    boran=(float)pay2/payda*100;
		    		//System.out.println(l+"--"+l2+"="+pay+":"+boran);

			  	  	if(boran>=oran)
			  	  	{	
			  	  		listele2(i,j,boran);
			  	  	}
				}
			}
		}
	}
	
	private static List<String[]> listele2(int a,int b,double o) {
/*
		row[x][0]=data[a][2];
		row[x][1]=data[b][2];
		row[x][2]=Double.toString(o);
		System.out.println(row[x][0]+"-"+row[x][1]+"-"+row[x][2]);
		x++;
		return row;
			*/
		rowlist.add(new String[]{data[a][2],data[b][2],Double.toString(o)});
		for(String[] row:rowlist)
			System.out.println(Arrays.toString(row));
		return rowlist;
		
	}
	private static String[][] ReadFileIntoArray(String file, int i) {
		List<String>records=new ArrayList<String>();
		String delimiter=",";
		String currentLine;
		
		try {
			
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			while((currentLine=br.readLine())!= null) {
				records.add(currentLine);
			}
			int recordsCount=records.size();
			String arrayToReturn[][]=new String[recordsCount][i];
			String[]data;
			for(int j=0;j<recordsCount;j++) {
				data=records.get(j).split(delimiter);
				
				for(int k=0;k<data.length;k++)
				{
					arrayToReturn[j][k]=data[k];
					
				}
				
			}
			return arrayToReturn;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;			

		}
	}
	
	public static void similarity(String column,double d) {
		
			
		int ss=0;
		if(column.equals("Product"))
			ss=0;
		else if(column.equals("Issue"))
			ss=1;
		if(column.equals("ZIP code"))
			ss=5;
		if(column.equals("Company"))
			ss=2;
		if(column.equals("State"))
			ss=3;
		if(column.equals("Complaint ID"))
			ss=4;
	    String line="";
	    String line2="";
	    int payda=0;
		Collection<String> pay;
	    double boran=0.0;
	    int durum=0;
	    try {
	    	for(int i=1;i<100;i++)
		    {	line=data[i][ss];
		    	String temp=line;
		    	for(int j=i+1;j<100;j++)
		    	{
		    		line2=data[j][ss];
		    		//System.out.println(line+"--"+line2);
			  	  	if(line.length()<line2.length())//uzun kayıt alındı
			  	  		temp=line2;
		    		
			  	  	payda=kelimeSayisi(temp);
			  	  	pay=ortakkelime(line,line2);

			  	    int pay2=pay.size();
			  	    boran=(float)pay2/payda*100;
		    		

			  	  	if(boran>=d)
			  	  	{	//System.out.println(line+"--"+line2+"="+pay+":"+boran);
			  	  		senaryo1(line,line2,boran);
			  	  		
			  	  		listele();
			  	  	}
			  	  	
			  	  	
		    	}
		    }
	    }catch(Exception  e) {
	    	System.out.println(e);
	    }
	  }
	
	
	public static int kelimeSayisi(String line)
	{	int count=1;
		 for(int m=0;m<line.length();m++)
 		{
 			if(line.charAt(m)==' ')
 				count++;
 		}
 		
		return count;
		
	}

	public static Collection<String> ortakkelime(String line,String line2)
	{	
		Collection<String> myList = new ArrayList<String>(Arrays.asList(line.split(" ")));
		Collection<String> myList2 = new ArrayList<String>(Arrays.asList(line2.split(" ")));
		Collection<String>similar=new HashSet<String>(myList);
		similar.retainAll(myList2);
		
		return similar;
		
	}

	
	public static   List<String[]> senaryo1(String l,String m,double oran)
	{		/*row[x][0]=l;
			row[x][1]=m;
			row[x][2]=Double.toString(oran);
			//System.out.println(row[x][0]+"-"+row[x][1]+"-"+row[x][2]);
			x++;
		return row;*/
		rowlist.add(new String[]{l,m,Double.toString(oran)});
		return rowlist;
	}

	
	public static  void listele()
	{	
		/*
		for(int i=0;i<1000;i++)
			if(row[i][0]!= null && row[i][1]!= null&& row[i][2]!= null)
				System.out.println(row[i][0]+"--"+row[i][1]+"--"+row[i][2]);
			*/
		for(String[] row:rowlist)
			System.out.println(Arrays.toString(row));
	}

	
	public static void senaryo4(String id,double o,String column)
	{
		int ss=0;
		if(column.equals("Product"))
			ss=0;
		else if(column.equals("Issue"))
			ss=1;
		if(column.equals("ZIP code"))
			ss=5;
		if(column.equals("Company"))
			ss=2;
		if(column.equals("State"))
			ss=3;
		if(column.equals("Complaint ID"))
			ss=4;
		String l="",l2="";
		int payda,pay2; double boran;
		Collection<String> pay;
		for(int i=0;i<1000;i++)
		{	l=data[i][ss];
			for(int j=i+1;j<1000;j++)
			{	l2=data[j][ss];
				String temp=l;
				if(data[i][4].equals(id))
				{	
		    		//System.out.println(l+"--"+l2);
			  	  	if(l.length()<l2.length())//uzun kayıt alındı
			  	  		temp=l2;
			  	  	
			  	  	payda=kelimeSayisi(temp);
			  	  	pay=ortakkelime(l,l2);
			  	    pay2=pay.size();
			  	    boran=(float)pay2/payda*100;

			  	  	if(boran>=o)
			  	  	{//System.out.println(l+"--"+l2+"="+pay+":"+boran);

			  	  		senaryo1(l,l2,boran);
			  	  		//listele();
			  	  	}
				}
			}
		}
	}
	
}