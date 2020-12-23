package com.TSK.pack.datamodels.dto;

import com.TSK.pack.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private int user_Id;
    private String user_password;
    private String user_name;
    private String user_email;
    private int user_phone;
    private String user_gender;

    public UserDTO(User user){
        this.user_Id = user.getUser_Id();
        this.user_password = user.getUser_password();
        this.user_name = user.getUser_name();
        this.user_email = user.getUser_email();
        this.user_phone = user.getUser_phone();
        this.user_gender = user.getUser_gender();
    }

    @Override
    public String toString(){
        return String.format(
                "User[user_id=%d,user_password='%s',user_name='%s',user_email='%s',user_phone=%d,user_gender='%s']",
                this.user_Id,this.user_password,this.user_name,this.user_email,this.user_phone,this.user_gender
        );
    }
}
