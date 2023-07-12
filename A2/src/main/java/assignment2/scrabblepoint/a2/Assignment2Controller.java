package assignment2.scrabblepoint.a2;

import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class Assignment2Controller {

    @FXML
    private Label errorLabel;

    @FXML
    private TextArea wordEntered;

    @FXML
    private Label yourPoints;

    //currentWordArrayOfCharay to store the available words and the points of that respective words
    int availableWordsAtATime[] ={9,2,2,4,12,2,3,2,8,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
    int pointsOfWord[]={1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    //Array list for storing all the words entered by the user.
    ArrayList<String> WordsEntered = new ArrayList<>();
    //variable to check the conditions of the validated word
    int conditionsChecked = 0;
    //Array list to store the points
    ArrayList<String> pointsOfCurrentWordStored= new ArrayList<>();
    //variable to store the total points of the current word
    int pointsOfCurrentWord=0;
    //variable to store the last index of the both the lists that is the points and the words
    int indexToDisplayPreviousWord=0;

    String currentWord="";

    @FXML
    void previousWords(ActionEvent event) throws IOException {
        wordEntered.setText(WordsEntered.get(indexToDisplayPreviousWord-1));
        yourPoints.setText(pointsOfCurrentWordStored.get(indexToDisplayPreviousWord-1));
        indexToDisplayPreviousWord--;
    }

    @FXML
    void submitButton(ActionEvent event) {
        pointsOfCurrentWord=0;
        conditionsChecked=0;
        errorLabel.setVisible(false);
        currentWord= wordEntered.getText();
        currentWord=currentWord.toUpperCase();
        //Conditions that checks the correct conditions of the word
        if(currentWord.length()>=2 && currentWord.length()<=8)
            conditionsChecked++;

        if(currentWord.contains("A") || currentWord.contains("E") ||
                currentWord.contains("I") || currentWord.contains("O")  ||
                currentWord.contains("U")  || currentWord.contains("Y"))
            conditionsChecked++;

        //to check whether ut has duplicate word in iy or not
        int flag=0;
        char currentWordArrayOfChar[]= currentWord.toUpperCase().toCharArray();
        for(int i =0; i<currentWord.length();i++) {
            for(int j =i+1; j<currentWord.length(); j++){
                if(currentWordArrayOfChar[i]==currentWordArrayOfChar[j])
                    flag++;
            }
        }
        if(flag==0)
            conditionsChecked++;
        if(conditionsChecked!=3){
            //if any conditions fails then error messgae displayed
            errorLabel.setVisible(true);
            errorLabel.setText("Not a valid word");
        }
        else{

            WordsEntered.add(currentWord);
            indexToDisplayPreviousWord=WordsEntered.indexOf(currentWord);
            for(int i =0; i<currentWord.length();i++){
                if(currentWordArrayOfChar[i]=='A' && availableWordsAtATime[0]>0) { pointsOfCurrentWord+=pointsOfWord[0]; availableWordsAtATime[0]--; }
                else if(currentWordArrayOfChar[i]=='A' && availableWordsAtATime[0]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter A is not available");}
                if(currentWordArrayOfChar[i]=='B' && availableWordsAtATime[1]>0) { pointsOfCurrentWord+=pointsOfWord[1]; availableWordsAtATime[1]--; }
                else if(currentWordArrayOfChar[i]=='B' && availableWordsAtATime[1]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter B is not available");}
                if(currentWordArrayOfChar[i]=='C' && availableWordsAtATime[2]>0) { pointsOfCurrentWord+=pointsOfWord[2]; availableWordsAtATime[2]--; }
                else if(currentWordArrayOfChar[i]=='C' && availableWordsAtATime[2]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter C is not available");}
                if(currentWordArrayOfChar[i]=='D' && availableWordsAtATime[3]>0) { pointsOfCurrentWord+=pointsOfWord[3]; availableWordsAtATime[3]--; }
                else if(currentWordArrayOfChar[i]=='D' && availableWordsAtATime[3]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter D is not available");}
                if(currentWordArrayOfChar[i]=='E' && availableWordsAtATime[4]>0) { pointsOfCurrentWord+=pointsOfWord[4]; availableWordsAtATime[4]--; }
                else if(currentWordArrayOfChar[i]=='E' && availableWordsAtATime[4]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter E is not available");}
                if(currentWordArrayOfChar[i]=='F' && availableWordsAtATime[5]>0) { pointsOfCurrentWord+=pointsOfWord[5]; availableWordsAtATime[5]--; }
                else if(currentWordArrayOfChar[i]=='F' && availableWordsAtATime[5]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter F is not available");}
                if(currentWordArrayOfChar[i]=='G' && availableWordsAtATime[6]>0) { pointsOfCurrentWord+=pointsOfWord[6]; availableWordsAtATime[6]--; }
                else if(currentWordArrayOfChar[i]=='G' && availableWordsAtATime[6]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter G is not available");}
                if(currentWordArrayOfChar[i]=='H' && availableWordsAtATime[7]>0) { pointsOfCurrentWord+=pointsOfWord[7]; availableWordsAtATime[7]--; }
                else if(currentWordArrayOfChar[i]=='H' && availableWordsAtATime[7]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter H is not available");}
                if(currentWordArrayOfChar[i]=='I' && availableWordsAtATime[8]>0) { pointsOfCurrentWord+=pointsOfWord[8]; availableWordsAtATime[8]--; }
                else if(currentWordArrayOfChar[i]=='I' && availableWordsAtATime[8]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter I is not available");}
                if(currentWordArrayOfChar[i]=='J' && availableWordsAtATime[9]>0) { pointsOfCurrentWord+=pointsOfWord[9]; availableWordsAtATime[9]--; }
                else if(currentWordArrayOfChar[i]=='J' && availableWordsAtATime[9]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter J is not available");}
                if(currentWordArrayOfChar[i]=='K' && availableWordsAtATime[10]>0) { pointsOfCurrentWord+=pointsOfWord[10]; availableWordsAtATime[10]--; }
                else if(currentWordArrayOfChar[i]=='K' && availableWordsAtATime[10]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter K is not available");}
                if(currentWordArrayOfChar[i]=='L' && availableWordsAtATime[11]>0) { pointsOfCurrentWord+=pointsOfWord[11]; availableWordsAtATime[11]--; }
                else if(currentWordArrayOfChar[i]=='L' && availableWordsAtATime[11]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter L is not available");}
                if(currentWordArrayOfChar[i]=='M' && availableWordsAtATime[12]>0) { pointsOfCurrentWord+=pointsOfWord[12]; availableWordsAtATime[12]--; }
                else if(currentWordArrayOfChar[i]=='M' && availableWordsAtATime[12]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter M is not available");}
                if(currentWordArrayOfChar[i]=='N' && availableWordsAtATime[13]>0) { pointsOfCurrentWord+=pointsOfWord[13]; availableWordsAtATime[13]--; }
                else if(currentWordArrayOfChar[i]=='N' && availableWordsAtATime[13]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter N is not available");}
                if(currentWordArrayOfChar[i]=='O' && availableWordsAtATime[14]>0) { pointsOfCurrentWord+=pointsOfWord[14]; availableWordsAtATime[14]--; }
                else if(currentWordArrayOfChar[i]=='O' && availableWordsAtATime[14]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter O is not available");}
                if(currentWordArrayOfChar[i]=='P' && availableWordsAtATime[15]>0) { pointsOfCurrentWord+=pointsOfWord[15]; availableWordsAtATime[15]--; }
                else if(currentWordArrayOfChar[i]=='P' && availableWordsAtATime[15]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter P is not available");}
                if(currentWordArrayOfChar[i]=='Q' && availableWordsAtATime[16]>0) { pointsOfCurrentWord+=pointsOfWord[16]; availableWordsAtATime[16]--; }
                else if(currentWordArrayOfChar[i]=='Q' && availableWordsAtATime[16]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter Q is not available");}
                if(currentWordArrayOfChar[i]=='R' && availableWordsAtATime[17]>0) { pointsOfCurrentWord+=pointsOfWord[17]; availableWordsAtATime[17]--; }
                else if(currentWordArrayOfChar[i]=='R' && availableWordsAtATime[17]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter R is not available");}
                if(currentWordArrayOfChar[i]=='S' && availableWordsAtATime[18]>0) { pointsOfCurrentWord+=pointsOfWord[18]; availableWordsAtATime[18]--; }
                else if(currentWordArrayOfChar[i]=='S' && availableWordsAtATime[18]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter S is not available");}
                if(currentWordArrayOfChar[i]=='T' && availableWordsAtATime[19]>0) { pointsOfCurrentWord+=pointsOfWord[19]; availableWordsAtATime[19]--; }
                else if(currentWordArrayOfChar[i]=='T' && availableWordsAtATime[19]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter T is not available");}
                if(currentWordArrayOfChar[i]=='U' && availableWordsAtATime[20]>0) { pointsOfCurrentWord+=pointsOfWord[20]; availableWordsAtATime[20]--; }
                else if(currentWordArrayOfChar[i]=='U' && availableWordsAtATime[20]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter U is not available");}
                if(currentWordArrayOfChar[i]=='V' && availableWordsAtATime[21]>0) { pointsOfCurrentWord+=pointsOfWord[21]; availableWordsAtATime[21]--; }
                else if(currentWordArrayOfChar[i]=='V' && availableWordsAtATime[21]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter V is not available");}
                if(currentWordArrayOfChar[i]=='W' && availableWordsAtATime[22]>0) { pointsOfCurrentWord+=pointsOfWord[22]; availableWordsAtATime[22]--; }
                else if(currentWordArrayOfChar[i]=='W' && availableWordsAtATime[22]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter W is not available");}
                if(currentWordArrayOfChar[i]=='X' && availableWordsAtATime[23]>0) { pointsOfCurrentWord+=pointsOfWord[23]; availableWordsAtATime[23]--; }
                else if(currentWordArrayOfChar[i]=='X' && availableWordsAtATime[23]==0){errorLabel.setVisible(true); errorLabel.setText("Letter X is not available");}
                if(currentWordArrayOfChar[i]=='Y' && availableWordsAtATime[24]>0) { pointsOfCurrentWord+=pointsOfWord[24]; availableWordsAtATime[24]--; }
                else if(currentWordArrayOfChar[i]=='Y' && availableWordsAtATime[24]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter Y is not available");}
                if(currentWordArrayOfChar[i]=='Z' && availableWordsAtATime[25]>0) { pointsOfCurrentWord+=pointsOfWord[25]; availableWordsAtATime[25]--; }
                else if(currentWordArrayOfChar[i]=='Z' && availableWordsAtATime[25]==0) {errorLabel.setVisible(true); errorLabel.setText("Letter Z is not available");}

                String points= Integer.toString(pointsOfCurrentWord);
                pointsOfCurrentWordStored.add(points);
                yourPoints.setText(points);
            }

        }


    }
    //sets the error message lable to invicible before commencing the program
    @FXML
    void initialize(){
        errorLabel.setVisible(false);
    }

}


