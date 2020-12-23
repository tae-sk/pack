package com.TSK.pack.datamodels.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRegisterVO {
    private String user_name;
    private String user_email;
    private int user_phone;
    private String user_gender;

    @Override
    public String toString(){
        return String.format(
                "UserRegisterVO[user_name='%s',user_email='%s',user_phone=%d,user_gender='%s']",
                this.user_name,this.user_email,this.user_phone,this.user_gender
        );
    }
}
