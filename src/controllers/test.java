package controllers;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/*
import fr.utc.dsi.trombi.IndividuelLocal;
import fr.utc.dsi.trombi.StructureNom;
import fr.utc.dsi.trombi.TrombiIndividus;

@Stateless 
@Path("/mytrombi")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class Trombiws {

@EJB
private IndividuelLocal ind;


private List<TrombiTemplate> template;
private List<TrombiIndividus> individus;

private List<StructureNom> structure_nom_pere;
private List<StructureNom> structure_nom_fils;
private List<Long> structure_pere;
private List<Long> structure_fils;


public Trombiws() {
template = new ArrayList<TrombiTemplate>();
structure_nom_pere = new ArrayList<StructureNom>();
structure_nom_fils = new ArrayList<StructureNom>();
}

public static String removeAccent(String source) {
return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
}


@GET
@Path("/result")
public Response getresult(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom)
{

template.clear();
TrombiTemplate trombiObj = new TrombiTemplate();

individus = ind.individus(nom, prenom);

for(TrombiIndividus cursor : individus)
{

trombiObj.setNom(cursor.getNomp());
trombiObj.setPrenom(cursor.getPrenomAz());
trombiObj.setAutorisation(cursor.getTrombiDiffuserPhoto$f());
if(cursor.getLoca()!=null)
trombiObj.setBureau(cursor.getLoca());
else
trombiObj.setBureau("");
if(cursor.getMail()!=null)
trombiObj.setMail(cursor.getMail());
else
trombiObj.setMail("");
if(cursor.getFonction()!=null)
trombiObj.setPoste(cursor.getFonction());	
else	
trombiObj.setPoste("");	

if(cursor.getStructLibelleFils()!=null)
trombiObj.setSousStructure(cursor.getStructLibelleFils());
else
trombiObj.setSousStructure("");

if(cursor.getStructureLibelle()!=null)
trombiObj.setStructure(cursor.getStructureLibelle());
else
trombiObj.setStructure("");

if(cursor.getTelPoste1()!=null)
trombiObj.setTel(cursor.getTelPoste1());
else
trombiObj.setTel("");

if(cursor.getTelPoste2()!=null)
trombiObj.setTel2(cursor.getTelPoste2());
else
trombiObj.setTel2("");

if(cursor.getLogin()!=null)
trombiObj.setLogin(cursor.getLogin());
else
trombiObj.setLogin("");

template.add(trombiObj);
trombiObj = new TrombiTemplate();

}	

return Response.ok(template).build();
}






//-----------------------------------------------------------
public List<TrombiTemplate> getTemplate() {
return template;
}

public void setTemplate(List<TrombiTemplate> template) {
this.template = template;
}

public List<TrombiIndividus> getIndividus() {
return individus;
}

public void setIndividus(List<TrombiIndividus> individus) {
this.individus = individus;
}

public List<StructureNom> getStructure_nom_pere() {
return structure_nom_pere;
}

public void setStructure_nom_pere(List<StructureNom> structure_nom_pere) {
this.structure_nom_pere = structure_nom_pere;
}

public List<StructureNom> getStructure_nom_fils() {
return structure_nom_fils;
}

public void setStructure_nom_fils(List<StructureNom> structure_nom_fils) {
this.structure_nom_fils = structure_nom_fils;
}

public List<Long> getStructure_pere() {
return structure_pere;
}

public void setStructure_pere(List<Long> structure_pere) {
this.structure_pere = structure_pere;
}

public List<Long> getStructure_fils() {
return structure_fils;
}

public void setStructure_fils(List<Long> structure_fils) {
this.structure_fils = structure_fils;
}

}*/