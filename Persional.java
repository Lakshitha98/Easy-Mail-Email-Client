class Persional extends Recipient implements Birthday{ 
    private String bday; 
    private String nickName; 
 
    Persional(String name,String email,String nickName,String bday){ 
        super(name,email); 
        this.bday=bday; 
        this.nickName=nickName; 
    } 
    String bday(){ 
        return bday; 
    } 
    String getNickname(){ 
        return nickName; 
    } 
    String get_type(){ 
        return "Personal"; 
    } 
} 