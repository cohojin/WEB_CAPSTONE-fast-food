package FastFoodShop.FastFood.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Member implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String userid;
    private String userpw;
    private String tel;

    @Embedded
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> order = new ArrayList<>();

    // need for jwt
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

//    @Builder
//    public Member(Long id, String name, String userid, String userpw, String tel, Address address ) {
//        this.id = id;
//        this.name = name;
//        this.userid = userid;
//        this.userpw = userpw;
//        this.tel = tel;
//        this.address = address;
//    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }


    @Override
    public String getPassword() {
        return null;
    }


    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }





}
