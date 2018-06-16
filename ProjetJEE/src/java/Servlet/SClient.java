package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.*;
import BD.DAOClient;


@WebServlet(urlPatterns = {"/SClient"})
public class SClient extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String nom = request.getParameter( "nomClient" );
        String prenom = request.getParameter( "prenomClient" );
        String adresse = request.getParameter( "adresseClient" );
        String telephone = request.getParameter( "telephoneClient" );
        String email = request.getParameter( "emailClient" );

        String message;
        String page;

        /* Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès */
        
        //Trim() supprime les espaces en début et fin de champ
        if (nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ) {
            //Si un champ obligatoire est composé d'espace redirige vers la même page
            String site = "http://localhost:8080/ProjetJEE/PageAccueil" ; 
            response.setStatus(response.SC_MOVED_TEMPORARILY); 
            response.setHeader("Location", site);
            message = null;
        } else {
            message = "Client créé avec succès !";
        }
       
        // Création du bean Client et initialisation avec les données récupérées
        Client client = new Client();
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setAdresse( adresse );
        client.setTelephone( telephone );
        client.setEmail( email );

        
        if(DAOClient.TransformClient(client) == true){                          //Si l'ajout à la Base de donnée se passe bien
            page ="/AffichageClient.jsp";                                       //On se redirige vers la page des informations du client

        } else {                                                                //Sinon on reste sur la même page
            message = "Le client existe déjà !";
            page ="/Client.jsp";
        }
        
        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "client", client );
        request.setAttribute( "message", message );
        
        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher(page).forward( request, response );
        
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}