import java.util.ArrayList; 
class ClientList { 
    ArrayList<Birthday> hasBdays; 
    ClientList(){ 
        hasBdays=new ArrayList<Birthday>(); 
    } 
 
    void fulldet(String txt){ 
        String[] arr_1; 
        String[] arr_2; 
        arr_1=txt.split(":"); 
        arr_2=arr_1[1].split(","); 
        if(arr_1[0].equalsIgnoreCase("Official")){ 
            Official c_det=new Official(arr_2[0],arr_2[1], arr_2[2]); 
        } 
        else if(arr_1[0].equalsIgnoreCase("Office_friend")){ 
            OfficeFriend c_det=new OfficeFriend(arr_2[0], arr_2[1], arr_2[2], arr_2[3]); 
            hasBdays.add(c_det); 
        } 
        else if(arr_1[0].equalsIgnoreCase("Personal")){ 
            Persional c_det=new Persional(arr_2[0], arr_2[2], arr_2[1], arr_2[3]); 
            hasBdays.add(c_det); 
        } 
         
    } 
 
} 