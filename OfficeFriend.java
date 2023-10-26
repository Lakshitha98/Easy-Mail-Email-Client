class OfficeFriend extends Official implements Birthday{ 
    private String bday; 
 
    OfficeFriend(String name,String email,String designation,String bday){ 
        super(name,email,designation); 
        this.bday=bday; 
    } 
 
    String bday(){ 
        return bday; 
    } 
    String get_type(){ 
        return "Office_friend"; 
    } 
} 