
public class findbug {

	    public static int ZERO = 0;  
	      
	    int i;  
	    int value;  
	      
	    public int getValue() {  
	        return value;  
	    }  
	      
	    public synchronized int setValue(int value) {  
	        this.value = value;  
	        return value;  
	    }  
	      
	    @Deprecated 
	    public boolean getTrue() {  
	        return true;  
	    }  
	      
	      
	    public static void main(String[] args) {  
	    	findbug bc = new findbug();  
	        bc.setValue(bc.ZERO);  
	        bc.setValue(10);  
	          
	    }  
}