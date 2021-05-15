package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorPost {

    private ServicioPost servicioPost;

    @Autowired
    public ControladorPost(ServicioPost servicioPost) {
        this.servicioPost = servicioPost;
    }


    @RequestMapping(path="/posts")
    public ModelAndView viewPosts() {

        ModelMap modelo = new ModelMap();

        List<Post> posts = servicioPost.findAll();
        modelo.put("posts", posts);

        return new ModelAndView("postsHome", modelo);
    }
    @RequestMapping(path="/create/post")
    public ModelAndView createPost() {

        ModelMap modelo = new ModelMap();

       Post post = new Post();
        modelo.put("post", post);

        return new ModelAndView("postsForm", modelo);
    }
    @RequestMapping(path="/create/post",method = RequestMethod.POST)
    public ModelAndView guardarPost(@ModelAttribute("post") Post post, HttpServletRequest request) {

        ModelMap modelo = new ModelMap();


        servicioPost.save(post);
        if (post != null) {
            request.getSession().setAttribute("Post", post);
            return new ModelAndView("redirect:/posts");
        } else {
            // si el usuario no existe agrega un mensaje de error en el modelo.
            modelo.put("error", "Usuario o clave incorrecta");
        }



        return new ModelAndView("postsForm", modelo);
    }
    @RequestMapping(path="/post/{id}")
    public ModelAndView viewPostById(@PathVariable("id")Long id) {

        ModelMap modelo = new ModelMap();

        Post post =    servicioPost.postFindById(id);;
        modelo.put("post", post);

        return new ModelAndView("postsDetail", modelo);
    }
    @RequestMapping(path="/post/delete/{id}")
    public ModelAndView deletePost(@PathVariable("id")Long id) {



        Post post =    servicioPost.postFindById(id);

        servicioPost.delete(post);


        return new ModelAndView("redirect:/posts");
    }
}
