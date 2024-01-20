package UnifyData;

import java.util.Date;
import java.util.LinkedList;

public class Meeting {
	
	private String code;
	private String title;
	private Date date;
	private LinkedList<Client> clientes;
                    
        //Constructor (4 parâmetros)
                  public Meeting(String code, String title, Date date){
                            this.code = code;
                            this.title = title;
                            this.date = date;
                            this.clientes = new LinkedList<>();
                  }  
        
	void createMeeting() {
		
	}
	
	void joinMeeting() {
		
	}
	
}
