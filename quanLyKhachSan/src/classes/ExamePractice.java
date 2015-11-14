package classes;
import java.awt.*;// giao dien
import java.awt.event.*;// su kien
class CuaSoChinh extends  Frame{// dung de hien thi cua so chuong trinh chinh
		public CuaSoChinh(String title){
			super(title);
			HienThiCardLayOut ht=new HienThiCardLayOut();
			add(ht);
			add(new NutThaoTac(ht), BorderLayout.SOUTH);
			setSize(500,500);
			setLocationRelativeTo(null);
		    setVisible(true); 
			}
	}
class CauHoi extends Panel{ // dung de hien thi cau hoi va cau tra loi
		Checkbox chTraloi[];
		CheckboxGroup g;
		public static int diem=0;
		Label lbCauhoi;
	 public CauHoi(String cauhoi, String[] cautraloi, int[] phuongandung, boolean kieu){
	 		chTraloi=new Checkbox[cautraloi.length];// khoi tao vung nho cho mang check = so cau tra loi	
	 		setLayout(new GridLayout(cautraloi.length+1, 1)); // so hang bang tong so cau tra loi +1 danh cho cau hoi
	 		add(lbCauhoi=new Label(cauhoi+"("+ phuongandung.length+")"));
	 		lbCauhoi.setForeground(Color.BLUE);
	 		g=new CheckboxGroup();
	 	for (int i = 0; i<chTraloi.length; i++){
	 			if(kieu){
	 			chTraloi[i]=new Checkbox(cautraloi[i]);
	 			tinhDiem(chTraloi[i], i, phuongandung);
	 			}	else{
	 			
	 			chTraloi[i]=new Checkbox(cautraloi[i], g, false);	
	 				tinhDiem(chTraloi[i], i, phuongandung);
	 				}
		 	add(chTraloi[i]);
		 }
	 	}
	 	public void tinhDiem(final Checkbox ch, final int vitri, final int phuongan[]){
	 		ch.addItemListener(new ItemListener(){
	 			public void itemStateChanged(ItemEvent e){
				 if(ch.getState()){
				 		for (int i = 0; i<phuongan.length; i++){
				 		if(vitri==phuongan[i]){
				 			CauHoi.diem+=1;
				 			ch.disable();
				 			break;
				 			}
				 		}
				 	}				 }
	 			});
	 		}
	}
class HienThiCardLayOut extends Panel{ // hien thi tung mat cua cau hoi
	Panel p1, p2,p3;
	CardLayout cl;
	public HienThiCardLayOut(){
		setLayout(cl=new CardLayout());
		p1=new Panel();// mat 1
		p1.setLayout(new GridLayout(2,1));
		p1.add(new CauHoi("1/ Which the language do you like?", new String[]{"Java", "C++", "Oracle", "C#"}, new int[]{1,3}, true));
		p1.add(new CauHoi("2/ How do yoi few Java language?", new String[]{"Difficult", "Easy"}, new int[]{1}, false));
		
		p2=new Panel();// mat 2
		p2.setLayout(new GridLayout(2,1));
		p2.add(new CauHoi("3/ What is the Java?", new String[]{"Programming Language", "OOP", "Tool"}, new int[]{1}, true));
		p2.add(new CauHoi("4/ What are you doing with Java?", new String[]{"Code", "Design"}, new int[]{1}, false));
			
		p3=new Panel();// mat 2
		p3.setLayout(new GridLayout(2,1));
		p3.add(new CauHoi("5/ Who is creative Java?", new String[]{"Gosling", "Wirth", "Paue","Jobs"}, new int[]{1,2,3}, true));
		p3.add(new CauHoi("6/ Who is teach Java form JavaOracl center?", new String[]{"Mr Thach", "Mr Quang", "Mr Minh"}, new int[]{1,2}, false));
			
	
		add("1", p1);
		add("2", p2);
		add("3", p3);
		}	
		public void nextCauMat(){
			this.cl.next(this);
			}
			
		public void firstCauMat(){
			this.cl.first(this);
			}
			
		public void prevCauMat(){
			this.cl.previous(this);
			}
			
		public void lastCauMat(){
			this.cl.last(this);
			}
		}
class NutThaoTac extends  Panel implements ActionListener{ // hien thi 4 nut
			Button N, P, F, L;
			HienThiCardLayOut ht;
			Button finish;
			Label hienthidiem;
			public NutThaoTac(HienThiCardLayOut ht){
				this.ht=ht;
				add(F=new Button("First"));
				add(P=new Button("Prev"));
				add(N=new Button("Next"));
				add(L=new Button("Last"));
				add(finish=new Button("Finish"));
				finish.setForeground(Color.RED);
				add(hienthidiem=new Label("                      "));
				hienthidiem.setForeground(Color.red);
				hienthidiem.setFont(new Font("arial", Font.BOLD, 18));
				N.addActionListener(this);
				F.addActionListener(this);
				P.addActionListener(this);
				L.addActionListener(this);
				finish.addActionListener(this);
				}
		public void actionPerformed(ActionEvent e){
	    	 		if(e.getSource()==N){
	    	 			ht.nextCauMat();
	    	 			}else if(e.getSource()==F){
	    	 				ht.firstCauMat();
	    	 				}else if(e.getSource()==P){
	    	 					ht.prevCauMat();
	    	 					}else if(e.getSource()==L)		{
	    	 						ht.lastCauMat();
	    	 						}else if(e.getSource()==finish){
	    	 							hienthidiem.setText("Tong diem="+CauHoi.diem);
	    	 							
	    	 							}
	    }
	    	
	}	
class MainPro{ // chi goi ham Main de chay chuong trinh
	public static void main(String[] a){
    	new CuaSoChinh("Discuss you study!");
    }
	}	
