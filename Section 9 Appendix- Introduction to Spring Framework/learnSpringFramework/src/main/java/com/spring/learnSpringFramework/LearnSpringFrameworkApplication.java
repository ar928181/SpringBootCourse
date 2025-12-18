package com.spring.learnSpringFramework;

import com.spring.learnSpringFramework.enterprise.example.MyWebController;
import com.spring.learnSpringFramework.game.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
					SpringApplication.run(LearnSpringFrameworkApplication.class, args);

		//MarioGame marioGame = new MarioGame();
		//SuperContraGame superContraGame = new SuperContraGame();
		//PackmanGame packmanGame = new PackmanGame();

		GameRunner gameRunner = context.getBean(GameRunner.class);
		gameRunner.run();

		MyWebController myWebController = context.getBean(MyWebController.class);
		System.out.println("Sum:" + myWebController.returnValueFromBusinessService());
	}

}
