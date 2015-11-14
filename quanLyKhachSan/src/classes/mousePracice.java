import java.awt.*;
import java.awt.event.*;
class mousePracice extends Frame implements MouseListener{
	Button bt;
	public mousePracice(){
		this.addMouseListener(this);
		setSize(300,500);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setVisible(true);
		
		bt = new Button("kich zo e");
		bt.addMouseListener(this);
		add(bt);
	}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource() ==  bt)
			System.out.println ("da click e");
	}
	public void mousePressed(MouseEvent e){
		
	}
	public void mouseReleased(MouseEvent e){
		
	}
	public void mouseEntered(MouseEvent e){
		System.out.println ("vao");
		
	} 
	public void mouseExited(MouseEvent e){
		System.out.println ("ra");
	}
	public static void main (String[] args) {
    
    new mousePracice();
    }
}