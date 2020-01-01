package com.zjt.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
class SecurityApplicationTests {

    @Test
    void contextLoads() {

        System.out.println(  BCrypt.hashpw("123",BCrypt.gensalt()));

        System.out.println(BCrypt.checkpw("123","$2a$10$kCN9r5pqPt0zIIE5C9GbMuTaLJd7p3IzAKRDtpA.qx7zNkljx5TF2"));

        System.out.println(BCrypt.checkpw("123","$2a$10$T3pn8ZfyrTQ1F31bHrudYesv/ooQnzX9eNlNpnKvAxEr4O213AM8e"));


    }

}
