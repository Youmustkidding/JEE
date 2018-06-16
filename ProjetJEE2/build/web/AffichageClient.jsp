<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un client</title>
        
        <!-- Bootstrap core CSS -->
        <link href="style/bootstrap.min.css" rel="stylesheet">
        <link href="style/bootstrap.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="style/shop-homepage.css" rel="stylesheet">
    </head>
    <body>
    <!-- Navigation -->
    <jsp:include page="Header.jsp" />
    <div class="container">
        <div class="col-lg-9">
        <%-- Affichage de la chaîne "message" transmise par la servlet --%>
        <h4>${ message }</h4>
        
        <%-- Puis affichage des données enregistrées dans le bean "client" transmis par la servlet --%>
        <table>
            <tr>
              <th>Nom :</th>
              <td>${ client.nom }</td>
            </tr>
            <tr>
              <th>Prénom :</th>
              <td>${ client.prenom }</td>
            </tr>
            <tr>
              <th>Adresse :</th>
              <td>${ client.adresse }</td>
            </tr>
            <tr>
              <th>Numéro de téléphone :</th>
              <td>${ client.telephone }</td>
            </tr>
            <tr>
              <th>Email :</th>
              <td>${ client.email }</td>
            </tr>
            
        </table>
            <br/>
        </div>
    </div>
     <!-- Navigation -->
    <jsp:include page="Footer.jsp" />
    </body>

</html>