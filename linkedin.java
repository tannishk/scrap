import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
class jdbcexec
{
	Connection conn;
	void insert(inot item,String name) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/linkedin";
		String user = "root";
		String password = "root";
		conn = DriverManager.getConnection(url, user,password);
		PreparedStatement pstmt = conn.prepareStatement("insert into linking values(?,?,?,?,?,?,?,?,?);");
		pstmt.setString(1, name);
		pstmt.setString(2, item.content1);
		pstmt.setString(3, item.specialtags1);
		pstmt.setString(4, item.link1);
		pstmt.setString(5, item.industry1);
		pstmt.setString(6, item.headquarters1);
		pstmt.setInt(7, item.founded1);
		pstmt.setString(8, item.type1);
		pstmt.setString(9, item.size);
		pstmt.execute();
		
	}
}
class inot
{
	String content1;
	String specialtags1;
	String link1;
	String industry1;
	String headquarters1;
	int founded1;
	String type1;
	String size;
}
public class index {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	for(int i=1;i<=10;i++)
		//{
		Scanner input = new Scanner(System.in);
		String htmlurl;
		
		String name;
		System.out.println("Enter the name");
		name = input.nextLine();
			System.out.println("Enter the url");
			htmlurl = input.next();
			Document doc = Jsoup.connect(htmlurl).get();
			
			/* Elements information = doc.getElementsByClass("basic-info-description");//#content > div.basic-info.viewmore-container.abbreviated.with-image > div.basic-info-description
	      for(Element a: information )
	      {
	    	  Elements c = a.getElementsByAttribute("p");
	    	  for(Element k : c )
	    	  {
	    		 System.out.print(k.text());
	    	  }
	      }*/
			jdbcexec jb = new jdbcexec();
			inot item = new inot() ;
			System.out.println(doc.title());
			Element contenttag = doc.select("#content > div.basic-info.viewmore-container.abbreviated.with-image > div.basic-info-description > p").first();
			if(contenttag==null)
			{
				 contenttag = doc.select("#content > div.basic-info.viewmore-container.abbreviated > div.basic-info-description > p").first();
			}
			String content = null ;
			if(contenttag!=null)
			content = contenttag.text();
			item.content1=content;
			System.out.println("Description");
		     System.out.println(content);	
		     Element specialtiestag = doc.select("#content > div.basic-info.viewmore-container.abbreviated.with-image > div.basic-info-about > div > p").first();
	         System.out.println("Specialities");
	         if(specialtiestag!=null)
	         {
	        	 System.out.println(specialtiestag.text());
	        	 item.specialtags1=specialtiestag.text();
	         }
	         
	         Element link = doc.select("#content > div.basic-info.viewmore-container.abbreviated.with-image > div.basic-info-about > ul > li.website > p").first();
	         if(link==null)
	         {
	        	 link = doc.select("#content > div.basic-info.viewmore-container.abbreviated > div.basic-info-about > ul > li.website > p").first();
	         }
	         if(link!=null)
	         {
	        	 System.out.println(link.text());
	        	 item.link1=link.text();
	         }
	         Element industry = doc.select("#content > div.basic-info.viewmore-container.abbreviated.with-image > div.basic-info-about > ul > li.industry > p").first();
	         if(industry==null)
	         {
	        	 industry = doc.select("#content > div.basic-info.viewmore-container.abbreviated > div.basic-info-about > ul > li.industry > p").first();
	         }
	         if(industry!=null)
	         {
	        	 System.out.println(industry.text());
	        	 item.industry1=industry.text();
	         }
	         Element headquarters = doc.select("#content > div.basic-info.viewmore-container.abbreviated.with-image > div.basic-info-about > ul > li.vcard.hq > p").first();
	         if(headquarters == null)
	         {
	        	 headquarters = doc.select("#content > div.basic-info.viewmore-container.abbreviated > div.basic-info-about > ul > li.vcard.hq > p").first();
	         }
	         if(headquarters!=null)
	         {
	         System.out.println(headquarters.text());
	         item.headquarters1=headquarters.text();
	         }
	         Element founded = doc.select("#content > div.basic-info.viewmore-container.abbreviated.with-image > div.basic-info-about > ul > li.founded > p").first();
	         if(founded==null)
	         {
	        	 founded = doc.select("#content > div.basic-info.viewmore-container.abbreviated > div.basic-info-about > ul > li.founded > p").first();
	         }
	         if(founded!=null)
	         {
	         System.out.println(founded.text());
	         item.founded1=Integer.valueOf(founded.text());
	         }
	         Element type = doc.select("#content > div.basic-info.viewmore-container.abbreviated.with-image > div.basic-info-about > ul > li.type > p").first();
	         if(type==null)
	         {
	        	 type = doc.select("#content > div.basic-info.viewmore-container.abbreviated.with-image > div.basic-info-about > ul > li.type > p").first();
	         }
	         if(type!=null)
	         {
	         System.out.println(type.text());
	         item.type1=type.text();
	         }
	         
	         Element size = doc.select("#content > div.basic-info.viewmore-container.abbreviated.with-image > div.basic-info-about > ul > li.company-size > p").first();
	         if(size==null)
	         {
	        	 size = doc.select("#content > div.basic-info.viewmore-container.abbreviated > div.basic-info-about > ul > li.company-size > p").first();
	         }
	         if(size!=null)
	         {
	         System.out.println(size.text());
	         item.size=size.text();
	         }
	         
	         try {
				jb.insert(item, name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         input.close();
		
		}

}
