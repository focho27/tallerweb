package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Post;

import java.util.List;
import java.util.Optional;

public interface ServicioPost {
    List<Post> findAll();
    Post postFindById(Long id);
    void save(Post post);
    void delete(Post post);
}
