package az.edu.orient.service;

import az.edu.orient.dto.AccountDto;
import az.edu.orient.entity.AccountEntity;
import az.edu.orient.handler.AccountNotFoundException;
import az.edu.orient.mapper.AccountMapper;
import az.edu.orient.respository.AccountRepository;
import az.edu.orient.type.Status;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.iban4j.IbanFormatException;
import org.springframework.stereotype.Service;

import javax.security.sasl.SaslClient;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountDto createAccount(AccountDto accountDto) {
        AccountEntity accountEntity = AccountMapper.INSTANCE.toAccountEntity(accountDto);
        accountEntity.setIban(Iban.random(CountryCode.AZ).toString());
        accountEntity.setStatus(Status.ACTIVE);
        AccountEntity saved = accountRepository.save(accountEntity);
        return AccountMapper.INSTANCE.toAccountDto(saved);
    }

    public List<AccountDto> getAllAccounts() {
        return AccountMapper.INSTANCE.toAccountDtoList(accountRepository.findAll());
    }


    public AccountDto updateAccount(Long id, AccountDto request) {
        AccountEntity accountEntity = accountRepository.findById(id)
                .orElseThrow(()->new AccountNotFoundException("Account not found: " + id));
        AccountMapper.INSTANCE.updateAccount(request, accountEntity);
        AccountEntity updated = accountRepository.save(accountEntity);
        return AccountMapper.INSTANCE.toAccountDto(updated);
    }
}
