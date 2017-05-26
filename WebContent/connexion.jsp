<%@ page pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="utf-8" />

        <title>Connexion</title>

        <link type="text/css" rel="stylesheet" href="form.css" />

    </head>

    <body>

        <form method="post" action="connexion">

            <fieldset align="center" height="200" width="400">

                <legend>Connexion</legend>

                <p>Vous pouvez vous connecter via ce formulaire.</p>


                <label for="nom">Adresse email <span class="requis">*</span></label>

                <input type="email" id="username" name="username" value="<c:out value="${client.username}"/>" size="20" maxlength="60" />

                <span class="erreur">${form.erreurs['username']}</span>

                


                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>

                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />

                <span class="erreur">${form.erreurs['password']}</span>


				<input type="reset" value=" Reset " />
                <input type="submit" value="Connexion" class="sansLabel" />

                

                

                 <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

                

                <%-- Vérification de la présence d'un objet utilisateur en session --%>

                <c:if test="${!empty sessionScope.sessionClient}">

                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>

                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionClient.username}</p>
                    <a href="GestionProfile?action=afficher">Afficher votre profil</a>

                </c:if>
                 <c:if test="${empty sessionScope.sessionClient}">

                    <p class="succes" >Vous n'êtes pas encore connecté(e) </p>

                </c:if>

            </fieldset>

        </form>
        
         <form method="post" action="Deconnexion">

            <fieldset>

                
                <input type="submit" value="Deconnexion" class="sansLabel" />


            </fieldset>

        </form>

    </body>

</html>