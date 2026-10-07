
abstract class Question {

    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQQuestion extends Question {

    MCQQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(
            questionText,
            correctAnswer,
            studentAnswer,
            points
        );
    }

    @Override
    double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TFQuestion extends Question {

    TFQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(
            questionText,
            correctAnswer,
            studentAnswer,
            points
        );
    }

    @Override
    double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class EssayQuestion extends Question {

    EssayQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(
            questionText,
            correctAnswer,
            studentAnswer,
            points
        );
    }

    @Override
    double calculateScore() {

        String answer =
            studentAnswer.toLowerCase();

        String[] keywords =
            correctAnswer.split(",");

        int matched = 0;

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        }

        if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        // Sample questions from the assignment

        Question[] questions = {

            new MCQQuestion(
                "What is the capital of France?",
                "Paris",
                "Paris",
                10
            ),

            new TFQuestion(
                "The Earth is flat?",
                "False",
                "True",
                5
            ),

            new EssayQuestion(
                "Name two primary OOP principles.",
                "Inheritance, Polymorphism, Encapsulation",
                "Polymorphism is one.",
                20
            ),

            new EssayQuestion(
                "Describe abstraction and composition.",
                "Abstraction, Composition",
                "I talked about abstraction.",
                15
            )
        };

        double total = 0;

        System.out.printf(
            "MCQ: %.2f%n",
            questions[0].calculateScore()
        );

        System.out.printf(
            "TF: %.2f%n",
            questions[1].calculateScore()
        );

        System.out.printf(
            "ESSAY: %.2f%n",
            questions[2].calculateScore()
        );

        System.out.printf(
            "ESSAY: %.2f%n",
            questions[3].calculateScore()
        );

        for (Question question : questions) {
            total += question.calculateScore();
        }

        System.out.printf(
            "Total Score: %.2f%n",
            total
        );
    }
}