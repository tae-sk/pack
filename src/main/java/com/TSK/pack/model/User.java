package com.TSK.pack.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_Id;

    @Column(length = 15, nullable = false)
    private String user_password;

    @Column(length = 10, nullable = false)
    private String user_name;

    @Column(length =  50, nullable = false)
    private String user_email;

    @Column(length = 11, nullable = false)
    private int user_phone;

    @Column(length = 1, nullable = false)
    private String user_gender;

    @Builder
    public User(int user_Id, String user_password, String user_name,
                String user_email, int user_phone, String user_gender){
        this.user_Id = user_Id;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_gender = user_gender;
    }

    @Override
    public String toString(){
        return String.format(
                "User[user_id=%d,user_password='%s',user_name='%s',user_email='%s',user_phone=%d,user_gender='%s']",
                this.user_Id,this.user_password,this.user_name,this.user_email,this.user_phone,this.user_gender
        );
    }
}
