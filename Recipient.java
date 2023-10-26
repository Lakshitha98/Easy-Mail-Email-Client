abstract class Recipient{ 
    private String name; 
    private String email; 
    static int objectCount=0; 
    Recipient(String name,String email){ 
        this.name=name; 
        this.email=email; 
        objectCount++; 
    } 
    abstract String get_type(); 
    String getEmail(){ 
        return email; 
    } 
    String getName(){ 
        return name; 
    } 
} 