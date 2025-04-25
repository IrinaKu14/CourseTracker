package ru.jafix.ct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.jafix.ct.entity.Role;
import ru.jafix.ct.entity.User;
import ru.jafix.ct.repository.RoleRepository;
import ru.jafix.ct.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@SpringBootApplication
public class CoursetrackerApplication {


	public static void main(String[] args) {

		SpringApplication.run(CoursetrackerApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRepository roleRepository){
	//	return (args) ->{
//			User user1 = new User();
//			user1.setAge(30);
//			user1.setLogin("Oleg");
//
////			user1 = userRepository.save(user1);
////			System.out.println(user1);
//			//userRepository.deleteById(UUID.fromString("2ad7cb12-63d7-4bf2-b154-90c98a2bf96e"));
//			User user2 = new User();
//			user2.setId(UUID.fromString("b77cf3c9-d87b-4390-99fe-0b0469fc5b81"));
//			user2.setAge(25);
//			user2.setLogin("Iri");
//
//			userRepository.save(user2);
			//UUID id = UUID.fromString ("b77cf3c9-d87b-4390-99fe-0b0469fc5b81");
//			Optional<User> optUser = userRepository.findById(id);
//			if(optUser.isPresent()){
//				System.out.println(optUser.get());
//
//			}else{
//				System.out.printf("Нет в БД записи по id =%s", id);
//			}
			//List<User> users = userRepository.findAll();
			//User foundUser = userRepository.findByLogin("Iri");
			//System.out.println(foundUser);
//			List<User> ageUsers = userRepository.findByAgeGreaterThan(26);
//			System.out.println(ageUsers);
//			List<User> filtredUsers = userRepository.findByLoginStartsWithLitterAndAgeBefore(34, "P%");
//			System.out.println(filtredUsers);
//			//Тяжелый запрос - плохая практика, может упасть все=D:
//			List<User> users = userRepository.findAll();
//			System.out.println(users.stream()
//					.filter(e -> e.getAge()<34)
//					.filter(e -> e.getLogin().startsWith("P"))
//					.collect(Collectors.toList())
//			);
	//	};
		return (args) ->{
//			Role adminRole = roleRepository.findByName("Admin");
//			User user = userRepository.findByLogin("Iri");
//			user.setRole(adminRole);
//			userRepository.save(user);
//			User user = userRepository.findByLogin("Iri");
//			System.out.println(user);
			List<Role> roles = roleRepository.findAll();
			System.out.println(roles);
		};
	}

}
