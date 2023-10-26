class Official extends Recipient{ 
    private String designation; 
 
    Official(String name,String email,String designation){ 
        super(name,email); 
        this.designation=designation; 
    } 
 
    String GetDesignation(){ 
        return designation; 
    } 
    String get_type(){ 
        return "Official"; 
    } 
} 