import java.io.*; 
import java.util.ArrayList; 
import java.util.Scanner; 
class Deserialization{ 
 ArrayList<Sendmail> sentmail; 
 ArrayList<Sendmail> deser() { 
   
  try { 
   FileInputStream fis =new FileInputStream("object.txt"); 
   File myobj=new File("object.txt"); 
   Scanner read=new Scanner(myobj); 
   boolean data; 
   BufferedReader br=new BufferedReader(new FileReader(myobj)); 
   data=br.readLine()==null; 
   if(!data){ 
    ObjectInputStream ois=new ObjectInputStream(fis); 
    
    sentmail=(ArrayList<Sendmail>) ois.readObject(); 
    ois.close(); 
    fis.close(); 
   } 
   else { 
    sentmail=null; 
   } 
   read.close(); 
  } 
  catch(Exception e) { 
   e.printStackTrace(); 
  } 
  return sentmail; 
 } 
 boolean check(ArrayList<Sendmail> sent,String email,String subject,String date) { 
  boolean val=true; 
  if(sent==null) { 
   val=true; 
  } 
  else { 
   for(Sendmail j:sent) { 
    if(j.get_to_email().equalsIgnoreCase(email) && j.get_date().equalsIgnoreCase(date) && j.get_subject().equalsIgnoreCase(subject)) { 
     val=false; 
    } 
   } 
  } 
  return val; 
 } 
} 