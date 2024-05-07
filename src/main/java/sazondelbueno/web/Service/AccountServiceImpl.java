package sazondelbueno.web.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sazondelbueno.web.Model.Account;
import sazondelbueno.web.Repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public List<Account> listAccounts() {
        return repository.findAll();
    }

    @Override
    public Account existAccount(String email, String password) {
        return repository.getByEmailAndPassword(email, password);
    }

    @Override
    public Optional<Account> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Account updateById(Long id , Account account) {
        Account c = repository.getReferenceById(id);
        BeanUtils.copyProperties(account,c,"id");
        return repository.save(c);
    }
}
