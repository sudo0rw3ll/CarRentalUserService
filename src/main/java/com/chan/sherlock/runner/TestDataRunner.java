package com.chan.sherlock.runner;

import com.chan.sherlock.domain.Admin;
import com.chan.sherlock.domain.Client;
import com.chan.sherlock.domain.User;
import com.chan.sherlock.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private UserRepository userRepository;

    public TestDataRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Admin admin = new Admin();
        admin.setEmail("admin@gmail.com");
        admin.setUsername("admin");
        admin.setPassword("admin");
        userRepository.save(admin);

        Client client = new Client();
        client.setEmail("vnikolic7821rn@raf.rs");
        client.setFirst_name("Vid");
        client.setLast_name("Nikolic");
        client.setRental_period(0);
        client.setUsername("nikolic_konjic");
        client.setPassport_number("7754890006760705");
        client.setPassword("nikolic123!!");
        userRepository.save(client);
    }
}
