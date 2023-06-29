package View.GUI.USER;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import View.GUI.MAINGUI;

public class UserUI  extends JFrame implements ActionListener{

	
	JButton 도서조회_btn;
	JButton 대여확인_btn;
	JButton 나의정보_btn;
	JButton 로그아웃_btn;

	MAINGUI maingui;
	
	public UserUI(){
		super("USER UI");
		setBounds(10, 10, 250, 130);

		// 패널
		JPanel panel = new JPanel();
		panel.setLayout(null);

		
		// 
		도서조회_btn = new JButton("도서조회");
		대여확인_btn = new JButton("대여확인");
		나의정보_btn = new JButton("나의정보");
		로그아웃_btn = new JButton("로그아웃");
		
		//
		도서조회_btn.setBounds(10,10,100,30);
		대여확인_btn.setBounds(120,10,100,30);
		나의정보_btn.setBounds(10,50,100,30);
		로그아웃_btn.setBounds(120,50,100,30);

		
		//
		도서조회_btn.addActionListener(this);
		대여확인_btn.addActionListener(this);
		나의정보_btn.addActionListener(this);
		
		
		//
		panel.add(도서조회_btn);
		panel.add(대여확인_btn);
		panel.add(나의정보_btn);
		panel.add(로그아웃_btn);
		
		
		
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(false);
		
		
		//x버튼에 대한 이벤트 처리
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	// 로그아웃 처리
            	// 메인 창 활성화
            	maingui.setVisible(true);
            }
        });
	}
	

	public void setMainUI(MAINGUI maingui) {
		this.maingui = maingui;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
