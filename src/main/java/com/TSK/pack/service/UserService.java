package com.TSK.pack.service;

import com.TSK.pack.datamodels.dto.UserDTO;
import com.TSK.pack.datamodels.vo.UserRegisterVO;
import com.TSK.pack.model.User;
import com.TSK.pack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDTO userById(int user_Id) throws Exception{
        Optional<User> searchedUser = this.userRepository.findById(user_Id);
        return new UserDTO(searchedUser.orElseThrow(() -> new Exception("해당 유저를 찾지 못하였습니다.")));
    }

    public List<UserDTO> users(){
        return this.userRepository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public void initializeUsers(){
        User user1 = User.builder()
                .user_name("Mr홍길동")
                .user_email("example11@gmail.com")
                .user_phone(01012340000)
                .user_gender("남")
                .build();

        User user2 = User.builder()
                .user_name("Mrs홍길순")
                .user_email("example12@gmail.com")
                .user_phone(01000001234)
                .user_gender("여")
                .build();

        User user3 = User.builder()
                .user_name("Mr홍성질")
                .user_email("example13@gmail.com")
                .user_phone(01000004321)
                .user_gender("남")
                .build();

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);
        this.userRepository.flush();
    }

    public int createUser(UserRegisterVO userRegisterVO){
        User createUser = User.builder()
                .user_name(userRegisterVO.getUser_name())
                .user_email(userRegisterVO.getUser_email())
                .user_phone(userRegisterVO.getUser_phone())
                .user_gender(userRegisterVO.getUser_gender())
                .build();

        this.userRepository.save(createUser);
        this.userRepository.flush();

        return createUser.getUser_Id();
    }

    public void deleteUser(int userid){
        this.userRepository.deleteById(userid);
    }

}
