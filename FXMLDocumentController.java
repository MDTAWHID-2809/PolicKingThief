/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chordakatbabupolish;

import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition;
import javafx.geometry.Point3D;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Md Tawhid
 */
public class FXMLDocumentController implements Initializable {
    
    BackgroundFill backgroundFill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(backgroundFill);
    BackgroundFill backgroundFill1 = new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);
    Background background1 = new Background(backgroundFill1);
    public int ply=0;
   
    @FXML
    private Button Player2;
    @FXML
    private Button Player4;
    @FXML
    private Button Player1;
    @FXML
    private Button Player3;
    //this lock will stop to press the start button again before complete the previous game
    public int lock=1;
    
    Random rand=new Random();
    //ArrayList to hold all the card to assign 
    public ArrayList<Button> CardList=new ArrayList<>();
    //ArrayList to hold all the player
    public ArrayList<Button> PlayerList=new ArrayList<>();
    public ArrayList<Button> RandomPlayerlis=new ArrayList<>();
    
    public ArrayList<Label> LabelList=new ArrayList<>();
    public ArrayList<Label> RandomLabelList=new ArrayList<>();
    
    public ArrayList<Transition> TansitionList=new ArrayList<>();
    public ArrayList<Transition> RandomTransitionList=new ArrayList<>();
    
    public ArrayList<ImageView> ViewList=new ArrayList<>();
    public ArrayList<ImageView> RandomViewList=new ArrayList<>();
    
    public ArrayList<Label> ScoreList=new ArrayList<>();
    public ArrayList<Label> RandomScoreList=new ArrayList<>();
    //this will add all player in it
    public ArrayList<Button> PlyaerArray=new ArrayList<>();
    public ArrayList<Label> ScoreArray=new ArrayList<>();
    @FXML
    private Label winOrlost;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button bt1;
    @FXML
    private Button bt4;
    //Object to store all player and their current status
    ObjClass ob1=new ObjClass();
    ObjClass ob2=new ObjClass();
    ObjClass ob3=new ObjClass();
    ObjClass ob4=new ObjClass();
    //end here
    @FXML
    private Label l1;
    @FXML
    private Label l3;
    @FXML
    private Label l2;
    @FXML
    private Label l4;
    public int findchoractive=0;
    public int lockdecision=0;
    
    //flag to control all button
    public HashMap<String, Boolean>h=new HashMap<String,Boolean>();
   //clss object for trasition
    TranslateTransition t1=new TranslateTransition();
       
    TranslateTransition t2=new TranslateTransition();
        
    TranslateTransition t3=new TranslateTransition();
       
    TranslateTransition t4=new TranslateTransition();
    TranslateTransition t5=new TranslateTransition();
       
    TranslateTransition t6=new TranslateTransition();
        
    TranslateTransition t7=new TranslateTransition();
       
    TranslateTransition t8=new TranslateTransition();
    // RotateTransition rt=new RotateTransition(Duration.millis(150),cardButton);
      RotateTransition rt=new RotateTransition();
    ParallelTransition pt=new ParallelTransition(t1,t2,t3,t4);
    public int rand1;
   //end it here
    @FXML
    private AnchorPane AnchordId;
    @FXML
    private ImageView view1;
    @FXML
    private ImageView view3;
    @FXML
    private ImageView view4;
    @FXML
    private ImageView view2;
    public Image i=new Image("folder/im.jpg");
    @FXML
    private ColorPicker picker;
    @FXML
    private Button themeColor;
    @FXML
    private ImageView view11;
    @FXML
    private ImageView view12;
    @FXML
    private ImageView view13;
    @FXML
    private ImageView view14;
    public int index=0;
    @FXML
    private Label score1;
    @FXML
    private Label score2;
    @FXML
    private Label score4;
    @FXML
    private Label score3;
    public int receivecard=0;
    
    public int Player2Score=0;
    public int Player3Score=0;
    public int Player4Score=0;
    //if 0 police right else wrong
    public int polisRightorWrong=0;
    //if 1 then turnforchor else turnfor dakat
    public int turnporchor=1;
    @FXML
    private Label whosturn;
    @FXML
    private Circle circle;
    public int stopmultiplerotatecardatAtime=1;
     PathTransition path=new PathTransition();
    // method to insert all the card into playerlist and all the button to map with value true. so initialy they can be available
    //when any button is false in map then you can not click
    public void insertCard(){
        
         CardList.add(bt1);
         CardList.add(bt2);
         CardList.add(bt3);
         CardList.add(bt4);
         
        //storing player into player arraylist to further guess
         h.put("bt1", true);
         h.put("bt2", true);
         h.put("bt3", true);
         h.put("bt4", true);
         //starting of the game making all the card text to empty
         for(int i=0;i<CardList.size();i++){
            CardList.get(i).setText(" ");
         }
    }
   //method to initialize who is Chor polis Dakat Babu
    @FXML
    public void StratGame(){
        //if lock is 1 then new game will be started
       
       if(lock==1){
          
          //making the start button disable it will be release after a round is completed
          lock=0;
          receivecard=1;
          //at the starting ply=0 means there are 4 card available
          ply=0;
          //making findchoractive means you can able to search for chor are dakat but this also 
         
          //starting the new throw cleareverything
          clearEverithing();
         
          //inserting everything in the list 
          insertingInList();
          transmition();
         
          if(turnporchor==1){
              turnporchor=0;
              whosturn.setText("Turn For Dakat");
             
           }
          else{
              turnporchor=1;
              whosturn.setText("Turn For Chor");
              
           }
         }   
 }
    //receive the card and start playing after card is thrown on the air
    @FXML
    public void ReceivingTheCard(ActionEvent event){
        //this is the initial part when the game is just started
      if(stopmultiplerotatecardatAtime==1&& lock==0){ 
                  stopmultiplerotatecardatAtime=0;
       if(receivecard==1){
        EventObject evo = new EventObject(event.getSource());
        Object obj = evo.getSource();
        Button btnMirror = (Button)obj;
        Boolean b=isTrue(btnMirror);
        String id=btnMirror.getId();
         
        if(b==true){
         
            
             if(ply==0){
                 
               //locking the card button which is now pressed
              lockCardtoPressDoubl(btnMirror);
              String s= btnMirror.getText();
              //RandomPlayerlis.get(0).setText(s);
              
              
            
             if(s.equals("Chor")||s.equals("Dakat")){
              
              //fading the button when reavel what is status
              
                  rotateCard(id,btnMirror,Color.BLUE,RandomPlayerlis.get(0),Color.YELLOW,s,RandomLabelList.get(0));
              

            
             
            // btnMirror.setTextFill(Color.BLUE);
             //RandomPlayerlis.get(0).setTextFill(Color.YELLOW);
             // Player1.setBackground(background);
            
             
             }
             else{
                
                  rotateCard(id,btnMirror,Color.WHITE,RandomPlayerlis.get(0),Color.BLACK,s,RandomLabelList.get(0));
                 //btnMirror.setTextFill(Color.WHITE);
                // RandomPlayerlis.get(0).setTextFill(Color.BLACK);
                 
                 
             }
              ply++;
           }
           else if(ply==1){
               
               lockCardtoPressDoubl(btnMirror);
               String s= btnMirror.getText();
               //RandomPlayerlis.get(1).setText(s);
              
              
              if(btnMirror.getText().equals("Chor")||btnMirror.getText().equals("Dakat")){
             
             rotateCard(id,btnMirror,Color.BLUE,RandomPlayerlis.get(1),Color.YELLOW,s,RandomLabelList.get(1));
            // btnMirror.setTextFill(Color.BLUE);
             // RandomPlayerlis.get(1).setTextFill(Color.YELLOW);
             
              //Player2.setBackground(background);
             }
             else{
                
                 // RandomPlayerlis.get(1).setTextFill(Color.BLACK);
                 
                 rotateCard(id,btnMirror,Color.WHITE,RandomPlayerlis.get(1),Color.BLACK,s,RandomLabelList.get(1));
                 //btnMirror.setTextFill(Color.WHITE);
               
             }
               ply++; 
           }
           else if(ply==2){
              
              lockCardtoPressDoubl(btnMirror);
              String s= btnMirror.getText();
             // RandomPlayerlis.get(2).setText(s);
              
             
             if(btnMirror.getText().equals("Chor")||btnMirror.getText().equals("Dakat")){
              
               rotateCard(id,btnMirror,Color.BLUE,RandomPlayerlis.get(2),Color.YELLOW,s,RandomLabelList.get(2));
             // btnMirror.setTextFill(Color.BLUE);
              // RandomPlayerlis.get(2).setTextFill(Color.YELLOW);
             
              //Player3.setBackground(background);
             }
             else{
                 
                  //RandomPlayerlis.get(2).setTextFill(Color.BLACK);
                 
                  rotateCard(id,btnMirror,Color.WHITE,RandomPlayerlis.get(2),Color.BLACK,s,RandomLabelList.get(2));
                 //btnMirror.setTextFill(Color.WHITE);
                 
                
             }
               ply++;
           }
          else if(ply==3){
              
              String s= btnMirror.getText();
              // RandomPlayerlis.get(3).setText(s);
              
             
              if(btnMirror.getText().equals("Chor")||btnMirror.getText().equals("Dakat")){
             
              
              
             // RandomPlayerlis.get(3).setTextFill(Color.YELLOW);
             // Player4.setBackground(background);
              //FadeInFadeOut(btnMirror);
           
              rotateCard(id,btnMirror,Color.BLUE,RandomPlayerlis.get(3),Color.YELLOW,s,RandomLabelList.get(3));
               //btnMirror.setTextFill(Color.BLUE);
             
             }
             else{
               
               //RandomPlayerlis.get(3).setTextFill(Color.BLACK);
                //FadeInFadeOut(btnMirror);
               
                rotateCard(id,btnMirror,Color.WHITE,RandomPlayerlis.get(3),Color.BLACK,s,RandomLabelList.get(3));
                 //btnMirror.setTextFill(Color.WHITE);
              
             }
               ply++;
          }
          
       }
       //end of first round
      } 
    }
      //after completing all the player initialize making findchoractive=1 then posic can search for chor or dakat
    }
    //getting the card id and make it lock until next game is started
    public void lockCardtoPressDoubl(Button btn){
        String id=btn.getId();
         h.replace(id,false);
     }
    //function to move the card form down to up and then up to down
    public void transmition(){
        t1.setToY(-200);
        
        t1.setAutoReverse(true);
        t1.setCycleCount(2);
       
        t2.setToY(-200);
        t2.setAutoReverse(true);
        t2.setCycleCount(2);
        
        t4.setToY(-200);
        t4.setAutoReverse(true);
        t4.setCycleCount(2);
       
        t3.setToY(-200);
        t3.setAutoReverse(true);
        t3.setCycleCount(2);
       
        pt.play();
        pt.setOnFinished((e)->{
             RandomViewList.get(index).setVisible(true);
             RandomTransitionList.get(index).play();
        });
        
    }
   
    public void rotateCard(String buttonid,Button cardButton,Color r1,Button PlayerButton,Color r2,String s,Label l){
       rt.setDuration( Duration.millis(150));
       rt.setNode(cardButton);
        rt.setByAngle(720);
        //rt.setAutoReverse(true);
        rt.setCycleCount(5);
        rt.setOnFinished((e)->{
             cardButton.setTextFill(r1);
             PlayerButton.setTextFill(r2);
             PlayerButton.setText(s);
             if(s.equals("Polic")){
                 if(turnporchor==1){
                  l.setText("GUESS CHOR?");
                 }
                 if(turnporchor==0){
                  l.setText("GUESS Dakat?");
                 }
              }
           setcrossSign(buttonid);
           
           stopmultiplerotatecardatAtime=1;
           
           if(index<=3){
           RandomTransitionList.get(index).stop();
           RandomViewList.get(index).setVisible(false);
           
           index++;
             if(index<4){
                RandomViewList.get(index).setVisible(true);
                RandomTransitionList.get(index).play();}}
            
        });
        
       
        rt.play();
    }
    //clear everyting and reset
    public void clearEverithing(){
        
        bt1.setText(" ");
        bt2.setText(" ");
        bt3.setText(" ");
        bt4.setText(" ");
        //clear hashmap and cadlist and insert everyting for start again
        h.clear();
        CardList.clear();
       insertCard();
        Player1.setTextFill(Color.BLACK);
        Player2.setTextFill(Color.BLACK);
        Player3.setTextFill(Color.BLACK);
        Player4.setTextFill(Color.BLACK);
        Player1.setText("Player1");
        Player2.setText("Player2");
        Player3.setText("Player3");
        Player4.setText("Player4");
        l1.setText(" ");
        l2.setText(" ");
        l3.setText(" ");
        l4.setText(" ");
        PlayerList.clear();
        RandomPlayerlis.clear();
        
        LabelList.clear();
        RandomLabelList.clear();
        
        ViewList.clear();
        RandomViewList.clear();
        
        ScoreList.clear();
        RandomScoreList.clear();
        
        view1.setVisible(false);
        view2.setVisible(false);
        view3.setVisible(false);
        view4.setVisible(false);
        
        view11.setVisible(false);
        view12.setVisible(false);
        view13.setVisible(false);
        view14.setVisible(false);
        winOrlost.setText(" ");
        RandomTransitionList.clear();
        TansitionList.clear();
        //making the index 0 to get the starting index from randomtransition
        index=0;
        //making decision transion enable
        lockdecision=0;
        //after new start setting the arrow view to their previous position
         circle.setOpacity(0.00);
         winOrlost.setOpacity(0.00);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       //puting all the player object inside the PlayerList ArrayList
        
        
        t1.setDuration(Duration.millis(2000));
        t1.setNode(bt1);
        t2.setDuration(Duration.millis(1800));
        t2.setNode(bt2);
         
        t4.setDuration(Duration.millis(1600));
        t4.setNode(bt4);
        
        t3.setDuration(Duration.millis(1400));
        t3.setNode(bt3);
        setTransmitionforArraow();
        view11.setVisible(false);
        view12.setVisible(false);
        view13.setVisible(false);
        view14.setVisible(false);
        score1.setText("0");
        score2.setText("0");
        score3.setText("0");
        score4.setText("0");
        //keeping player in playerbutton array and scorelabel in scorearray so that they they can be store here until programme finsihed 
        PlyaerArray.add(Player1);
         PlyaerArray.add(Player2);
         PlyaerArray.add(Player3);
         PlyaerArray.add(Player4);
         
         ScoreArray.add(score1);
          ScoreArray.add(score2);
          ScoreArray.add(score3);
         ScoreArray.add(score4);
         circle.setOpacity(0.00);
         winOrlost.setOpacity(0.00);
    }   
    
    //rertun true if a card is not yet reveal otherwise false
    public boolean isTrue(Button bt){
        String s=bt.getId();
        boolean b=h.get(s);
        return b;
    }
    @FXML
    public void FindChor(ActionEvent event){
      if(lockdecision==0){
         
         
      if(ply==4){
        EventObject evo = new EventObject(event.getSource());
        Object obj = evo.getSource();
        Button btnMirror = (Button)obj;
        if(ply==4 && turnporchor==1){
           if(btnMirror.getText().equals("Chor")){
            
            winOrlost.setText("Right!");
            polisRightorWrong=1;
            
         // firstLavel=0;
         
        path.setOnFinished((e)->{
           winOrlost.setOpacity(1.00);
           circle.setOpacity(0.00);
           setPlayerTextBlack();
           setScore();
           lock=1;
           lockdecision=1;
           
           });
         
        }
           else if(btnMirror.getText().equals("Dakat")){
           
            
            winOrlost.setText("Wrong!");
            
            //firstLavel=0;
           
             polisRightorWrong=0;
             path.setOnFinished((e)->{
           
                winOrlost.setOpacity(1.00);
                circle.setOpacity(0.00);
                setPlayerTextBlack();
                setScore();
                lock=1;
                lockdecision=1;
                
                });
        }
        }
      if(ply==4 && turnporchor==0){
           if(btnMirror.getText().equals("Dakat")){
           
            winOrlost.setText("Right!");
            polisRightorWrong=1;
            
         // firstLavel=0;
            
           path.setOnFinished((e)->{
              winOrlost.setOpacity(1.00);
              circle.setOpacity(0.00);
              setPlayerTextBlack();
              setScore();
              lock=1;
              lockdecision=1;
              });
           }
            else if(btnMirror.getText().equals("Chor")){
           
           
            winOrlost.setText("Wrong!");
            
            //firstLavel=0;
           
            polisRightorWrong=0;
            path.setOnFinished((e)->{
              winOrlost.setOpacity(1.00);
              circle.setOpacity(0.00);
              setPlayerTextBlack();
              setScore();
              lock=1;
              lockdecision=1;
              }); 
        }
        }
      //calling decesion function to make decision
        
          decision();
          
        }
      
    }}
    public void setPlayerTextBlack(){
        Player1.setTextFill(Color.BLACK);
        Player2.setTextFill(Color.BLACK);
        Player3.setTextFill(Color.BLACK);
        Player4.setTextFill(Color.BLACK);
    }
    //this method will choose randomly who will take the firstCard
    public void insertingInList(){
          PlayerList.add(Player1);
          PlayerList.add(Player2);
          PlayerList.add(Player3);
          PlayerList.add(Player4);
          
          LabelList.add(l1);
          LabelList.add(l2);
          LabelList.add(l3);
          LabelList.add(l4);
          
          TansitionList.add(t5);
          TansitionList.add(t6);
          TansitionList.add(t7);
          TansitionList.add(t8);
          
          ViewList.add(view11);
          ViewList.add(view12);
          ViewList.add(view13);
          ViewList.add(view14);
          
          ScoreList.add(score1);
          ScoreList.add(score2);
          ScoreList.add(score3);
          ScoreList.add(score4);
          
          rand1=rand.nextInt(PlayerList.size());
          RandomPlayerlis.add(PlayerList.get(rand1));
          PlayerList.remove(rand1);
          
          RandomLabelList.add(LabelList.get(rand1));
          LabelList.remove(rand1);
          
          RandomTransitionList.add(TansitionList.get(rand1));
          TansitionList.remove(rand1);
          
          RandomViewList.add(ViewList.get(rand1));
          ViewList.remove(rand1);
          
          RandomScoreList.add(ScoreList.get(rand1));
          ScoreList.remove(rand1);
          
          CardList.get(rand1).setText("Babu");
          //making the textcolor of the card blue so that it can not be seen
          CardList.get(rand1).setTextFill(Color.BLUE);
          //removing the card form cardlist so that next size of the cardlist will be three
          CardList.remove(rand1);
          
          
         
        
        
          rand1=rand.nextInt(PlayerList.size());
          RandomPlayerlis.add(PlayerList.get(rand1));
          PlayerList.remove(rand1);
           
          RandomLabelList.add(LabelList.get(rand1));
          LabelList.remove(rand1);
         
          RandomTransitionList.add(TansitionList.get(rand1));
          TansitionList.remove(rand1);
          
          RandomViewList.add(ViewList.get(rand1));
          ViewList.remove(rand1);
          
          RandomScoreList.add(ScoreList.get(rand1));
          ScoreList.remove(rand1);
           
          CardList.get(rand1).setText("Polic");
          CardList.get(rand1).setTextFill(Color.BLUE);
          CardList.remove(rand1);
        
          
          
          rand1=rand.nextInt(PlayerList.size());
          RandomPlayerlis.add(PlayerList.get(rand1));
          PlayerList.remove(rand1);
          
          RandomLabelList.add(LabelList.get(rand1));
          LabelList.remove(rand1);
          
          RandomTransitionList.add(TansitionList.get(rand1));
          TansitionList.remove(rand1);
          
          RandomViewList.add(ViewList.get(rand1));
          ViewList.remove(rand1);
          
          RandomScoreList.add(ScoreList.get(rand1));
          ScoreList.remove(rand1);
          
            
          CardList.get(rand1).setText("Chor");
          CardList.get(rand1).setTextFill(Color.BLUE);
          CardList.remove(rand1);
         
          
          
          rand1=rand.nextInt(PlayerList.size());
          RandomPlayerlis.add(PlayerList.get(rand1));
          PlayerList.remove(rand1);
          
          RandomLabelList.add(LabelList.get(rand1));
          LabelList.remove(rand1);
         
          RandomTransitionList.add(TansitionList.get(rand1));
          TansitionList.remove(rand1);
          
          RandomViewList.add(ViewList.get(rand1));
          ViewList.remove(rand1);
          
          RandomScoreList.add(ScoreList.get(rand1));
          ScoreList.remove(rand1);
          
          
          CardList.get(rand1).setText("Dakat");
          CardList.get(rand1).setTextFill(Color.BLUE);
          CardList.remove(rand1);
         
    }
   
         
        public void setcrossSign(String buttonid){
            if(buttonid.equals("bt1")){
                view1.setImage(i);
                view1.setVisible(true);
            }
            else if(buttonid.equals("bt2")){
                 view2.setImage(i);
                 view2.setVisible(true);
            }
            else if(buttonid.equals("bt3")){
                view3.setImage(i);
                view3.setVisible(true);
            }
            else if(buttonid.equals("bt4")){
                view4.setImage(i);
                view4.setVisible(true);
            }
            
        }
    
    @FXML
    public void setThemeColor(){
         Color fill =picker.getValue();
         BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
         Background background = new Background(backgroundFill);
         AnchordId.setBackground(background);
    }
    //initialize the transmition for all the arrow and make theirOpacity 0
    public void setTransmitionforArraow(){
        
       
       
       t5.setDuration(Duration.millis(100));
       t5.setNode( view11);
       t5.setToX(-40);
       t5.setAutoReverse(true);
       t5.setCycleCount(10);
        
       t6.setDuration(Duration.millis(100));
       t6.setNode(view12);
       t6.setToX(40);
       t6.setAutoReverse(true);
        t6.setCycleCount(10);
         
       t7.setDuration(Duration.millis(100));
       t7.setNode(view13);
       t7.setToX(-40);
       t7.setAutoReverse(true);
       t7.setCycleCount(10);
        
       t8.setDuration(Duration.millis(100));
       t8.setNode(view14);
       t8.setToX(40);
       t8.setAutoReverse(true);
       t8.setCycleCount(10);
      }
    public void setScore(){
         bt1.setTextFill(Color.WHITE);
         bt2.setTextFill(Color.WHITE);
         bt3.setTextFill(Color.WHITE);
         bt4.setTextFill(Color.WHITE);
        //section cheeking for player
     for(int i=0;i<PlyaerArray.size();i++){
         
        if(PlyaerArray.get(i).getText().equals("Babu")){
            
            int a= Integer.parseInt(ScoreArray.get(i).getText())+100;
            ScoreArray.get(i).setText(String.valueOf(a));
        }
        else if(PlyaerArray.get(i).getText().equals("Polic")){
            if(polisRightorWrong==1){
              
               int a= Integer.parseInt(ScoreArray.get(i).getText())+90;
            ScoreArray.get(i).setText(String.valueOf(a));
            }
            else if(polisRightorWrong==0){
                 int a= Integer.parseInt(ScoreArray.get(i).getText())+0;
            ScoreArray.get(i).setText(String.valueOf(a));
            }
        }
        else if(PlyaerArray.get(i).getText().equals("Chor")){
            if(polisRightorWrong==0){
              
               int a= Integer.parseInt(ScoreArray.get(i).getText())+70;
            ScoreArray.get(i).setText(String.valueOf(a)); 
            }
            if(polisRightorWrong==1 && turnporchor==1){
               
                int a= Integer.parseInt(ScoreArray.get(i).getText())+0;
            ScoreArray.get(i).setText(String.valueOf(a)); 
            }
            if(polisRightorWrong==1 && turnporchor==0){
              
                 int a= Integer.parseInt(ScoreArray.get(i).getText())+70;
            ScoreArray.get(i).setText(String.valueOf(a)); 
            }
        }
         else if(PlyaerArray.get(i).getText().equals("Dakat")){
            if(polisRightorWrong==0){
              
                int a= Integer.parseInt(ScoreArray.get(i).getText())+80;
            ScoreArray.get(i).setText(String.valueOf(a)); 
            }
            if(polisRightorWrong==1 && turnporchor==0){
               
                int a= Integer.parseInt(ScoreArray.get(i).getText())+0;
            ScoreArray.get(i).setText(String.valueOf(a));
            }
            if(polisRightorWrong==1 && turnporchor==1){
               
               int a= Integer.parseInt(ScoreArray.get(i).getText())+80;
            ScoreArray.get(i).setText(String.valueOf(a));
            }
        }
      }
    }
    //this will decide wrong or right
    public void decision(){
       Rectangle c=new Rectangle(200,200);
       lock=0;
       circle.setOpacity(1.00);
       path.setNode(circle);
       path.setDuration(Duration.millis(800));
       path.setCycleCount(6);
       path.setPath(c);
       path.play();
       
      
       
       
    }
   
}
