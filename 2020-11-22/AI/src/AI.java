import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y;
	int leftflag,rightflag,upflag,downflag;
	Image currentImg;
	Image heroImg[][]=new Image[4][3];
	//4个方向各3张图片，0表示left、1表示right、2表示up、3表示down
	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			currentImg=heroImg[3][1];
			x=120;
			y=100;
			leftflag=1;
			rightflag=1;
			upflag=1;
			downflag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(102,220,12);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
		
	}
	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		    if(action==LEFT)
			{
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
		    	if(leftflag==1)
				{
	    	    	currentImg=heroImg[0][0];
			        leftflag++;

				}
		    	else if(leftflag==2)
				{
	                currentImg=heroImg[0][2];
					leftflag=1;
				}
			x=x-1;
		}

			if(action==RIGHT)
			{
				if(rightflag==1)
				{
			        currentImg=heroImg[1][0];
		        	rightflag=2;
				}
				else if (rightflag==2)
				{
	                currentImg=heroImg[1][2];
					rightflag=1;
				}
			x=x+1;		
			}
		    if(action==UP)
			{
			 if(upflag==1)
				{
		    	currentImg=heroImg[2][0];
			    upflag=2;
				}
			 else if(upflag==2)
				{
	                currentImg=heroImg[2][2];
					upflag=1;
				}
			y=y-1;
			}
			if(action==DOWN)
			{
				if(downflag==1)
				{
	      		    currentImg=heroImg[3][0];
		    	    downflag=2;
				}
				else if(downflag==2)
				{
	                currentImg=heroImg[3][2];
					downflag=1;
				}
			y=y+1;
			}
			repaint();
	}
}