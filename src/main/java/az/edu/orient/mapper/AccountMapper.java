package az.edu.orient.mapper;

import az.edu.orient.dto.AccountDto;
import az.edu.orient.entity.AccountEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    @Mapping(target = "id", ignore = true)
    AccountEntity toAccountEntity(AccountDto accountDto);
    AccountDto toAccountDto(AccountEntity accountEntity);
    List<AccountDto> toAccountDtoList(List<AccountEntity> accountEntities);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "name", target = "name")
    AccountEntity updateAccount(AccountDto accountDto, @MappingTarget AccountEntity accountEntity);
}
