package Hackland;
import java.util.*;
import java.io.*;
import java.math.*;

public class Election {
	public static void FindWinner(String[] votes){
		Map<String,Integer> A=new HashMap<String,Integer>();
		for(String str:votes){
			if(A.containsKey(str))
				A.put(str,A.get(str)+1 );
			else
				A.put(str,1);
		}
		int maxvote=0;
		String Winner="";
		for(Map.Entry<String,Integer> entry:A.entrySet()){
			String curName=entry.getKey();
			int curVote=entry.getValue();
			if(entry.getValue()>maxvote){
				Winner=entry.getKey();
				maxvote=entry.getValue();
			}
			else if((curVote==maxvote) && (curName.compareTo(Winner)>0)){
				Winner=entry.getKey();
			}
		}
		System.out.println("The winner is "+Winner);
	}
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the number of voters");
		int n=in.nextInt();
		String[] Names=new String[n];
		for(int i=0;i<n;i++){
			Names[i]=in.next();
		}
		FindWinner(Names);
	}
}
