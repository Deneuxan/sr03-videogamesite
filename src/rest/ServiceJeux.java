package rest;




import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
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
	@Path("/{client}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientInfo(@PathParam("client") String client_id) throws URISyntaxException, FileNotFoundException{
		String result = "resttest"+client_id;
		/*Client client_i=ClientDao.find(Integer.valueOf(client_id));*/
		
		if (client_id.equals("all") || client_id.equals("*")){
			List <Client> client_i=ClientDao.findAll();			
			return Response.ok().entity(Client.ToJSONall(client_i)).build();
			
		}
		Client client_i=ClientDao.find(Integer.valueOf(client_id));
		return Response.ok().entity(client_i.ToJSON()).build();
		//return client_i;
		/*return Response.ok(client_i).build();*/
		/*return Response.ok().entity(client_i).build();*/
		/*return Response.status(200).entity(result).build(); */
		
	}
	
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

