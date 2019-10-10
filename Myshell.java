package myshell;
import java.io.*;

public class Myshell 
{
	public void runcommand(String cmd)
	{
		int exitval=0;
		Process p = null;
		try 
		{
			p = Runtime.getRuntime().exec(cmd);//execute the command read from console
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		StringBuilder output = new StringBuilder();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String c=null;
		try 
		{
			while((c= r.readLine())!=null)
			{
				output.append(c);
			}
		} catch (IOException e1) 
		{
			
			e1.printStackTrace();
		}
		
		try 
		{
			exitval = p.waitFor();
		} catch (InterruptedException e) 
		{
		
			e.printStackTrace();
		}
		if (exitval == 0)
		{
			System.out.println(output);
			System.exit(0);
		}
	}
	
	public void readcommand()
	{
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br =  new BufferedReader(i);
		
		String str = null;
		
		try 
		{
			str = br.readLine();
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	
		
		runcommand(str);
	}
	
	
	
	public static void main(String args[]){
		
		Myshell m = new Myshell();
		m.readcommand();
		
	}
	
	
	

}
