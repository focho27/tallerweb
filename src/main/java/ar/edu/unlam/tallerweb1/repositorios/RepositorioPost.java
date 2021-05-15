package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Post;

import java.util.List;
import java.util.Optional;

public interface RepositorioPost {

    List<Post> findAll();
    Post postFindById(Long id);
    void save(Post post);
    void delete(Post post);


}
