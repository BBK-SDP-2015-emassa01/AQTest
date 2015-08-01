package aq;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AQScore {

	String name = null;
	String ageGroup = null;
	int age;
	Scanner input = new Scanner(System.in);
	int answer;
	int counter = 0;
	int result = 0;
	
	int[] answers = new int[50];

	// boolean numEntered = false;

	public static void main(String[] args) {
		AQScore aqScore = new AQScore();
		aqScore.launch();
		System.out.println("Completed AQ");
		
	}

	public void launch() {
		System.out.println("What is your name?");
		this.name = input.nextLine();
		System.out.println("What is your age?");
		// while (numEntered =false){
		try {
			this.age = input.nextInt();
			// numEntered = true;
		} catch (InputMismatchException ime) {
			System.out.println("Try entering in a number.");
			ime.printStackTrace();
		}
		// }

		if (this.age < 13) {
			this.ageGroup = "child";
			askQuestions("AQChild.txt");
		} else if (this.age >= 13 && age < 18) {
			this.ageGroup = "adolescent";
			askQuestions("AQAdolescent.txt");
		} else if (this.age >= 18) {
			this.ageGroup = "adult";
			askQuestions("AQAdult.txt");
		}
		writeArrayToFile();
	}

	// iterate through questions
	public void askQuestions(String string) {
		
		try {
			FileInputStream fstream = new FileInputStream(string);

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			// Read File Line By Line
			System.out
			.println("Please read each statement very carefully and rate how strongly you agree or disagree by selecting the appropriate number beside  each question.\n");
			try {
				while ((strLine = br.readLine()) != null) {
					// Print the content on the console
					System.out.println("\n" + strLine);
					selectOption();	
				}
				result = calculateAQ();
				System.out.println("Your AQ result is: " + result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Close the input stream
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectOption() {
		@SuppressWarnings("resource")
		Scanner intInput = new Scanner(System.in); 
		System.out.println("1. Definitely Agree\n2. Slightly Agree\n3. Slightly Disagree\n4. Definitely Disagree\n");
		this.answer = intInput.nextInt();
		int temp = this.answer;
//		System.out.println(temp);
		if (temp > 4) {
			System.out.println("Answer is not valid, assigning value of 0 to this Q.");
			answer = 0;
		}
		answers[counter] = answer;
		counter++;	
	}
	
	public void writeArrayToFile(){
		FileWriter fw = null;
		try {
			fw = new FileWriter(name+age+ageGroup+".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
		for (int i = 0; i < answers.length; i++) {
	      try {
			fw.write(answers[i] + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int calculateAQ(){
		int AQScore = 0;
		if (age>=18){
			if (answers[1] < 3) AQScore ++;
			if (answers[3] < 3) AQScore ++;
			if (answers[4] < 3) AQScore ++;
			if (answers[5] < 3) AQScore ++;
			if (answers[6] < 3) AQScore ++;
			if (answers[8] < 3) AQScore ++;
			if (answers[11] < 3) AQScore ++;
			if (answers[12] < 3) AQScore ++;
			if (answers[15] < 3) AQScore ++;
			if (answers[17] < 3) AQScore ++;
			if (answers[18] < 3) AQScore ++;
			if (answers[19] < 3) AQScore ++;
			if (answers[20] < 3) AQScore ++;
			if (answers[21] < 3) AQScore ++;
			if (answers[22] < 3) AQScore ++;
			if (answers[25] < 3) AQScore ++;
			if (answers[32] < 3) AQScore ++;
			if (answers[34] < 3) AQScore ++;
			if (answers[38] < 3) AQScore ++;
			if (answers[40] < 3) AQScore ++;
			if (answers[41] < 3) AQScore ++;
			if (answers[42] < 3) AQScore ++;
			if (answers[44] < 3) AQScore ++;
			if (answers[45] < 3) AQScore ++;
		
			
			if (answers[0] > 2) AQScore ++;
			if (answers[2] > 2) AQScore ++;
			if (answers[7] > 2) AQScore ++;
			if (answers[9] > 2) AQScore ++;
			if (answers[10] > 2) AQScore ++;
			if (answers[13] > 2) AQScore ++;
			if (answers[14] > 2) AQScore ++;
			if (answers[16] > 2) AQScore ++;
			if (answers[23] > 2) AQScore ++;
			if (answers[24] > 2) AQScore ++;
			if (answers[26] > 2) AQScore ++;
			if (answers[27] > 2) AQScore ++;
			if (answers[28] > 2) AQScore ++;
			if (answers[29] > 2) AQScore ++;
			if (answers[30] > 2) AQScore ++;
			if (answers[31] > 2) AQScore ++;
			if (answers[33] > 2) AQScore ++;
			if (answers[35] > 2) AQScore ++;
			if (answers[36] > 2) AQScore ++;
			if (answers[37] > 2) AQScore ++;
			if (answers[39] > 2) AQScore ++;
			if (answers[43] > 2) AQScore ++;
			if (answers[46] > 2) AQScore ++;
			if (answers[47] > 2) AQScore ++;
			if (answers[48] > 2) AQScore ++;
			if (answers[49] > 2) AQScore ++;
			
			if (AQScore > 32 ){
				System.out.println("You are above threshold for ASD.");
			}
		}
		
		if (age<13){ //TODO
			if (answers[0] ==2) AQScore ++;
			if (answers[1] ==3) AQScore ++;
			if (answers[2] ==2) AQScore ++;
			if (answers[3] ==3) AQScore ++;
			if (answers[4] ==3) AQScore ++;
			if (answers[5] ==3) AQScore ++;
			if (answers[6] ==3) AQScore ++;
			if (answers[7] ==2) AQScore ++;
			if (answers[8] ==3) AQScore ++;
			if (answers[9] ==2) AQScore ++;
			
			if (answers[10] ==2) AQScore ++;
			if (answers[11] ==3) AQScore ++;
			if (answers[12] ==3) AQScore ++;
			if (answers[13] ==2) AQScore ++;
			if (answers[14] ==2) AQScore ++;
			if (answers[15] ==3) AQScore ++;
			if (answers[16] ==2) AQScore ++;
			if (answers[17] ==3) AQScore ++;
			if (answers[18] ==3) AQScore ++;
			if (answers[19] ==3) AQScore ++;
			
			if (answers[20] ==3) AQScore ++;
			if (answers[21] ==3) AQScore ++;
			if (answers[22] ==3) AQScore ++;
			if (answers[23] ==2) AQScore ++;
			if (answers[24] ==2) AQScore ++;
			if (answers[25] ==3) AQScore ++;
			if (answers[26] ==2) AQScore ++;
			if (answers[27] ==2) AQScore ++;
			if (answers[28] ==2) AQScore ++;
			if (answers[29] ==2) AQScore ++;
			
			if (answers[30] ==2) AQScore ++;
			if (answers[31] ==2) AQScore ++;
			if (answers[32] ==3) AQScore ++;
			if (answers[33] ==2) AQScore ++;
			if (answers[34] ==3) AQScore ++;
			if (answers[35] ==2) AQScore ++;
			if (answers[36] ==2) AQScore ++;
			if (answers[37] ==2) AQScore ++;
			if (answers[38] ==3) AQScore ++;
			if (answers[39] ==2) AQScore ++;
			
			if (answers[40] ==3) AQScore ++;
			if (answers[41] ==3) AQScore ++;
			if (answers[42] ==3) AQScore ++;
			if (answers[43] ==2) AQScore ++;
			if (answers[44] ==3) AQScore ++;
			if (answers[45] ==3) AQScore ++;
			if (answers[46] ==2) AQScore ++;
			if (answers[47] ==2) AQScore ++;
			if (answers[48] ==2) AQScore ++;
			if (answers[49] ==2) AQScore ++;
			
			if (answers[0] ==3) AQScore = AQScore+2;
			if (answers[1] ==2) AQScore = AQScore+2;
			if (answers[2] ==3) AQScore = AQScore+2;
			if (answers[3] ==2) AQScore = AQScore+2;
			if (answers[4] ==2) AQScore = AQScore+2;
			if (answers[5] ==2) AQScore = AQScore+2;
			if (answers[6] ==2) AQScore = AQScore+2;
			if (answers[7] ==3) AQScore = AQScore+2;
			if (answers[8] ==2) AQScore = AQScore+2;
			if (answers[9] ==3) AQScore = AQScore+2;
			
			if (answers[10] ==3) AQScore = AQScore+2;
			if (answers[11] ==2) AQScore = AQScore+2;
			if (answers[12] ==2) AQScore = AQScore+2;
			if (answers[13] ==3) AQScore = AQScore+2;
			if (answers[14] ==3) AQScore = AQScore+2;
			if (answers[15] ==2) AQScore = AQScore+2;
			if (answers[16] ==3) AQScore = AQScore+2;
			if (answers[17] ==2) AQScore = AQScore+2;
			if (answers[18] ==2) AQScore = AQScore+2;
			if (answers[19] ==2) AQScore = AQScore+2;
			
			if (answers[20] ==2) AQScore = AQScore+2;
			if (answers[21] ==2) AQScore = AQScore+2;
			if (answers[22] ==2) AQScore = AQScore+2;
			if (answers[23] ==3) AQScore = AQScore+2;
			if (answers[24] ==3) AQScore = AQScore+2;
			if (answers[25] ==2) AQScore = AQScore+2;
			if (answers[26] ==3) AQScore = AQScore+2;
			if (answers[27] ==3) AQScore = AQScore+2;
			if (answers[28] ==3) AQScore = AQScore+2;
			if (answers[29] ==3) AQScore = AQScore+2;
			
			if (answers[30] ==3) AQScore = AQScore+2;
			if (answers[31] ==3) AQScore = AQScore+2;
			if (answers[32] ==2) AQScore = AQScore+2;
			if (answers[33] ==3) AQScore = AQScore+2;
			if (answers[34] ==2) AQScore = AQScore+2;
			if (answers[35] ==3) AQScore = AQScore+2;
			if (answers[36] ==3) AQScore = AQScore+2;
			if (answers[37] ==3) AQScore = AQScore+2;
			if (answers[38] ==2) AQScore = AQScore+2;
			if (answers[39] ==3) AQScore = AQScore+2;
			
			if (answers[40] ==2) AQScore = AQScore+2;
			if (answers[41] ==2) AQScore = AQScore+2;
			if (answers[42] ==2) AQScore = AQScore+2;
			if (answers[43] ==3) AQScore = AQScore+2;
			if (answers[44] ==2) AQScore = AQScore+2;
			if (answers[45] ==2) AQScore = AQScore+2;
			if (answers[46] ==3) AQScore = AQScore+2;
			if (answers[47] ==3) AQScore = AQScore+2;
			if (answers[48] ==3) AQScore = AQScore+2;
			if (answers[49] ==3) AQScore = AQScore+2;
			
			if (answers[0] ==4) AQScore = AQScore+3;
			if (answers[1] ==1) AQScore = AQScore+3;
			if (answers[2] ==4) AQScore = AQScore+3;
			if (answers[3] ==1) AQScore = AQScore+3;
			if (answers[4] ==1) AQScore = AQScore+3;
			if (answers[5] ==1) AQScore = AQScore+3;
			if (answers[6] ==1) AQScore = AQScore+3;
			if (answers[7] ==4) AQScore = AQScore+3;
			if (answers[8] ==1) AQScore = AQScore+3;
			if (answers[9] ==4) AQScore = AQScore+3;
			
			if (answers[10] ==4) AQScore = AQScore+3;
			if (answers[11] ==1) AQScore = AQScore+3;
			if (answers[12] ==1) AQScore = AQScore+3;
			if (answers[13] ==4) AQScore = AQScore+3;
			if (answers[14] ==4) AQScore = AQScore+3;
			if (answers[15] ==1) AQScore = AQScore+3;
			if (answers[16] ==4) AQScore = AQScore+3;
			if (answers[17] ==1) AQScore = AQScore+3;
			if (answers[18] ==1) AQScore = AQScore+3;
			if (answers[19] ==1) AQScore = AQScore+3;
		
			if (answers[20] ==1) AQScore = AQScore+3;
			if (answers[21] ==1) AQScore = AQScore+3;
			if (answers[22] ==1) AQScore = AQScore+3;
			if (answers[23] ==4) AQScore = AQScore+3;
			if (answers[24] ==4) AQScore = AQScore+3;
			if (answers[25] ==1) AQScore = AQScore+3;
			if (answers[26] ==4) AQScore = AQScore+3;
			if (answers[27] ==4) AQScore = AQScore+3;
			if (answers[28] ==4) AQScore = AQScore+3;
			if (answers[29] ==4) AQScore = AQScore+3;
			
			if (answers[30] ==4) AQScore = AQScore+3;
			if (answers[31] ==4) AQScore = AQScore+3;
			if (answers[32] ==1) AQScore = AQScore+3;
			if (answers[33] ==4) AQScore = AQScore+3;
			if (answers[34] ==1) AQScore = AQScore+3;
			if (answers[35] ==4) AQScore = AQScore+3;
			if (answers[36] ==4) AQScore = AQScore+3;
			if (answers[37] ==4) AQScore = AQScore+3;
			if (answers[38] ==1) AQScore = AQScore+3;
			if (answers[39] ==4) AQScore = AQScore+3;
			
			if (answers[40] ==1) AQScore = AQScore+3;
			if (answers[41] ==1) AQScore = AQScore+3;
			if (answers[42] ==1) AQScore = AQScore+3;
			if (answers[43] ==4) AQScore = AQScore+3;
			if (answers[44] ==1) AQScore = AQScore+3;
			if (answers[45] ==1) AQScore = AQScore+3;
			if (answers[46] ==4) AQScore = AQScore+3;
			if (answers[47] ==4) AQScore = AQScore+3;
			if (answers[48] ==4) AQScore = AQScore+3;
			if (answers[49] ==4) AQScore = AQScore+3;
			
			if (AQScore > 75 ){
				System.out.println("You are above threshold for ASD.");
			}
		
		}
		if (age >= 13 && age < 18){
			if (answers[1] < 3) AQScore ++;
			if (answers[3] < 3) AQScore ++;
			if (answers[4] < 3) AQScore ++;
			if (answers[5] < 3) AQScore ++;
			if (answers[6] < 3) AQScore ++;
			if (answers[8] < 3) AQScore ++;
			if (answers[11] < 3) AQScore ++;
			if (answers[12] < 3) AQScore ++;
			if (answers[15] < 3) AQScore ++;
			if (answers[17] < 3) AQScore ++;
			if (answers[18] < 3) AQScore ++;
			if (answers[19] < 3) AQScore ++;
			if (answers[20] < 3) AQScore ++;
			if (answers[21] < 3) AQScore ++;
			if (answers[22] < 3) AQScore ++;
			if (answers[25] < 3) AQScore ++;
			if (answers[32] < 3) AQScore ++;
			if (answers[34] < 3) AQScore ++;
			if (answers[38] < 3) AQScore ++;
			if (answers[40] < 3) AQScore ++;
			if (answers[41] < 3) AQScore ++;
			if (answers[42] < 3) AQScore ++;
			if (answers[44] < 3) AQScore ++;
			if (answers[45] < 3) AQScore ++;
		
			
			if (answers[0] > 2) AQScore ++;
			if (answers[2] > 2) AQScore ++;
			if (answers[7] > 2) AQScore ++;
			if (answers[9] > 2) AQScore ++;
			if (answers[10] > 2) AQScore ++;
			if (answers[13] > 2) AQScore ++;
			if (answers[14] > 2) AQScore ++;
			if (answers[16] > 2) AQScore ++;
			if (answers[23] > 2) AQScore ++;
			if (answers[24] > 2) AQScore ++;
			if (answers[26] > 2) AQScore ++;
			if (answers[27] > 2) AQScore ++;
			if (answers[28] > 2) AQScore ++;
			if (answers[29] > 2) AQScore ++;
			if (answers[30] > 2) AQScore ++;
			if (answers[31] > 2) AQScore ++;
			if (answers[33] > 2) AQScore ++;
			if (answers[35] > 2) AQScore ++;
			if (answers[36] > 2) AQScore ++;
			if (answers[37] > 2) AQScore ++;
			if (answers[39] > 2) AQScore ++;
			if (answers[43] > 2) AQScore ++;
			if (answers[46] > 2) AQScore ++;
			if (answers[47] > 2) AQScore ++;
			if (answers[48] > 2) AQScore ++;
			if (answers[49] > 2) AQScore ++;
		}
		
		if (AQScore > 29 ){
			System.out.println("You are above threshold for ASD.");
		}
		
		return AQScore;	
		}
	}

