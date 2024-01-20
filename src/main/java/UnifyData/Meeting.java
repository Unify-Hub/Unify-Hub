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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LinkedList<Client> getClientes() {
        return clientes;
    }

    public void setClientes(LinkedList<Client> clientes) {
        this.clientes = clientes;
    }
        
        
	
}
