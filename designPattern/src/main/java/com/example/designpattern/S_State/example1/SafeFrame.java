package com.example.designpattern.S_State.example1;

import com.example.designpattern.S_State.example1.clazz.DayState;
import com.example.designpattern.S_State.example1.interfaces.Context;
import com.example.designpattern.S_State.example1.interfaces.State;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener,Context{
    private TextField textClock=new TextField(60);
    private TextArea textScreen=new TextArea(10,60);
    private Button buttonUse=new Button("使用金库");
    private Button buttonAlarm=new Button("按下警铃");
    private Button buttonPhone=new Button("正常通话");
    private Button buttonExit=new Button("结束");
    private State state= DayState.getInstance();

    public SafeFrame(String title){
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        add(textClock,BorderLayout.NORTH);
        textClock.setEditable(false);
        add(textScreen,BorderLayout.CENTER);
        textScreen.setEditable(false);
        Panel panel=new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        add(panel,BorderLayout.SOUTH);
        pack();
        show();
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    @Override
    public void setClock(int hour) {
        String clockString="现在时间是：";
        if(hour<10){
            clockString+="0"+hour+":00";
        }else{
            clockString+=hour+":00";
        }
        System.out.println(clockString);
        textClock.setText(clockString);
        state.doClock(this,hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println("从"+this.state+"状态变为："+state+"状态");
        this.state=state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call!"+msg+"\n");
    }

    @Override
    public void recordLog(String msg) {
        textScreen.append("record..."+msg+"\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if(e.getSource()==buttonUse){
            state.doUse(this);
        }else if(e.getSource()==buttonAlarm){
            state.doAlarm(this);
        }else if(e.getSource()==buttonPhone){
            state.doPhone(this);
        }else if(e.getSource()==buttonExit){
            System.exit(0);
        }else{
            System.out.println("?");
        }
    }
}
