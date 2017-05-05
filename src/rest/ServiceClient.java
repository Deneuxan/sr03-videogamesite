package rest;




import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import beans.Jeux;
import dao.JeuxDao;
import dao.ClientDao;
import beans.Client;



/*import dao.GamesDao;*/


@Path("/client")
public class ServiceClient {

	@GET
	@Path("/{client}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientInfo(@PathParam("client") String client_id) throws URISyntaxException, FileNotFoundException{
		String result = "resttest"+client_id;
		/*Client client_i=ClientDao.find(Integer.valueOf(client_id));*/
		Client client_i=ClientDao.find(Integer.valueOf(client_id));
		return Response.ok().entity(client_i.ToJSON()).build();
		
	}
	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientInfo() throws URISyntaxException, FileNotFoundException{
		String result = "rest tous les client";
		/*Client client_i=ClientDao.find(Integer.valueOf(client_id));*/
		
		List <Client> client_i=ClientDao.findAll();			
		return Response.ok().entity(Client.ToJSONall(client_i)).build();
		
	}

	@POST // Méthode HTTP utilisée pour déclencher cette méthode
	@Path("/create")
	/*http://localhost:8080/SR03/rest/client/create?username=testqwq@123.com&password=asdkhfbsuif&name=hehe&firstname=haha&gender=H&birthdate=1990-01-01*/    
	public Response createClient(@QueryParam("username") String username, @QueryParam("password") String password ,@QueryParam("name") String name,@QueryParam("firstname") String firstname, @QueryParam("gender") String gender, @QueryParam("birthdate") String date) {
             
        if ( ClientDao.find(username) != null) {
          return Response
            .status(Status.NO_CONTENT)
            .build();
        }
        
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        Date temp = Date.valueOf(date);
//        java.util.Date utilDate = new java.util.Date(temp.getTime());
//        
        //int id_client, String username, String password, String nom, String prenom, String gender, Date date_naissance
        Client newClient = new Client(0, username, password, name, firstname, gender, d);
           
        
        String res="";
		if (ClientDao.insert(newClient)>0){
			res = "Add succeed";}
		else{
			res = "Add fail";
		}

        return Response
          .status(Status.OK)
          .entity(res)
          .build();
    }
	
	@PUT // Méthode HTTP utilisée pour déclencher cette méthode
	@Path("/update")
    public Response updateClient(@QueryParam("username") String username, @QueryParam("password") String password ,@QueryParam("name") String name,@QueryParam("firstname") String firstname, @QueryParam("gender") String gender, @QueryParam("birthdate") String date) throws Exception {
             
		Client current = ClientDao.find(username);
        if ( current == null) {
          return Response
            .status(Status.NO_CONTENT)
            .build();
        }
        else{
        	
        	int idcurrent = current.getId_client();
        	
        	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date d = null;
    		try {
    			d = format.parse(date);
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		current.setNom(name);
    		current.setDate_naissance(d);
    		current.setPassword(password);
    		current.setGender(gender);
    		current.setPrenom(firstname);
    		
    		String res="";
    		if (ClientDao.update(current)>0){
    			res = "Update succeed, ID client:" + String.valueOf(current.getId_client());}
    		else{
    			res = "Update fail, ID client:" + String.valueOf(current.getId_client());
    		}
            
            return Response
                    .status(Status.OK)
                    .entity(res)
                    .build();
        }
	}
        
    	@DELETE
    	@Path("/delete/{client}")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response deleteUser(@PathParam("client") String client_id){
    		System.out.println("deleting"+client_id);
    		String res="";
    		if (ClientDao.delete(Integer.valueOf(client_id))>0){
    			res = "Delete succeed";}
    		else{
    			res = "Delete fail";
    		}
    		
    		
    		return Response.ok().entity(res).build();
    	}

        
    

}