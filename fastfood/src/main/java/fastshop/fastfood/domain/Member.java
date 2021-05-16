package fastshop.fastfood.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    private Long id; // 식별
    private String name;
    private String userid;
    private String userpw;
    private String username;
    private String address;
    private String email;
    private String tel;
    private String birth;
    private String basket_p;

}

