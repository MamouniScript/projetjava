package com.mundia.Patient;

import com.mundia.Patient.entities.Patient;
import com.mundia.Patient.repositories.PatientRepo;
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
public class PatientApplication {
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
        SpringApplication.run(PatientApplication.class, args);
    }

   /* @Bean
    CommandLineRunner initDatabase(PatientRepo patientRepository) {
        return args -> {
            List<Patient> patients = List.of(
                    Patient.builder().nom("Alice Martin").age(30).adresse("12 Rue des Lilas, Paris").contact("alice.martin@example.com").build(),
                    Patient.builder().nom("Bob Durand").age(45).adresse("34 Avenue de la République, Lyon").contact("bob.durand@example.com").build(),
                    Patient.builder().nom("Caroline Dupont").age(25).adresse("56 Boulevard Saint-Michel, Marseille").contact("caroline.dupont@example.com").build(),
                    Patient.builder().nom("David Morel").age(50).adresse("78 Rue de la Paix, Bordeaux").contact("david.morel@example.com").build(),
                    Patient.builder().nom("Émilie Bernard").age(35).adresse("90 Allée des Champs, Toulouse").contact("emilie.bernard@example.com").build(),
                    Patient.builder().nom("François Petit").age(40).adresse("22 Rue Victor Hugo, Lille").contact("francois.petit@example.com").build(),
                    Patient.builder().nom("Gabrielle Lambert").age(60).adresse("33 Avenue de la Gare, Strasbourg").contact("gabrielle.lambert@example.com").build(),
                    Patient.builder().nom("Hugo Lefèvre").age(29).adresse("44 Rue des Rosiers, Nice").contact("hugo.lefevre@example.com").build(),
                    Patient.builder().nom("Isabelle Garnier").age(55).adresse("11 Rue de Bretagne, Nantes").contact("isabelle.garnier@example.com").build(),
                    Patient.builder().nom("Jacques Simon").age(48).adresse("99 Rue Nationale, Montpellier").contact("jacques.simon@example.com").build(),
                    Patient.builder().nom("Kévin Laurent").age(36).adresse("21 Avenue de Provence, Rennes").contact("kevin.laurent@example.com").build(),
                    Patient.builder().nom("Léa Moreau").age(42).adresse("88 Rue du Général Leclerc, Orléans").contact("lea.moreau@example.com").build(),
                    Patient.builder().nom("Marc Fontaine").age(28).adresse("16 Rue des Mimosas, Clermont-Ferrand").contact("marc.fontaine@example.com").build(),
                    Patient.builder().nom("Nathalie Blanc").age(52).adresse("5 Boulevard Haussmann, Paris").contact("nathalie.blanc@example.com").build(),
                    Patient.builder().nom("Olivier Roux").age(39).adresse("67 Rue Voltaire, Dijon").contact("olivier.roux@example.com").build(),
                    Patient.builder().nom("Pauline Charpentier").age(31).adresse("12 Rue des Fleurs, Angers").contact("pauline.charpentier@example.com").build(),
                    Patient.builder().nom("Quentin Lefebvre").age(47).adresse("74 Boulevard des Belges, Rouen").contact("quentin.lefebvre@example.com").build(),
                    Patient.builder().nom("Raphaël Fabre").age(33).adresse("19 Rue de l'Église, Grenoble").contact("raphael.fabre@example.com").build(),
                    Patient.builder().nom("Sophie Pelletier").age(44).adresse("31 Rue de la Liberté, Tours").contact("sophie.pelletier@example.com").build(),
                    Patient.builder().nom("Thomas Girard").age(38).adresse("10 Avenue Jean Jaurès, Amiens").contact("thomas.girard@example.com").build()
            );

            // Sauvegarder les patients dans la base
            patientRepository.saveAll(patients);

            // Afficher les données insérées dans la console
            patients.forEach(patient -> System.out.println("Inserted: " + patient));
        };
    }*/
}
