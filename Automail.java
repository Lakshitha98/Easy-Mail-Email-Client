class Automail{ 
 ArrayList<Sendmail> sent_mail=new ArrayList<Sendmail>(); 
    ClientList send()  throws IOException { 
      
  
     String today=new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()); 
        File cdata=new File("ClientList.txt"); 
        cdata.createNewFile(); 
        ClientList cl=new ClientList(); 
        if(cdata.isFile()){ 
         Scanner reader=new Scanner(cdata); 
            try{ 
      
                while(reader.hasNext()){ 
                    cl.fulldet(reader.nextLine()); 
                } 
            } 
            catch(Exception e){ 
                System.out.println(e); 
            } 
            finally { 
             reader.close(); 
            } 
        } 
        //Sendmail sender=new Sendmail(); 
        String dum; 
        ArrayList<Sendmail> sentmaildum; 
        for(Birthday i:cl.hasBdays) { 
         //System.out.println(i.bday()); 
          
         if(Integer.parseInt(i.bday().split("/")[1])==Integer.parseInt(today.split("/")[1]) && Integer.parseInt(i.bday().split("/")[2])==Integer.parseInt(today.split("/")[2])) { 
           
          if(i.get_type().equalsIgnoreCase("Office_friend")) { 
           dum="Dear "+i.getName()+",\n\n"+"Wish you a Happy Birthday !, \n\n"+"Yours,Lakshitha"; 
           Deserialization d=new Deserialization(); 
           sentmaildum=d.deser(); 
           //System.out.println(sentmaildum); 
           if(sentmaildum==null || d.check(sentmaildum,i.getEmail(),"Birthday Wish",today)) { 
            Sendmail msg=new Sendmail(i.getEmail(),"Birthday Wish", dum); 
            if(sentmaildum==null) { 
             ArrayList<Sendmail> x=new ArrayList<Sendmail>(); 
             sentmaildum=x; 
            } 
            sentmaildum.add(msg); 
            FileOutputStream fos=new FileOutputStream("object.txt"); 
                     ObjectOutputStream oos=new ObjectOutputStream(fos); 
                     oos.writeObject(sentmaildum); 
                     oos.close(); 
                     fos.close(); 
           } 
            
           //sent_mail.add(msg); 
          } 
          if(i.get_type().equalsIgnoreCase("Personal")) { 
           dum="Dear "+i.getName()+",\n"+"Hugs and love on your birthday, \n\n"+"Yours,Laki"; 
           Deserialization e=new Deserialization(); 
           sentmaildum=e.deser(); 
           if(sentmaildum==null || e.check(sentmaildum,i.getEmail(),"Birthday Wish",today)) { 
            Sendmail msg1=new Sendmail(i.getEmail(),"Birthday Wish", dum); 
            if(sentmaildum==null) { 
             ArrayList<Sendmail> x=new ArrayList<Sendmail>(); 
             sentmaildum=x; 
            } 
            sentmaildum.add(msg1); 
            FileOutputStream fos=new FileOutputStream("object.txt"); 
                     ObjectOutputStream oos=new ObjectOutputStream(fos); 
                     oos.writeObject(sentmaildum); 
                     oos.close(); 
                     fos.close(); 
           } 
          } 
         } 
          
          
        } 
        //oos.writeObject(sent_mail); 
        //fos.close(); 
        //oos.close(); 
        return cl; 
    } 
} 