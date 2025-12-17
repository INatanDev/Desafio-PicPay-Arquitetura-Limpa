package br.com.inatandev.infrastruture.mapper;

import br.com.inatandev.core.domain.TaxNumber;
import br.com.inatandev.core.domain.User;
import br.com.inatandev.infrastruture.dto.request.CreateUserRequest;
import br.com.inatandev.infrastruture.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(User user){
        return new UserEntity(
            null,
            user.getEmail(),
            user.getPassword(),
            user.getTaxNumber().getValue(),
            user.getFullName(),
            user.getType(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        );
    }

    public User toUser(CreateUserRequest request) throws Exception {
        return new User(
            request.email(),
            request.password(),
            new TaxNumber(request.taxNumber()),
            request.fullname(),
            request.type()
        );
    }

    public User toUser(UserEntity userEntity) throws Exception {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                new TaxNumber(userEntity.getTaxNumber()),
                userEntity.getFullName(),
                userEntity.getType(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }
}
