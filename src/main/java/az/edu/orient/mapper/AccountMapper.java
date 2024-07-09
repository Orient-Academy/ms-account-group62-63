package az.edu.orient.mapper;

import az.edu.orient.dto.AccountDto;
import az.edu.orient.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    @Mapping(target = "id", ignore = true)
    AccountEntity toAccountEntity(AccountDto accountDto);
    AccountDto toAccountDto(AccountEntity accountEntity);
    List<AccountDto> toAccountDtoList(List<AccountEntity> accountEntities);
}
