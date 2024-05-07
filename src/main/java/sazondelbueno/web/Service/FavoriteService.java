package sazondelbueno.web.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sazondelbueno.web.Model.Favorite;
import sazondelbueno.web.Repository.FavoriteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository repository;

    public Favorite saveFavorite(Favorite favorite){
        return repository.save(favorite);
    }

    public List<Favorite>listFavorites(){
        return repository.findAll();
    }
    public Optional<Favorite> getById(Long id){
        return repository.findById(id);
    }

    public Favorite updateById(Long id,Favorite favorite){

        Favorite reference = repository.getReferenceById(id);
        BeanUtils.copyProperties(favorite,reference,"id");
        return repository.save(reference);

    }

    public boolean deleteById(Long id){
        try {
            repository.deleteById(id);
            return  true;

        }catch (Exception e){
            return false;
        }
    }
}
