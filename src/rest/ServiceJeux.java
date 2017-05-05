package rest;




import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.servlet.ServletContext; 
import beans.Jeux;
import dao.JeuxDao;
import dao.ClientDao;
import beans.Client;



/*import dao.GamesDao;*/


@Path("/jeux")
public class ServiceJeux {
	/*@GET
	@Path("/{jeux}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJeuxInfo(@PathParam("jeux") String jeux_id) throws URISyntaxException, FileNotFoundException{
		String result = "resttest"+jeux_id;
		Jeux Jeux_i=JeuxDao.find(Integer.valueOf(jeux_id));
		return Response.ok(Jeux_i).build();
		//return Response.status(200).entity(result).build(); 
		
	}*/
	
	
	
	@GET
	@Path("/{jeux}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getJeuxInfo(@PathParam("jeux" ) String jeux_id) throws URISyntaxException, FileNotFoundException, ParseException{
		String result = "resttest"+jeux_id;
		Jeux jeux_i=JeuxDao.find(Integer.valueOf(jeux_id));
		if (jeux_i==null)
		{	String date="1993-01-01";
			DateFormat format =new SimpleDateFormat("yyyy-MM-dd");
	
			Date d = format.parse(date);
			return Response.ok().entity(d).build();} /*"N'ont pas ce donne"*/
		/*ResponseBuilder response = Response.ok(jeux_i);
		return response.build();*/
		return Response.ok().entity(jeux_i.ToJSON()).build();
		/*return Response.ok().entity(jeux_i.ToJSON()).build();*/
	}
	
	@GET
	@Path("")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getAllJeuxInfo() throws URISyntaxException, FileNotFoundException{
		String result = "resttest, tous les jeux";
		List <Jeux> jeux_i=JeuxDao.findAll();
		if (jeux_i==null)
		{return Response.ok().entity("N'ont pas ce donne").build();}
		/*ResponseBuilder response = Response.ok(jeux_i);
		return response.build();*/
		return Response.ok().entity(Jeux.ToJSONall(jeux_i)).build();
		/*return Response.ok().entity(jeux_i.ToJSON()).build();*/
	}
		
	@DELETE
	@Path("/delete/{jeux}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("jeux") String jeux_id){
		System.out.println("deleting"+jeux_id);
		String res="";
		if (JeuxDao.delete(Integer.valueOf(jeux_id))>0){
			res = "Delete succeed";}
		else{
			res = "Delete fail";
		}
		
		
		return Response.ok().entity(res).build();
	}	
	
	@POST // Méthode HTTP utilisée pour déclencher cette méthode
	@Path("/create")
	/*http://localhost:8080/SR03/rest/client/create?username=testqwq@123.com&password=asdkhfbsuif&name=hehe&firstname=haha&gender=H&birthdate=1990-01-01*/    
	public Response createClient(@QueryParam("titre") String titre, @QueryParam("photo") String photo_jeux, @QueryParam("typeconsole") String type_console ,@QueryParam("tarif") String tarif,@QueryParam("nombrelibre") String nombre_libre, @QueryParam("idcreateur") String id_createur, @QueryParam("description") String description_jeux,@QueryParam("typelivraison") String type_livraison, @QueryParam("avendre") String a_vendre) {
             
		Date d= null;
        Jeux newJeux = new Jeux(0,titre,photo_jeux,type_console, Float.valueOf(tarif), Integer.valueOf(nombre_libre), Integer.valueOf(id_createur), description_jeux, type_livraison, Boolean.valueOf(a_vendre), d);
           
        String res="";
		if (JeuxDao.insert(newJeux)>0){
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
    public Response updateClient(@QueryParam("id_jeux") String id_jeux,@QueryParam("titre") String titre, @QueryParam("photo") String photo_jeux, @QueryParam("typeconsole") String type_console ,@QueryParam("tarif") String tarif,@QueryParam("nombrelibre") String nombre_libre, @QueryParam("idcreateur") String id_createur, @QueryParam("description") String description_jeux,@QueryParam("typelivraison") String type_livraison, @QueryParam("avendre") String a_vendre) throws Exception {
             
		Jeux current = JeuxDao.find(Integer.valueOf(id_jeux));
        if ( current == null) {
          return Response
            .status(Status.NO_CONTENT)
            .build();
        }
        else{
        	      	       
        	current.setTitre(titre);
        	current.setPhoto_jeux(titre);
        	current.setType_console(type_console);
        	current.setTarif( Float.valueOf(tarif));
        	current.setNombre_libre(Integer.valueOf(nombre_libre));
        	current.setid_createur(Integer.valueOf(id_createur));
        	current.setDescription_jeux(description_jeux);
        	current.setA_vendre(Boolean.valueOf(a_vendre));
    		        
            String res="";
    		if (JeuxDao.update(current)>0){
    			res = "Update succeed, ID jeux:" + String.valueOf(current.getId_jeux());}
    		else{
    			res = "Update fail, ID jeux:" + String.valueOf(current.getId_jeux());
    		}

            
        
            return Response
                    .status(Status.OK)
                    .entity(res)
                    .build();
        }
	}
		
		/*Client client_i=ClientDao.find(Integer.valueOf(client_id));*/
		
		/*if (jeux_id.equals("all") || jeux_id.equals("*")){
			List <Client> client_i=ClientDao.findAll();
			ResponseBuilder response = Response.ok(client_i);
			return response.build();
			
			return Response.ok().entity(Client.ToJSONall(client_i)).build();
			
		}*/
		
		/*System.out.println(jeux_i.getNom());*/
		/*return Response.ok().entity(client_i.ToJSON()).build();*/
		
		//return client_i;
		/*return Response.ok(client_i).build();*/
		/*return Response.ok().entity(client_i).build();*/
		/*return Response.status(200).entity(result).build(); */
		
	
	
	/*@GET
	@Path("/{client}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllClientInfo(@PathParam("client") "all") throws URISyntaxException, FileNotFoundException{
		String result = "resttest";
		Client client_i=ClientDao.find(Integer.valueOf(client_id));
		List <Client> client_i=ClientDao.findAll();
		
		
		return Response.ok().entity(Client.ToJSONall(client_i)).build();
		//return client_i;
		return Response.ok(client_i).build();
		return Response.ok().entity(client_i).build();
		return Response.status(200).entity(result).build(); 
		
	}
*/
}

