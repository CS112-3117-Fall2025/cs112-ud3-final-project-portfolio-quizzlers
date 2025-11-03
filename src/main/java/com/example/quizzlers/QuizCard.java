package com.example.quizzlers;

public class QuizCard {
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;

    private final String DEFAULT_OPTION_TEXT = "Option A";

    private int numOptions = 4;
    private String[] optionsArray = new String[numOptions];

    //Setters
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public void setAnswer(String answer) {
        if (answer != null) {
            if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || answer.equalsIgnoreCase("C")
                    || answer.equalsIgnoreCase("D")) {
                this.answer = answer;
                System.out.println("Set answer to " + answer.toUpperCase() + ".");
                return;
            } else {
                System.out.println("Warning: Answer is invalid. Valid answers are A, B, C or D.");
            }
        } else {
            System.out.println("Warning: Answer is null.");
        }
    }

    public void setAll(String optionA, String optionB, String optionC, String optionD, String answer) {
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        setAnswer(answer);
    }

    //Getters
    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getAnswer() {
        return answer.toUpperCase();
    }

    //Other methods
    @Override
    public String toString() {
        return "Quiz Card: " + "\n A) " + optionA + "\n B) " + optionB + "\n C) " + optionC + "\n D) " + optionD;
    }

    public void randomizeOptions() {
        int randomNum = 0;

        // convert answer to int
        int correctAnswer = -1;
        switch (answer) {
            case "A":
            case "a":
                correctAnswer = 0;
                break;
            case "B":
            case "b":
                correctAnswer = 1;
                break;
            case "C":
            case "c":
                correctAnswer = 2;
                break;
            case "D":
            case "d":
                correctAnswer = 3;
                break;
        }

        // boolean to check whether an option has already been placed in the array
        boolean randomizedOptionA = false, randomizedOptionB = false, randomizedOptionC = false, randomizedOptionD = false, randomizedAnswer = false;

        // loop through each option index in the array. once an index is filled, it
        // cannot be assigned an option.
        while (!randomizedOptionA || !randomizedOptionB || !randomizedOptionC || !randomizedOptionD) {
            // generate a random int between 0 and 3
            randomNum = (int) (Math.random() * 4);

            // Only assign if the index is empty (null)
            if (this.optionsArray[randomNum] == null) {
                if (!randomizedOptionA) {
                    // reassign the option to the randomly generated index
                    System.out.printf("Reassigning option A to index %d.\n", randomNum);
                    this.optionsArray[randomNum] = this.optionA;
                    // reassign answer if it is correct
                    if (correctAnswer == 0 && !randomizedAnswer) {
                        correctAnswer = randomNum;
                        System.out.println("Answer has moved to index " + correctAnswer + ".");
                        randomizedAnswer = true;
                    }
                    // close the index from being accessed again in the loop
                    randomizedOptionA = true;
                } else if (!randomizedOptionB) {
                    // reassign the option to the randomly generated index
                    System.out.printf("Reassigning option B to index %d.\n", randomNum);
                    this.optionsArray[randomNum] = this.optionB;
                    // reassign answer if it is correct
                    if (correctAnswer == 1 && !randomizedAnswer) {
                        correctAnswer = randomNum;
                        System.out.println("Answer has moved to index " + correctAnswer + ".");
                        randomizedAnswer = true;
                    }
                    // close the index from being accessed again in the loop
                    randomizedOptionB = true;
                } else if (!randomizedOptionC) {
                    // reassign the option to the randomly generated index
                    System.out.printf("Reassigning option C to index %d.\n", randomNum);
                    this.optionsArray[randomNum] = this.optionC;
                    // reassign answer if it is correct
                    if (correctAnswer == 2 && !randomizedAnswer) {
                        correctAnswer = randomNum;
                        System.out.println("Answer has moved to index " + correctAnswer + ".");
                        randomizedAnswer = true;
                    }
                    // close the index from being accessed again in the loop
                    randomizedOptionC = true;
                } else if (!randomizedOptionD) {
                    // reassign the option to the randomly generated index
                    System.out.printf("Reassigning option D to index %d.\n", randomNum);
                    this.optionsArray[randomNum] = this.optionD;
                    // reassign answer if it is correct
                    if (correctAnswer == 3 && !randomizedAnswer) {
                        correctAnswer = randomNum;
                        System.out.println("Answer has moved to index " + correctAnswer + ".");
                        randomizedAnswer = true;
                    }
                    // close the index from being accessed again in the loop
                    randomizedOptionD = true;
                }
            }
        }

        // set new options from options array
        System.out.println("Attempting to set new values.");
        System.out.println("A should become " + this.optionsArray[0]);
        this.setOptionA(this.optionsArray[0]);
        this.setOptionB(this.optionsArray[1]);
        this.setOptionC(this.optionsArray[2]);
        this.setOptionD(this.optionsArray[3]);
        // convert answer back to string
        switch (correctAnswer) {
            case 0:
                answer = "A";
                break;
            case 1:
                answer = "B";
                break;
            case 2:
                answer = "C";
                break;
            case 3:
                answer = "D";
                break;
        }
    }

    //Equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) return false;

        QuizCard other = (QuizCard) obj;
        return optionA == other.optionA && optionB == other.optionB && optionC == other.optionC && optionD == other.optionD;
    }
}