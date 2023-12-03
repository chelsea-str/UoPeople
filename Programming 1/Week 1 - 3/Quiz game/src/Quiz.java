import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); // Initialize a Scanner object to read user input
        /*
        I start off by creating three arrays containing the questions, their options, and the correct answers.
        This allows a for loop to iterate through each question and check if the user input is the same
        as the corresponding correct answer.
         */
        String[] questions = {
                "What is the average lifespan of a pet rat?",
                "What is the term for a group of rats?",
                "What is the scientific name for the common brown rat, one of the most widespread rat species?",
                "Rats are known for their excellent ability to learn and solve problems. What type of intelligence" +
                        " is often attributed to rats?",
                "Rats have a pair of long, flexible tails. What is the primary purpose of their tails?"
        };
        String[] options = {
                "a) 2-3 years\nb) 3-4 years\nc) 4-6 years\nd) +100 years",
                "a) Flock\nb) Swarm\nc) Pack\nd) Mischief",
                "a) Rattus rattus\nb) Rattus norvegicus\nc) Mus musculus\nd) Oryctolagus cuniculus",
                "a) Emotional Intelligence\nb) Spatial Intelligence\nc) Musical Intelligence\nd) Social Intelligence",
                "a) To store food\nb) For balance\nc) To communicate with other rats\nd) To help them fly"
        };
        char[] correctAnswers = {'a', 'd', 'b', 'd', 'b'};

        int totalQuestions = questions.length; //this variable gets the length of the list (5)
        int correctResponses = 0; // this variable counts how many correct answers the user gets

        for (int i = 0; i < totalQuestions; i++) { //int starts at 0 as this is the first element of an array
            boolean isValidInput;
            /*
            The while loop checks if the user has given a valid answer using a boolean. If they have not,
            the boolean switches to false and loops back to the question. It can only switch back to true
            once the user gives a valid input.
             */

            do {
                System.out.println("Question " + (i + 1) + ": " + questions[i]);
                System.out.println(options[i]);
                System.out.print("Your answer: ");
                char userAnswer = userInput.next().toLowerCase().charAt(0);

                switch (userAnswer) {
                    case 'a', 'b', 'c', 'd' -> {
                        if (userAnswer == correctAnswers[i]) {
                            System.out.println("That is the correct answer!\n");
                            correctResponses++;
                        } else {
                            System.out.println("The correct answer was '" + correctAnswers[i] + "'.\n");
                        }
                        isValidInput = true;  // Valid input, exit the loop
                    }
                    default -> {
                        System.out.println("Invalid input. Please enter a valid option (a, b, c, or d).\n");
                        isValidInput = false;  // Invalid input, repeat the loop
                    }
                }
            } while (!isValidInput);
        }
        int scorePercentage = (correctResponses * 100) / totalQuestions;
        System.out.println("You got " + correctResponses + " out of 5 questions correct " + "(" + scorePercentage + "%).");
    }
}