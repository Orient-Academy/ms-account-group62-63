package az.edu.orient.controller;

import az.edu.orient.dto.AccountDto;
import az.edu.orient.handler.AccountNotFoundException;
import az.edu.orient.service.AccountService;
import az.edu.orient.type.Currency;
import az.edu.orient.validation.AccountValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = AccountController.class)
@ExtendWith(MockitoExtension.class)
class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountService accountService;

    @MockBean
    AccountValidator accountValidator;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createAccountGivenValidDtoThenReturn201() throws Exception {
        //setup
        AccountDto accountDto = new AccountDto();
        accountDto.setName("Murad");
        accountDto.setBalance(BigDecimal.ONE);
        accountDto.setCurrency(Currency.AZN);

        Mockito.doNothing().when(accountValidator).validate(Mockito.any(), Mockito.any());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
                .content(objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        //expect
        assertEquals(201, mvcResult.getResponse().getStatus());
    }

    @Test
    void updateAccountGivenNotValidIdThenReturn404() throws Exception {
        //setup
        Long id = 1L;
        AccountDto accountDto = new AccountDto();
        accountDto.setName("Murad");
        accountDto.setBalance(BigDecimal.ONE);
        accountDto.setCurrency(Currency.AZN);
        AccountNotFoundException accountNotFoundException = new AccountNotFoundException("Account not found");
        Mockito.when(accountService.updateAccount(id, accountDto)).thenThrow(accountNotFoundException);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/accounts/"+id)
                .content(objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        //expect
        assertEquals(404, mvcResult.getResponse().getStatus());
    }
}