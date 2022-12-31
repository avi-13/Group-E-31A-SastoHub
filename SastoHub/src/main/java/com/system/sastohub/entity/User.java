package com.system.sastohub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "shb_user_seq_gen", sequenceName = "shb_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "shb_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @Column(name = "mobile_no")
    private String mobileNo;

}
