package com.example.mobilelele.model.enitity;

import com.example.mobilelele.model.enums.Role;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity{
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "name")
    private Role role;
    @OneToMany(mappedBy = "role" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserEntity> users = new ArrayList<>();

    public UserRoleEntity() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
