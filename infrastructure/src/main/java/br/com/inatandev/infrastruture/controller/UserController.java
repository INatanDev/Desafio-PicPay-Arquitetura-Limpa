package br.com.inatandev.infrastruture.controller;

import br.com.inatandev.core.exception.TransactionPinException;
import br.com.inatandev.infrastruture.dto.request.CreateUserRequest;
import br.com.inatandev.infrastruture.dto.response.BaseResponse;
import br.com.inatandev.infrastruture.mapper.UserMapper;
import br.com.inatandev.usecase.CreateUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.com.inatandev.infrastruture.utils.Utilities.log;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private CreateUserUseCase createUserUseCase;
    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception, TransactionPinException {
        log.info("Inicio da criacao do usuario::UserController");
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("Usuario criado com sucesso::UserController");
        return BaseResponse.<String>builder().success(true).message("Usuario criado com sucesso").build();
    }
}
