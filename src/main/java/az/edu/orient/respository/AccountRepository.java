package az.edu.orient.respository;

import az.edu.orient.entity.AccountEntity;
import az.edu.orient.type.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findAllByUserIdAndCurrency(int userId, Currency currency);
}
