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
import dao.GestionClientBDD;
import dao.GestionJeuxBDD;
import beans.Categorie;
import beans.Client;
import beans.Client_address;



/*import dao.GamesDao;*/


@Path("/jeux")
public class ServiceJeux {	
	
	@GET
	@Path("/{jeux}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getJeuxInfo(@PathParam("jeux" ) String jeux_id) throws URISyntaxException, FileNotFoundException, ParseException{
		String result = "resttest"+jeux_id;
		Jeux jeux_i=JeuxDao.find(Integer.valueOf(jeux_id));
		if (jeux_i==null)
		{	
			return Response.ok().entity("N'ont pas ce donne").build();} 
		/*ResponseBuilder response = Response.ok(jeux_i);
		return response.build();*/
		return Response.ok(jeux_i).build();
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
		return Response.ok(jeux_i).build();
		/*return Response.ok().entity(jeux_i.ToJSON()).build();*/
	}
	
	@GET
	@Path("/key")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getJeuxInfobykey(@QueryParam("titre") String titre, @QueryParam("type_console") String type_console) throws URISyntaxException, FileNotFoundException{
		String result = " les jeux cherche par cle";
		List <Jeux> jeux_i=JeuxDao.findkeyword(titre,type_console);
		if (jeux_i==null || jeux_i.isEmpty())
		{return Response.ok().entity("N'ont pas ce donne").build();}
		/*ResponseBuilder response = Response.ok(jeux_i);
		return response.build();*/
		return Response.ok(jeux_i).build();
		/*return Response.ok().entity(jeux_i.ToJSON()).build();*/
	}
		
	@DELETE
	@Path("/delete/{jeux}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("jeux") String jeux_id){
		System.out.println("deleting"+jeux_id);
		String res="";
		if (JeuxDao.delete_desctive(Integer.valueOf(jeux_id))>0){// use delete_desctive to replace delete
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
	
	
	@GET
	@Path("/categorie")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategorie() throws URISyntaxException, FileNotFoundException{
		List <Categorie> categorie=GestionJeuxBDD.findAllCategorie();
		if (categorie==null || categorie.isEmpty())
		{return Response.ok().entity("N'ont pas ce donne").build();}
		return Response.ok(categorie).build();
		
	}
	
	@GET
	@Path("/categorie/{categorie}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategorie(@PathParam("categorie") String id_categorie) throws URISyntaxException, FileNotFoundException{
		Categorie categorie=GestionJeuxBDD.findCategorie(Integer.valueOf(id_categorie));
		if (categorie==null)
		{	return null;} 		
		return Response.ok(categorie).build();
		
	}
	
	@GET
	@Path("/categorie/jeux")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJeuxCategorie(@QueryParam("categorie") String id_categorie) throws URISyntaxException, FileNotFoundException{
		List <Jeux> categorie=GestionJeuxBDD.findCategorieAllJeux(Integer.valueOf(id_categorie));
		if (categorie==null || categorie.isEmpty())
		{return Response.ok().entity("N'ont pas ce donne").build();}
		return Response.ok(categorie).build();
		
	}
	
		
	
}

