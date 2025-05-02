package streaming.backend.buffers;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DicebearSeedBuffer {
    private final List<String> seeds = Arrays.asList(
            "Maria", "João", "Ana", "Pedro", "Carla", "José", "Mariana", "Antônio", "Juliana", "Paulo",
            "Camila", "Luiz", "Isabela", "Carlos", "Patrícia", "Marcos", "Fernanda", "Daniel", "Vanessa",
            "Lucas", "Amanda", "Gabriel", "Larissa", "Rafael", "Débora", "Felipe", "Letícia", "Diego",
            "Tatiane", "Ricardo", "Natália", "Thiago", "Beatriz", "Vinícius", "Aline", "Leonardo", "Jessica",
            "Mateus", "Bruna", "Rodrigo", "Sabrina", "Guilherme", "Caroline", "Fábio", "Bianca", "Gustavo",
            "Andreia", "Eduardo", "Raquel", "Marcelo", "Mônica", "Fernando", "Cristina", "Alexandre", "Priscila",
            "Júlio", "Manuela", "Sérgio", "Luana", "Victor", "Patrícia", "Diego", "Mara", "Fábio",
            "Vanessa", "Renato", "Daniela", "Roberto", "Helena", "Hugo", "Luciana", "Renan", "Laura",
            "Samuel", "Bárbara", "Raul", "Valéria", "Luciano", "Andréa", "Marcela", "Rogério", "Tânia",
            "Rafaela", "Mário", "Gabriela", "Jorge", "Vivian", "Giovanni", "Renata", "Davi", "Simone",
            "Vitor", "Lívia", "Henrique", "Cíntia", "Joaquim", "Camila", "Leandro", "Priscila", "Thiago",
            "Nathalia", "Robson", "Regina", "Ricardo", "Isabel", "Lucas", "Aline", "Marcelo", "Michele",
            "Vinícius", "Danielle", "Paulo", "Fabiana", "Alex", "Carla", "Leonardo", "Tatiana", "Fernando",
            "Fernanda", "Rodrigo", "Adriana", "Felipe", "Sabrina", "Gustavo", "Natália", "Júlio", "Caroline",
            "Giovanni", "Renata", "Rafael", "Andréa", "Henrique", "Valéria", "Davi", "Vivian", "Joaquim",
            "Simone", "Leandro", "Cíntia", "Lucas", "Priscila", "Vinícius", "Regina", "Alisson", "Isabel",
            "Paulo", "Michele", "Leonardo", "Danielle", "Muria", "Fernando", "Tatiana", "Rodrigo", "Fabiana", "Felipe",
            "Carla", "Gustavo", "Sabrina", "Júlio", "Natália", "Giovanni", "Caroline", "Rafael", "Renata",
            "Henrique", "Andréa", "Davi", "Valéria", "Joaquim", "Vivian", "Simone", "Cíntia", "Leandro",
            "Priscila", "Lucas", "Regina", "Vinícius", "Isabel", "Alex", "Michele", "Paulo", "Danielle",
            "Leonardo", "Tatiana", "Fernando", "Fabiana", "Rodrigo", "Felipe", "Carla", "Sabrina", "Gustavo",
            "Natália", "Júlio", "Caroline", "Giovanni", "Renata", "Rafael", "Andréa", "Henrique", "Valéria",
            "Davi", "Vivian", "Joaquim", "Simone", "Leandro", "Cíntia", "Lucas", "Priscila", "Vinícius"
    );

    public String getRandomSeed() {
        int index = ThreadLocalRandom.current().nextInt(seeds.size());
        return seeds.get(index);
    }
}
