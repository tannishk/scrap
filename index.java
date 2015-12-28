package git;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class index {
 public static void main (String[] args) throws Exception
 {
	 //for(i)
	 String s;
	 for(int i=1;i<=100;i++)
	 {
		 try
		 { 
			 /*String stringUrl = "https://qualysapi.qualys.eu/api/2.0/fo/report/?action=list";
		        URL url = new URL(stringUrl);
		        URLConnection uc = url.openConnection();

		        uc.setRequestProperty("X-Requested-With", "Curl");

		        String userpass = "username" + ":" + "password";
		        String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
		        uc.setRequestProperty("Authorization", basicAuth);

		        InputStreamReader inputStreamReader = new InputStreamReader(uc.getInputStream());
		        // read this input*/
	   URL url = new URL("https://api.github.com/user/"+i+"?access_token=92f7b43ad95aa87deecd2aebd683487a7dc19412");
	   BufferedReader in =  new BufferedReader(new InputStreamReader(url.openStream()));
	   int j;
       char a;
       String str1 = "";
       String str2 = "";
       int count = 1;
       int intro=0;
       while ((j=in.read())!=-1)
       {
    	   a=(char )j;
    	   if(a=='{')
    	   {
    		   
    	   }
    	   else if(a=='}')
    	   {
    		   
    	   }
    	   else if(a==',')
    	   {
    		   System.out.print(str1);
    	   }
    	   else if(a=='\"')
    	   {
    		  //skip
    		   intro++;
    		   if(intro%2!=0)
    		   {
    			  
    			   str1 = "";
    		   }
    	   }
    	   else if(a==':')
    	   {
    		   System.out.print(" "+str1);
    		   System.out.print(":");
    	   }
    	   
    	   else
    	   {
    			   str1 = str1 + String.valueOf(a);
    		   
    	   }
       }
       	
		 }
		 catch(Exception e)
		 {
			 i++;
		 }
		 System.out.println();
	 }
	 

 }
}
