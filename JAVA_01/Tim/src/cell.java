
public class cell {
int x;
int y;
cell left;
cell up;
cell right;
cell bottom;
cell parent;
public cell(int x,int y)
{
	this.x = x;
	this.y = y;
	this.left = null;
	this.right = null;
	this.up = null;
	this.bottom = null;
	this.parent  = null;
}
}
