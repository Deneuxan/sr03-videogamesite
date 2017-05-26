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
import beans.Client_address;
import beans.Commande;
import beans.Commande_detail;
import dao.GestionClientBDD;





@Path("/client")
public class ServiceClient {

	@GET
	@Path("/{client}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientInfo(@PathParam("client") String client_id) throws URISyntaxException, FileNotFoundException{
		String result = "resttest"+client_id;
		/*Client client_i=ClientDao.find(Integer.valueOf(client_id));*/
		Client client_i=ClientDao.find(Integer.valueOf(client_id));
		if (client_i==null)
		{	
			return Response.ok().entity("N'ont pas ce donne").build();}
		return Response.ok(client_i).build();
		
	}
	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientInfo() throws URISyntaxException, FileNotFoundException{
		String result = "rest tous les client";
		/*Client client_i=ClientDao.find(Integer.valueOf(client_id));*/
		
		List <Client> client_i=ClientDao.findAll();			
		return Response.ok(client_i).build();
		
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
    //////////////////////////////////////////////////////////////////////////////// on n'a pas besoins de supprimer un client   
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

        
    // Gestion l'adresse de client
    	
    	
    	@GET
    	@Path("/adresse")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response getClientAddress(@QueryParam("client") String client_id, @QueryParam("adresse") String adresse_id) throws URISyntaxException, FileNotFoundException{
    		String result = "rest client adresse"+client_id +" and "+ adresse_id;
    		
    		Client_address client_address=GestionClientBDD.findAddress(Integer.valueOf(client_id), Integer.valueOf(adresse_id));
    		if (client_address==null)
    		{return Response.ok().entity("N'ont pas ce donne").build();}
    		return Response.ok(client_address).build();
    		
    	}
    	
    	@GET
    	@Path("/adresse/{client}")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response getClientAddress(@PathParam("client") String client_id) throws URISyntaxException, FileNotFoundException{
    		String result = "rest tous adress de client ";
    		Client client_i=ClientDao.find(Integer.valueOf(client_id));
    		
    		List <Client_address> client_address=GestionClientBDD.findAllAddress(Integer.valueOf(client_id));			
    		return Response.ok(client_address).build();
    		
    	}
    	
    	@POST // Méthode HTTP utilisée pour déclencher cette méthode
    	@Path("/adresse/create")
    	/*http://localhost:8080/SR03/rest/client/create?username=testqwq@123.com&password=asdkhfbsuif&name=hehe&firstname=haha&gender=H&birthdate=1990-01-01*/    
    	public Response createClientAdresse(@QueryParam("client") String id_client, @QueryParam("recepteur") String recepteur ,@QueryParam("address") String address,@QueryParam("code_postal") String code_postal, @QueryParam("ville") String ville, @QueryParam("pays") String pays , @QueryParam("telephone") String telephone) {
                 
    		Client_address newAdresse = new Client_address(Integer.valueOf(id_client),0, recepteur, address, code_postal, ville, pays, telephone);
                          
            String res="";
    		if (GestionClientBDD.insertAddress(newAdresse)>0){
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
    	@Path("/adresse/update")
        public Response updateClientAdresse(@QueryParam("client") String id_client, @QueryParam("idadresse") String id_address, @QueryParam("recepteur") String recepteur ,@QueryParam("address") String address,@QueryParam("code_postal") String code_postal, @QueryParam("ville") String ville, @QueryParam("pays") String pays , @QueryParam("telephone") String telephone) throws Exception {

    		/*, @QueryParam("recepteur") String recepteur ,@QueryParam("address") String address,@QueryParam("code_postal") String code_postal, @QueryParam("ville") String ville, @QueryParam("pays") String pays , @QueryParam("telephone") String telephone*/
    		
    		System.out.println("\n heheehheheh"+id_client);
    		System.out.println("\n adress   "+id_address);
    		Client_address current = GestionClientBDD.findAddress(Integer.valueOf(id_client), Integer.valueOf(id_address));
            if ( current == null) {
              return Response
                .status(Status.NO_CONTENT)
                .build();
            }
            else{
            	
        		current.setRecepteur(recepteur);
        		current.setAddress(address);
        		current.setCode_postal(code_postal);
        		current.setVille(ville);
        		current.setPays(pays);
        		current.setTelephones(telephone);
        		
        		
        		String res="";
        		if (GestionClientBDD.updateAddress(current)>0){
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
    	@Path("/adresse/delete")
    	/*@Produces(MediaType.APPLICATION_JSON)*/
    	public Response deleteClientAdresse(@QueryParam("client") String id_client, @QueryParam("adresse") String id_adresse){
    		String res="";
    		if (GestionClientBDD.deleteAddress(Integer.valueOf(id_client), Integer.valueOf(id_adresse))>0){
    			res = "Delete succeed";}
    		else{
    			res = "Delete fail";
    		}
    		
    		
    		return Response.ok().entity(res).build();
    	}
    	
    	@GET
    	@Path("/commande")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response getClientCommand(@QueryParam("client") String id_client, @QueryParam("commande") String id_commande) throws URISyntaxException, FileNotFoundException{
    		
    		Commande client_command=GestionClientBDD.findCommande(Integer.valueOf(id_client), Integer.valueOf(id_commande));
    		if (client_command==null)
    		{return Response.ok().entity("N'ont pas ce donne").build();}
    		return Response.ok(client_command).build();
    		
    	}
    	
    	@GET
    	@Path("/commande/{client}")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response getClientCommand(@PathParam("client") String id_client) throws URISyntaxException, FileNotFoundException{    		
    		List <Commande> client_command=GestionClientBDD.findAllCommande(Integer.valueOf(id_client));			
    		return Response.ok(client_command).build();
    		
    	}
    	
    	@POST // Méthode HTTP utilisée pour déclencher cette méthode
    	@Path("/commande/create")
    	/*http://localhost:8080/SR03/rest/client/create?username=testqwq@123.com&password=asdkhfbsuif&name=hehe&firstname=haha&gender=H&birthdate=1990-01-01*/    
    	public Response createCommand(@QueryParam("client") String id_client, @QueryParam("somme_argent") String somme_argent ,@QueryParam("address") String address) {
                 
    		Commande newCommande = new Commande(Integer.valueOf(id_client),0, null, Float.valueOf(somme_argent), address);
                          
            String res="";
    		if (GestionClientBDD.insertCommande(newCommande)>0){
    			res = "Add succeed";}
    		else{
    			res = "Add fail";
    		}

            return Response
              .status(Status.OK)
              .entity(res)
              .build();
        }
    	
    	@DELETE
    	@Path("/commande/delete/{commande}")
    	/*@Produces(MediaType.APPLICATION_JSON)*/
    	public Response deleteCommande(@PathParam("commande") String id_command){
    		String res="";
    		if (GestionClientBDD.deleteCommande(Integer.valueOf(id_command))>0){
    			res = "Delete succeed";}
    		else{
    			res = "Delete fail";
    		}	
    		
    		return Response.ok().entity(res).build();
    	}
    	
    	@GET
    	@Path("/commande/detail")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response getCommandDetail(@QueryParam("commande") String id_commande, @QueryParam("detail") String id_commande_detail) throws URISyntaxException, FileNotFoundException{
    		
    		Commande_detail command_detail=GestionClientBDD.findCommande_detail(Integer.valueOf(id_commande), Integer.valueOf(id_commande_detail));
    		if (command_detail==null)
    		{return Response.ok().entity("N'ont pas ce donne").build();}
    		return Response.ok(command_detail).build();
    		
    	}
    	
    	@GET
    	@Path("/commande/detail/{commande}")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response getCommandDetail(@PathParam("commande") String id_command) throws URISyntaxException, FileNotFoundException{    		
    		List <Commande_detail> command_detail=GestionClientBDD.findAllCommande_detail(Integer.valueOf(id_command));			
    		return Response.ok(command_detail).build();
    		
    	}
    	
    	@POST // Méthode HTTP utilisée pour déclencher cette méthode
    	@Path("/commande/detail/create")
    	/*http://localhost:8080/SR03/rest/client/create?username=testqwq@123.com&password=asdkhfbsuif&name=hehe&firstname=haha&gender=H&birthdate=1990-01-01*/    
    	public Response createCommandDetail(@QueryParam("commande") String id_commande, @QueryParam("jeux") String id_jeux ,@QueryParam("nombre") String nombre) {
                 
    		Commande_detail newCommande_detail = new Commande_detail(0, Integer.valueOf(id_commande), Integer.valueOf(id_jeux), Integer.valueOf(nombre));
                          
            String res="";
    		if (GestionClientBDD.insertCommande_detail(newCommande_detail)>0){
    			res = "Add succeed";}
    		else{
    			res = "Add fail";
    		}

            return Response
              .status(Status.OK)
              .entity(res)
              .build();
        }
    	
    	@DELETE
    	@Path("/commande/detail/delete/{commande}")
    	/*@Produces(MediaType.APPLICATION_JSON)*/
    	public Response deleteCommandeDetail(@PathParam("commande") String id_command){
    		String res="";
    		if (GestionClientBDD.deleteAllCommande_detail(Integer.valueOf(id_command))>0){
    			res = "Delete succeed";}
    		else{
    			res = "Delete fail";
    		}
    		
    		
    		return Response.ok().entity(res).build();
    	}

}