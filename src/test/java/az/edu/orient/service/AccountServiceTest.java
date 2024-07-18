package az.edu.orient.service;

import az.edu.orient.dto.AccountDto;
import az.edu.orient.entity.AccountEntity;
import az.edu.orient.handler.AccountNotFoundException;
import az.edu.orient.respository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountService accountService;

    @Test
    void updateAccountGivenValidIdThenReturnUpdatedAccountDto() {
        //setup
        Long id = 1L;
        AccountDto request = new AccountDto();
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName("Mock");
        Mockito.when(accountRepository.findById(id)).thenReturn(Optional.of(accountEntity));
        Mockito.when(accountRepository.save(accountEntity)).thenReturn(accountEntity);
        //when
        AccountDto result = accountService.updateAccount(id, request);
        //then
        assertNotNull(result);
        Mockito.verify(accountRepository, Mockito.times(1)).save(accountEntity);
    }

    @Test
    void updateAccountGivenNotValidIdThenThrowAccountNotFoundException() {
        //setuo
        Long id = 1L;
        Mockito.when(accountRepository.findById(id)).thenReturn(Optional.empty());
        //when
        AccountNotFoundException result = assertThrows(AccountNotFoundException.class, () -> accountService.updateAccount(id, new AccountDto()));
        //then
        assertNotNull(result);
        assertEquals("Account not found: 1", result.getMessage());
    }
}