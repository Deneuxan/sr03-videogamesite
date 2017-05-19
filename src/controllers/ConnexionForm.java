package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import beans.Client;

public final class ConnexionForm {
    private static final String CHAMP_EMAIL  = "username";
    private static final String CHAMP_PASS   = "password";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }
    public void setResultat(String res) {
         this.resultat=res;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Client connecterClient( HttpServletRequest request ) throws Exception {
        /* R茅cup茅ration des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        Client client = new Client();

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        client.setUsername( email );

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        client.setPassword( motDePasse );
        
        /* Initialisation du r茅sultat global de la validation. */
        if ( !erreurs.isEmpty() ) {
            resultat = "echec de la connexion.";
        } /*else {
            resultat = "echec de la connexion.";
        }*/

        return client;
    }
    
    
    
    public Client InscriptionClient( HttpServletRequest request ) throws Exception {
        /* R茅cup茅ration des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String nom = getValeurChamp( request, "nom" );
        String prenom = getValeurChamp( request, "prenom" );
        String gender = getValeurChamp( request, "gender" );
        Date date_naissance = getValeurDate( request, "date_naissance" );
        String checkmotDePasse = getValeurChamp( request, "check" );
        
        Client client = new Client();

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        client.setUsername( email );

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        client.setPassword( motDePasse );
        
        try {
            checkMotDePasse(motDePasse, checkmotDePasse);
        } catch ( Exception e ) {
            setErreur( "check", e.getMessage() );
        }
        
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setGender( gender );
        client.setDate_naissance( date_naissance );
       
        
        /* Initialisation du r茅sultat global de la validation. */
        if ( !erreurs.isEmpty() ) {
            resultat = "echec de l'inscription.";
        }/* else {
            resultat = "echec de l'inscription.";
        }*/

        return client;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caract猫res." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
    
    
    private void checkMotDePasse( String motDePasse,  String checkmotDePasse) throws Exception {
        if ( checkmotDePasse != null ) {
            if ( checkmotDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caract猫res." );
            }
            else if (!checkmotDePasse.equals(motDePasse))
            {  throw new Exception( "veuillez taper les memes mot de passe ." );   }
        } else {
            throw new Exception( "Merci de saisir votre verifivation de mot de passe." );
        }
    }
    
    

    /*
     * Ajoute un message correspondant au champ sp茅cifi茅 脿 la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * M茅thode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
    private static Date getValeurDate( HttpServletRequest request, String nomChamp ) throws ParseException {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
        	Date valeur_date =new SimpleDateFormat("yyyy-MM-dd").parse(valeur);
             return valeur_date;
        }
    }
    
    
}