package baiTapLon;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class tictactoe  implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame("TicTacToe");
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel header = new JLabel();
    JButton newGame_bt = new JButton("New Game");
    int countX =0, countO =0;
    JButton scoreX = new JButton("Score X : 0");
    JButton scoreO = new JButton("Score O : 0" );
    
    JButton[] buttons = new JButton[9];
    int  player1_turn = 2;
    int Xwin = 2;
    
    tictactoe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

		
        newGame_bt.setLayout(new BorderLayout());
        newGame_bt.setSize(100,95);
        newGame_bt.setLocation(0,0);
        newGame_bt.addActionListener(this);

        scoreX.setLayout(new BorderLayout());
        scoreX.setSize(120,47);
        scoreX.setLocation(100, 0);
        scoreX.setFont(new Font("Ink Free", Font.BOLD, 13));
        scoreX.setForeground(new Color(255, 0, 34));        
        scoreX.setBackground(new Color(255, 247, 168));



        scoreO.setLayout(new BorderLayout());
        scoreO.setSize(120,47);
        scoreO.setLocation(100, 47);
        scoreO.setFont(new Font("Ink Free", Font.BOLD, 13));
        scoreO.setForeground(new Color(255, 0, 34));        
        scoreO.setBackground(new Color(255, 247, 168));


        header.setSize(700,100);
        header.setForeground(new Color(0, 144, 255));
        header.setFont(new Font("Ink Free", Font.BOLD,75));
        header.setHorizontalAlignment(JLabel.RIGHT);
        header.setText("TicTacToe");
        header.setOpaque(true);
        header.setBackground(new Color(255, 170, 0));

        


        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,700,200);

        button_panel.setLayout(new GridLayout(3,3));
        

        for(int i=0; i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setBackground(new Color(243,255,86));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        header.add(newGame_bt);
        header.add(scoreX);
        header.add(scoreO);
        title_panel.add(header);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e){

        // khi click v??o ?? c???
        for(int i=0; i<9; i++){
            //check Win
            if(e.getSource()==buttons[i]){
                if(player1_turn==1){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=0;
                        header.setText("O turn");
                        Draw();
                        check();
                    }
                }
                else if(player1_turn == 0){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=1;
                        header.setText("X turn");
                        Draw();
                        check();
                    }
                }
            }
        }
 
       
        //khi click newGame
        if(e.getSource()==newGame_bt){
            for(int i =0; i<9; i++){
                if(buttons[i].getText()=="X" || buttons[i].getText()=="O" || buttons[i].getText()==""){
                    buttons[i].setText("");
                    buttons[i].setBackground(new Color(243,255,86));
                    buttons[i].setEnabled(true);
                }
            }
            if(Xwin== 1){
             countX++;
             scoreX.setText("Score X : "+ countX);
             player1_turn=0;                  //X win th?? O ????nh tr?????c
             header.setText("O turn");
            }
            else if(Xwin==0){
             countO++;
             scoreO.setText("Score O : "+ countO);
             player1_turn=1;                  //O win th?? X ????nh tr?????c
             header.setText("X turn");
            }
            else {
                ranDom(); //random l?????t ch??i ti???p n???u h??a c???
            }
             Xwin =2;// set Default Value
           
        }
    }

    public void ranDom(){
        if(random.nextInt(2)==1){
            player1_turn= 1;
            header.setText("X turn");
        }
        else{
            player1_turn= 0;
            header.setText("O turn");
        }
    }

    

    //l?????t ch??i ?????u ti??n Random
    public void firstTurn(){
        //d??ng ch??? "TicTacToe" hi???n th??? 2s r???i t???t
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //random l?????t ch??i ?????u ti??n
        ranDom();
    }


    //ki???m tra X th???ng hay O th???ng
    public void check(){
        //check X win
            if((buttons[0].getText()=="X") && 
               (buttons[1].getText()=="X") &&
               (buttons[2].getText()=="X")
               ){
                xWins(0,1,2);
               }
            if((buttons[3].getText()=="X") && 
               (buttons[4].getText()=="X") &&
               (buttons[5].getText()=="X")
               ){
                xWins(3,4,5);
               }
            if((buttons[6].getText()=="X") && 
               (buttons[7].getText()=="X") &&
               (buttons[8].getText()=="X")
               ){
                xWins(6,7,8);
               }
            if((buttons[0].getText()=="X") && 
               (buttons[3].getText()=="X") &&
               (buttons[6].getText()=="X")
               ){
                xWins(0,3,6);
               }
            if((buttons[1].getText()=="X") && 
               (buttons[4].getText()=="X") &&
               (buttons[7].getText()=="X")
               ){
                xWins(1,4,7);
               }
            if((buttons[2].getText()=="X") && 
               (buttons[5].getText()=="X") &&
               (buttons[8].getText()=="X")
               ){
                xWins(2,5,8);
               }
            if((buttons[0].getText()=="X") && 
               (buttons[4].getText()=="X") &&
               (buttons[8].getText()=="X")
               ){
                xWins(0,4,8);
               }
            if((buttons[2].getText()=="X") && 
               (buttons[4].getText()=="X") &&
               (buttons[6].getText()=="X")
               ){
                xWins(2,4,6);
               }
    
            //check O win
            if((buttons[0].getText()=="O") && 
               (buttons[1].getText()=="O") &&
               (buttons[2].getText()=="O")
               ){
                oWins(0,1,2);
               }
            if((buttons[3].getText()=="O") && 
               (buttons[4].getText()=="O") &&
               (buttons[5].getText()=="O")
               ){
                oWins(3,4,5);
               }
            if((buttons[6].getText()=="O") && 
               (buttons[7].getText()=="O") &&
               (buttons[8].getText()=="O")
               ){
                oWins(6,7,8);
               }
            if((buttons[0].getText()=="O") && 
               (buttons[3].getText()=="O") &&
               (buttons[6].getText()=="O")
               ){
                oWins(0,3,6);
               }
            if((buttons[1].getText()=="O") && 
               (buttons[4].getText()=="O") &&
               (buttons[7].getText()=="O")
               ){
                oWins(1,4,7);
               }
            if((buttons[2].getText()=="O") && 
               (buttons[5].getText()=="O") &&
               (buttons[8].getText()=="O")
               ){
                oWins(2,5,8);
               }
            if((buttons[0].getText()=="O") && 
               (buttons[4].getText()=="O") &&
               (buttons[8].getText()=="O")
               ){
                oWins(0,4,8);
               }
            if((buttons[2].getText()=="O") && 
               (buttons[4].getText()=="O") &&
               (buttons[6].getText()=="O")
               ){
                oWins(2,4,6);
               }
            
        }

    // tr?????ng h???p h??a c???
    public void Draw(){
        if( ((buttons[0].getText()=="O")||(buttons[0].getText()=="X")) &&
            ((buttons[1].getText()=="O")||(buttons[1].getText()=="X")) &&
            ((buttons[2].getText()=="O")||(buttons[2].getText()=="X")) &&
            ((buttons[3].getText()=="O")||(buttons[3].getText()=="X")) &&
            ((buttons[4].getText()=="O")||(buttons[4].getText()=="X")) &&
            ((buttons[5].getText()=="O")||(buttons[5].getText()=="X")) &&
            ((buttons[6].getText()=="O")||(buttons[6].getText()=="X")) &&
            ((buttons[7].getText()=="O")||(buttons[7].getText()=="X")) &&
            ((buttons[8].getText()=="O")||(buttons[8].getText()=="X"))
            ){
                for(int i=0; i<9; i++){
                    buttons[i].setEnabled(false);
                }
                header.setText("Draw");
                Xwin=2;
            }
    }

    // khi X th???ng
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        header.setText("X Wins");
        Xwin=1;
    }

    // khi O th???ng
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        header.setText("O Wins");
        Xwin=0;
    }

}
