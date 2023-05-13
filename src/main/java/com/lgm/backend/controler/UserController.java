package com.lgm.backend.controler;



import com.lgm.backend.dto.BearerToken;
import com.lgm.backend.dto.LoginDto;
import com.lgm.backend.dto.RegisterDto;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
@EnableWebMvc
public class UserController {


    private final UserService userService;

    @GetMapping(value = "/register", produces= "text/html")
    @ResponseBody
    public String showRegisterPage(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Formulaire POST</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\t<form id=\"myForm\" method=\"POST\" action=\"/user/register\">\n" +
                "\t\t<label for=\"firstname\">Prénom :</label>\n" +
                "\t\t<input type=\"text\" name=\"firstName\" id=\"firstName\"><br>\n" +
                "\n" +
                "\t\t<label for=\"lastname\">Nom :</label>\n" +
                "\t\t<input type=\"text\" name=\"lastName\" id=\"lastName\"><br>\n" +
                "\n" +
                "\t\t<label for=\"email\">Email :</label>\n" +
                "\t\t<input type=\"email\" name=\"email\" id=\"email\"><br>\n" +
                "\n" +
                "\t\t<label for=\"password\">Mot de passe :</label>\n" +
                "\t\t<input type=\"password\" name=\"password\" id=\"password\"><br>\n" +
                "\n" +
                "\t\t<button type=\"submit\" onclick=\"submitForm()\">Envoyer</button>\n" +
                "\t</form>\n" +
                "\n" +
                "\t<script>\n" +
                "\t\tfunction submitForm() {\n" +
                "\t\t\tevent.preventDefault(); // Empêcher le formulaire de s'envoyer normalement\n" +
                "\n" +
                "\t\t\t// Récupérer les valeurs du formulaire\n" +
                "\t\t\tconst firstName = document.getElementById(\"firstName\").value;\n" +
                "\t\t\tconst lastName = document.getElementById(\"lastName\").value;\n" +
                "\t\t\tconst email = document.getElementById(\"email\").value;\n" +
                "\t\t\tconst password = document.getElementById(\"password\").value;\n" +
                "\n" +
                "\t\t\t// Créer un objet JSON avec les données du formulaire\n" +
                "\t\t\tconst data = { \"firstName\": firstName, \"lastName\": lastName, \"email\": email, \"password\": password };\n" +
                "\n" +
                "\t\t\t// Envoyer la requête POST avec les données sous forme de JSON\n" +
                "\t\t\tfetch('/user/register', {\n" +
                "\t\t\t\tmethod: 'POST',\n" +
                "\t\t\t\theaders: {\n" +
                "\t\t\t\t\t'Content-Type': 'application/json'\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\tbody: JSON.stringify(data)\n" +
                "\t\t\t}).then(response => {\n" +
                "\t\t\t\tconsole.log('Réponse du serveur :', response);\n" +
                "\t\t\t}).catch(error => {\n" +
                "\t\t\t\tconsole.error('Erreur lors de la requête :', error);\n" +
                "\t\t\t});\n" +
                "\t\t}\n" +
                "\t</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST, produces="application/json")
    @ResponseBody
    public ResponseEntity<?> register   (@RequestBody RegisterDto registerDto){
        return userService.register(registerDto);
    }



    @RequestMapping(value="/test", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Iterable<User> test(){
        return userService.getUser();
    }

    @GetMapping(value = "/authenticate", produces= "text/html")
    @ResponseBody
    public String showAuthenticatePage(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Formulaire POST</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\t<form id=\"myForm\" method=\"POST\" action=\"/user/authenticate\">\n" +
                "\t\t<label for=\"email\">Email :</label>\n" +
                "\t\t<input type=\"email\" name=\"email\" id=\"email\"><br>\n" +
                "\n" +
                "\t\t<label for=\"password\">Mot de passe :</label>\n" +
                "\t\t<input type=\"password\" name=\"password\" id=\"password\"><br>\n" +
                "\n" +
                "\t\t<input type=\"checkbox\" name=\"private\" id=\"private\">\n" +
                "\t\t<label for=\"private\">Connexion privée</label><br>\n" +
                "\n" +
                "\t\t<button type=\"submit\" onclick=\"submitForm()\">Se connecter</button>\n" +
                "\t</form>\n" +
                "\n" +
                "\t<script>\n" +
                "\t\tfunction submitForm() {\n" +
                "\t\t\tevent.preventDefault(); // Empêcher le formulaire de s'envoyer normalement\n" +
                "\n" +
                "\t\t\t// Récupérer les valeurs du formulaire\n" +
                "\t\t\tconst email = document.getElementById(\"email\").value;\n" +
                "\t\t\tconst password = document.getElementById(\"password\").value;\n" +
                "\t\t\tconst private = document.getElementById(\"private\").checked;\n" +
                "\n" +
                "\t\t\t// Créer un objet JSON avec les données du formulaire\n" +
                "\t\t\tconst data = { \"email\": email, \"password\": password, \"private\": private };\n" +
                "\n" +
                "\t\t\t// Envoyer la requête POST avec les données sous forme de JSON\n" +
                "\t\t\tfetch('/user/authenticate', {\n" +
                "\t\t\t\tmethod: 'POST',\n" +
                "\t\t\t\theaders: {\n" +
                "\t\t\t\t\t'Content-Type': 'application/json'\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\tbody: JSON.stringify(data)\n" +
                "\t\t\t}).then(response => {\n" +
                "\t\t\t\tconsole.log('Réponse du serveur :', response);\n" +
                "\t\t\t\t// Rediriger vers la page de connexion privée si l'utilisateur a coché la case \"Connexion privée\"\n" +
                "\t\t\t\tif (private) {\n" +
                "\t\t\t\t\twindow.location.href = '/user/private';\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}).catch(error => {\n" +
                "\t\t\t\tconsole.error('Erreur lors de la requête :', error);\n" +
                "\t\t\t});\n" +
                "\t\t}\n" +
                "\t</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }


    @PostMapping("/authenticate")
    @ResponseBody
    public BearerToken authenticate(@RequestBody LoginDto loginDto) {
        return  userService.authenticate(loginDto);
    }

}
