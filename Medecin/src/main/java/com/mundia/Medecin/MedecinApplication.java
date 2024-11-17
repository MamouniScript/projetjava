package com.mundia.Medecin;

import com.mundia.Medecin.entities.Medecin;
import com.mundia.Medecin.repositories.MedecinRepo;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.List;

@SpringBootApplication
public class MedecinApplication {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient));
    }

    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(MedecinApplication.class, args);
    }

    /*@Bean
    CommandLineRunner initDatabase(MedecinRepo medecinRepository) {
        return args -> {
            List<Medecin> medecins = List.of(
                    Medecin.builder().nom("Jean Dupont").specialite("Cardiologie").contact("jean.dupont@example.com").build(),
                    Medecin.builder().nom("Marie Curie").specialite("Oncologie").contact("marie.curie@example.com").build(),
                    Medecin.builder().nom("Paul Martin").specialite("Neurologie").contact("paul.martin@example.com").build(),
                    Medecin.builder().nom("Claire Fontaine").specialite("Pédiatrie").contact("claire.fontaine@example.com").build(),
                    Medecin.builder().nom("Sophie Lambert").specialite("Dermatologie").contact("sophie.lambert@example.com").build(),
                    Medecin.builder().nom("Lucas Bernard").specialite("Orthopédie").contact("lucas.bernard@example.com").build(),
                    Medecin.builder().nom("Emma Dubois").specialite("Gynécologie").contact("emma.dubois@example.com").build(),
                    Medecin.builder().nom("Hugo Lefèvre").specialite("Radiologie").contact("hugo.lefevre@example.com").build(),
                    Medecin.builder().nom("Chloé Garnier").specialite("Psychiatrie").contact("chloe.garnier@example.com").build(),
                    Medecin.builder().nom("Léa Moreau").specialite("Endocrinologie").contact("lea.moreau@example.com").build()
            );

            // Sauvegarder les données dans la base
            medecinRepository.saveAll(medecins);

            // Afficher les données insérées dans la console
            medecins.forEach(medecin -> System.out.println("Inserted: " + medecin));
        };
    }*/
}
